angular.module('screenshot.controllers', [])

    .controller('ScreenshotCtrl', function($scope, $location, $modal, $timeout, ImageFactory, UserFactory) {

        $scope.reset_btn = function() {
            $timeout.cancel($scope.timeout);
            $scope.btn = {
                title: "Take screenshot",
                style: "btn btn-primary",
                active: true
            };
        };

        $scope.set_error = function() {
            $scope.btn = {
                title: "Screenshot failed!",
                style: "btn btn-danger",
                active: true
            };
        };

        $scope.set_success = function() {
            $scope.btn = {
                title: "Screenshot saved!",
                style: "btn btn-success",
                active: false
            };
            $scope.timeout = $timeout(function(){
                $scope.reset_btn();
            }, 2000);
        };

        $scope.set_in_progress = function() {
            $scope.btn = {
                title: "Storing screenshot",
                style: "btn btn-primary disabled",
                active: false
            }
        };

        $scope.store_image = function() {
            if (!$scope.btn.active) {
                return;
            }

            $scope.reset_data();
            $scope.set_in_progress();

            html2canvas(document.body, {
                onrendered: function(canvas) {
                    $scope.image.image = canvas.toDataURL("image/png");
                    $scope.data_check('html2canvas');
                }
            });
        };

        $scope.reset_data = function() {
            $scope.reset_btn();
            $scope.status = {
                modal: false,
                html2canvas: false,
                user: false
            };

            $scope.image = {
                image: null,
                title: null,
                description: null,
                url: $location.absUrl(),
                username: null
            };

            UserFactory.get(function(result) {
                $scope.image.username = result.username;
                $scope.data_check('user');
            }, function(error) {
                console.log("Failed to get userdata!");
                console.log(error);
                $scope.set_error();
            });

            $modal.open(
                {
                    templateUrl: 'title_and_description_modal.html',
                    controller: 'TitleDescriptionModalCtrl',
                    size: 'lg'
                }).result.then(
                    function(image_meta) {
                        console.log("Saving data from image_meta modal!");
                        console.log(image_meta);
                        $scope.image.title = image_meta.title;
                        $scope.image.description = image_meta.description;
                        $scope.data_check('modal');
                }, function() {
                    console.log("User dismissed image_meta modal..");
                    $scope.reset_btn();
                })
        };

        $scope.range = function(num) {
            return new Array(num);
        };

        $scope.data_check = function(mode) {
            var check_val = function(val) {
                return val != null && val != undefined && val != '';
            };

            if (mode == 'modal') {
                if (!check_val($scope.image.title) ||
                    !check_val($scope.image.description)) {
                    $scope.set_error();
                } else {
                    $scope.status.modal = true;
                }
            } else if (mode == 'html2canvas'){
                if (!check_val($scope.image.image) ||
                    !check_val($scope.image.url)) {
                    $scope.set_error();
                } else {
                    $scope.status.html2canvas = true;
                }
            } else if (mode == 'user') {
                if (!check_val($scope.image.username)) {
                    $scope.set_error();
                } else {
                    $scope.status.user = true;
                }
            }

            if ($scope.status.modal && $scope.status.html2canvas && $scope.status.user) {
                $scope.send_to_server();
            }
        };

        $scope.send_to_server = function() {
            ImageFactory.save($scope.image, function(result) {
                $scope.set_success();
                console.log(result);
            }, function(error) {
                $scope.set_error();
                console.log("Got error when saving data..");
                console.log(error);
            })
        };
        $scope.reset_btn();
    })

    .controller('TitleDescriptionModalCtrl', function($scope, $modalInstance) {
        $scope.image_meta = {
            title: "",
            description: ""
        };

        $scope.save = function() {
            $modalInstance.close($scope.image_meta);
        };

        $scope.cancel = function() {
            $modalInstance.dismiss('user clicked cancel..');
        };
    })

    .controller('GalleryCtrl', function ($scope, $modal, ImageFactory, UserFactory) {

        $scope.open = function (image, index) {
            $modal.open({
                templateUrl: 'imageslide.html',
                controller: 'ImageModalCtrl',
                size: 'lg',
                resolve: {
                    data: function () {
                        return {images: $scope.images, index: index};
                    }
                }
            }).result.then(function () {
                    console.log("modal closed..");
                }, function () {
                    console.log("modal dismissed");
                });
        };

        $scope.load_images = function() {
            UserFactory.get(function(result) {
                $scope.username = result.username;
                ImageFactory.query(function(response_data) {
                    $scope.images = response_data;
                }, function(error_data) {
                    console.log("Failed to get images from server!");
                    console.log(error_data);
                });
            }, function(error) {
                console.log("Failed to get userdata!");
                console.log(error);
            });
        };

        $scope.orderProp = 'age';
    })

    .controller('ImageModalCtrl', function ($scope, $modalInstance, data) {

        $scope.images = data.images;
        $scope.cur_index = data.index;

        $scope.cancel = function () {
            $modalInstance.close()
        };

        $scope.next = function () {
            $scope.cur_index++;
            if ($scope.cur_index >= $scope.images.length) {
                $scope.cur_index = 0;
            }
        };

        $scope.previous = function () {
            $scope.cur_index--;
            if ($scope.cur_index < 0) {
                $scope.cur_index = $scope.images.length - 1;
            }
        };
    });

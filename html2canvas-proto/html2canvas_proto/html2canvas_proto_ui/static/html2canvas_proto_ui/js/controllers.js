angular.module('html2canvas_proto.controllers', [])

    .controller('TestCtrl', function($scope, $location, $modal, ImageAsTextFactory, UserFactory) {

        $scope.store_image = function() {
            $scope.reset_data();

            html2canvas(document.body, {
                onrendered: function(canvas) {
                    $scope.image.image = canvas.toDataURL("image/png");
                    $scope.data_check();
                }
            });
            
        };

        $scope.reset_data = function() {
            $scope.image = {
                image: null,
                title: null,
                description: null,
                url: $location.absUrl(),
                username: null
            };

            UserFactory.get(function(result) {
                $scope.image.username = result.username;
                $scope.data_check();
            }, function(error) {
                console.log("Failed to get userdata!");
                console.log(error);
            });

            $modal.open(
                {
                    templateUrl: 'title_and_description_modal.html',
                    controller: 'TitleDescriptionModalCtrl',
                    size: 'lg'
                }
            ).result.then(
                function(image_meta) {
                    console.log("Saving data from image_meta modal!");
                    console.log(image_meta);
                    $scope.image.title = image_meta.title;
                    $scope.image.description = image_meta.description;
                    $scope.data_check();
            }, function() {
                console.log("User dismissed image_meta modal..");
            })
        };

        $scope.range = function(num) {
            return new Array(num);
        };

        $scope.data_check = function() {
            var check_val = function(val) {
                return val != null && val != undefined && val != '';
            };

            if (check_val($scope.image.image) &&
                    check_val($scope.image.title) &&
                    check_val($scope.image.description) &&
                    check_val($scope.image.url) &&
                    check_val($scope.image.username)) {
                $scope.send_to_server();
            } else {
                console.error("Validation failed!");
                // TODO: Proper validation!
            }
        };

        $scope.send_to_server = function() {
            ImageAsTextFactory.save($scope.image, function(result) {
                console.log("Saved image!");
                console.log(result);
            }, function(error) {
                console.log("Got error when saving data..");
                console.log(error);
            })
        }
    })

    .controller('TitleDescriptionModalCtrl', function($scope, $modalInstance) {
        $scope.image_meta = {
            title: "",
            description: ""
        };

        $scope.save = function() {
            console.log("Closing modal!");
            console.log("Data:");
            console.log($scope.image_meta);
            $modalInstance.close($scope.image_meta);
        };

        $scope.cancel = function() {
            $modalInstance.dismiss('user clicked cancel..');
        };
    })

    .controller('SliderController', function ($scope, $modal, ImageFactory) {

        $scope.open = function (image, index) {

            $modal.open({
                templateUrl: 'imageslide.html',
                controller: 'ImgCtrl',
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
            ImageFactory.query(function(response_data) {
               $scope.images = response_data;
            }, function(error_data) {
                console.log("Failed to get images from server!");
                console.log(error_data);
            });
        };

        $scope.orderProp = 'age';
    })

    .controller('ImgCtrl', function ($scope, $modalInstance, data) {

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

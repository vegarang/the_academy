angular.module('sliderApp.controllers', [])
    .controller('SliderController', function ($scope, $modal) {

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

        $scope.images = [
            {
                src: 'img/dv3.png',
                title: 'Img 1',
                description: "Some description here",
                url: 'www.example.com/north/pole',
                date: '2014-12-24',
                username: 'julenissen'
            }, {
                src: 'img/gis4.png',
                title: 'Img 2',
                description: "description here",
                url: 'www.example.com/is/it/a/bird?or&a&plane',
                date: '1950-01-01',
                username: 'superman'
            }, {
                src: 'img/gis5.png',
                title: 'Img 3',
                description: "Other description here",
                url: 'www.example.com/na/na/na/',
                date: '2014-01-01',
                username: 'batman'
            }


            , {
                src: 'img/gis5.png',
                title: 'Img 3',
                description: "Other description here",
                url: 'www.example.com/na/na/na/',
                date: '2014-01-01',
                username: 'batman'
            }

               
             , {
                src: 'img/gis5.png',
                title: 'Img 3',
                description: "Other description here",
                url: 'www.example.com/na/na/na/',
                date: '2014-01-01',
                username: 'batman'
            } 


            , {
                src: 'img/gis5.png',
                title: 'Img 3',
                description: "Other description here",
                url: 'www.example.com/na/na/na/',
                date: '2014-01-01',
                username: 'batman'
            }


            , {
                src: 'img/gis5.png',
                title: 'Img 3',
                description: "Other description here",
                url: 'www.example.com/na/na/na/',
                date: '2014-01-01',
                username: 'batman'
            }

    

        ];
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


// angular.module('ui.bootstrap.demo').controller('CarouselDemoCtrl', function ($scope) {
//   $scope.myInterval = 0;
//   var slides = $scope.slides = [];
//   $scope.addSlide = function() {
//     var newWidth = 600 + slides.length + 1;
//     slides.push({
//       image: 'http://placekitten.com/' + newWidth + '/300',

//     });
//   };
//   for (var i=0; i<4; i++) {
//     $scope.addSlide();
//   }
// });
// ;


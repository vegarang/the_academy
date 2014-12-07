angular.module('sliderApp.controllers',[])
.controller('SliderController', function($scope,$modal) {
    
    $scope.open = function(image,index) {

        $modal.open({
            templateUrl:'imageslide.html',
            controller: 'ImgCtrl',
            resolve: {
                image: function () {
                    return $scope.images[index];
                }
            }
        }).result.then(function(){
            console.log("modal closed..");
        }, function() {
            console.log("modal dismissed");
        });
    }
    
    $scope.images=[
        {
            src:'img/dv3.png',
            title:'Pic 1',
            active: false
        },{
            src:'img/gis4.png',
            title:'Pic 2',
            active: false
        },{
            src:'img/gis5.png',
            title: 'Pic 3',
            active: false
        },{
            src:'img/dv3.png',
            title:'Pic 1',
            active: false
        },{
            src:'img/gis4.png',
            title:'Pic 2',
            active: false
        },{
            src:'img/gis5.png',
            title: 'Pic 3',
            active: false
        },{
            src:'img/dv3.png',
            title:'Pic 1',
            active: false
        },{
            src:'img/gis4.png',
            title:'Pic 2',
            active: false
        },{
            src:'img/gis5.png',
            title: 'Pic 3',
            active: false
        },{
            src:'img/dv3.png',
            title:'Pic 1',
            active: false
        },{
            src:'img/gis4.png',
            title:'Pic 2',
            active: false
        },{
            src:'img/gis5.png',
            title: 'Pic 3',
            active: false
        },{
            src:'img/dv3.png',
            title:'Pic 1',
            active: false
        },{
            src:'img/gis4.png',
            title:'Pic 2',
            active: false
        },{
            src:'img/gis5.png',
            title: 'Pic 3',
            active: false
        },{
            src:'img/dv3.png',
            title:'Pic 1',
            active: false
        },{
            src:'img/gis4.png',
            title:'Pic 2',
            active: false
        },{
            src:'img/gis5.png',
            title: 'Pic 3',
            active: false
        }
    ];
})

.controller('ImgCtrl',function($scope,$modalInstance,image) {


    $scope.image = image;
    
    $scope.cancel = function() {
        $modalInstance.close()

    }

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


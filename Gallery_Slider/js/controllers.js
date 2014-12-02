
angular.module('sliderApp.controllers', 'ngAnimate',[]).controller('SliderController', function($scope) {
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


      $scope.open = function (size) {
      var modalInstance = $modal.open({
      templateUrl: 'imageslide.html',
      controller: 'ImgCtrl',
      image.active = true,
      size: size,
      resolve: {
        items: function () {
          return $scope.images;
        }
      }
    });

    }
});











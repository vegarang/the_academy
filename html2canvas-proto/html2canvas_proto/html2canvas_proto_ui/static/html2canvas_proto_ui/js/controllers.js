angular.module('html2canvas_proto.controllers', [])

.controller('TestCtrl', function($scope, ImageAsTextFactory) {

        $scope.store_image = function() {
            html2canvas(document.body, {
                onrendered: function(canvas) {
                    ImageAsTextFactory.save({image: canvas.toDataURL("image/png")}, function(response){
                        console.log('Saved image!');
                    });
                }
            });
        };

        $scope.range = function(num) {
            return new Array(num);
        };

//        $scope.init();
    })

.controller('SliderController', function($scope) {
    $scope.images=[
        {
            src:'img/dv3.png',
            title:'Pic 1'
        },{
            src:'img/gis4.png',
            title:'Pic 2'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/dv3.png',
            title:'Pic 1'
        },{
            src:'img/gis4.png',
            title:'Pic 2'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/dv3.png',
            title:'Pic 1'
        },{
            src:'img/gis4.png',
            title:'Pic 2'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/dv3.png',
            title:'Pic 1'
        },{
            src:'img/gis4.png',
            title:'Pic 2'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/dv3.png',
            title:'Pic 1'
        },{
            src:'img/gis4.png',
            title:'Pic 2'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/dv3.png',
            title:'Pic 1'
        },{
            src:'img/gis4.png',
            title:'Pic 2'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        },{
            src:'img/gis5.png',
            title: 'Pic 3'
        }
    ];

    $scope.showAlert = function(imagetitle) {
        alert("You clicked image "+ imagetitle);
    }
});

angular.module('sliderApp.controllers', 'ngAnimate',[])

.controller('SliderController', function($scope) {
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

$scope.showAlert = function(image) {
        alert("You clicked image "+ image.title); // I want to be a modal when I grow up.. Can you help me?
        /*
            This is where image.active should be set to true, and a modal (with a carousel) should be opened.
            image.active = true;
         */
    }

    
});




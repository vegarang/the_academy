var sliderApp=angular.module('sliderApp',['ngAnimate']);

sliderApp.controller('SliderController', function($scope) {
    $scope.images=[{src:'dv3.png',title:'Pic 1'},{src:'gis4.png',title:'Pic 2'},{src:'gis5.png'}]; 
});
 
sliderApp.directive('slider', function ($timeout) {
  return {
    restrict: 'AE',
	replace: true,
	scope:{
		images: '='
	},
    link: function (scope, elem, attrs) {
	
		scope.currentIndex=0;

		scope.next=function(){
			scope.currentIndex<scope.images.length-1?scope.currentIndex++:scope.currentIndex=0;
		};
		
		scope.prev=function(){
			scope.currentIndex>0?scope.currentIndex--:scope.currentIndex=scope.images.length-1;
		};
		
		scope.$watch('currentIndex',function(){
			scope.images.forEach(function(image){
				image.visible=false;
			});
			scope.images[scope.currentIndex].visible=true;
		});
			
    },
	templateUrl:'templates/templateurl.html'
  }
});

var PhotosCtrl = function ($scope) {

	$scope.photos = [
    {src:'dv3.png',title:'Pic 1'},{src:'gis4.png',title:'Pic 2'},{src:'gis5.png'} 
	];

}
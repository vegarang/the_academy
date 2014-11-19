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

var phonecatApp = angular.module('phonecatApp', []);
phonecatApp.controller('PhoneListCtrl', function ($scope,$http) {
  $http.get('phones/phones.json').success(function(data) {
    $scope.phones = data;
    //$scope.phones = data.splice(0, 5);
  });

  $scope.name = "World";
  $scope.orderProp = 'age';
});

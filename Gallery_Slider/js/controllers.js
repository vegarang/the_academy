
var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('PhoneListCtrl', function ($scope,$http) {
  $http.get('phones/phones.json').success(function(data) {
    $scope.phones = data;
    //$scope.phones = data.splice(0, 5);
  });

  $scope.name = "World";
  $scope.orderProp = 'age';
});

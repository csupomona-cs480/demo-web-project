// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('GpsCtrl', function ($scope, $http) {

  $scope.loadGpsItems = function() {
	  $http.get("fall18/gps/list")
	  	.success(function(data){
	  		$scope.gpsItems = data;
	  	});
  }

  $scope.loadGpsItems();

});
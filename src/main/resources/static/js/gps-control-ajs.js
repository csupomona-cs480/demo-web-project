// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('GpsCtrl', function ($scope, $http) {

  $scope.loadGpsProducts = function() {
	  $http.get("cs480/gps/list")
	  	.success(function(data){
	  		console.log(data);
	  		$scope.gpsProducts = data;
	  	});
  }

  $scope.loadGpsProducts();

});
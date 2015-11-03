// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('GPSApp', []);

cs480App.controller('GPSCtrl', function ($scope, $http) {

  $scope.loadUsers = function() {
	  $http.get("gps/list")
	  	.success(function(data){
	  		$scope.gpsitems = data;
	  	});
  }

  $scope.loadUsers();

});
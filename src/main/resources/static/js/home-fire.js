// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('FireCtrl', function ($scope, $http) {

  $scope.loadFireItems = function() {
	  $http.get("cs580/fire/list")
	  	.success(function(data){
	  		$scope.fireItems = data;
	  	});
  }

  $scope.loadFireItems();

});
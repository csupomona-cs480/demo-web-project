// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('MaskCtrl', function ($scope, $http) {

  $scope.loadMasks = function() {
	  $http.get("cs4800/mask/list")
	  	.success(function(data){
	  		$scope.maskList = data;
	  	});
  }

  $scope.loadMasks();

});
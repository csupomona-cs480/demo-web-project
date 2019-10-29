// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('TvCtrl', function ($scope, $http) {

  $scope.loadAllTvs = function() {
	  $http.get("cs4800/tv/list")
	  	.success(function(data){
	  		$scope.alltvs = data;
	  	});
  }

  
  $scope.loadAllTvs();

});
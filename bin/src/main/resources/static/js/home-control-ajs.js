// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('UserCtrl', function ($scope, $http) {

  $scope.loadUsers = function() {
	  $http.get("cs480/users/list")
	  	.success(function(data){
	  		$scope.users = data;
	  	});
  }

  $scope.getUser = function() {
	  $http.get("cs480/user/" + $scope.userIdToSearch)
	  	.success(function(data){
	  		$scope.founduser = data;
	  	});
  }

  $scope.addUser = function() {
	  $http.post("cs480/user/" + $scope.new_id + "?name=" + $scope.new_name + "&major=" + $scope.new_major)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }

  $scope.deleteUser = function(userId) {
	  $http.delete("cs480/user/" + userId)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }

  $scope.loadUsers();

});
(function(){

	var app = angular.module('school');

	var HomeController = function($scope, $state){

		$scope.login = function(username, password){
			 $state.go('dashboard', {username:username});
		};

		$scope.register = function(){
			 $state.go('register');
		};
	};

	app.controller("HomeController", HomeController);

}());
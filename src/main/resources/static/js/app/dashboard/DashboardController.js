(function(){

	var app = angular.module('school');

	var DashboardController = function($scope, $state, $stateParams){

		$scope.username = $stateParams.username;
		$scope.var1 = 122;
		$scope.logout = function(){
			 $state.go('home');
		};
	};

	app.controller("DashboardController", DashboardController);

}());
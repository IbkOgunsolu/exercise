(function(){

	var app = angular.module('school');

	var RegisterController = function($scope, $state, RegisterService){

        $scope.createApplication = function(){
            if ($scope.createApplication.$invalid)
				return;

			RegisterService.createApplication($scope.application,
			function(data){
				console.log(data);
			}, function(data){
				console.log(data);
			});


			console.log($scope.student);
		};

		$scope.reset = function(){
            $scope.application = {};
		};

	};

	app.controller("RegisterController", RegisterController);

}());
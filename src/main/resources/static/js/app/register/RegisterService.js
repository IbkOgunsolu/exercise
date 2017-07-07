(function(){

	var app = angular.module('school');

	var RegisterService = function($http){

		var createApplication = function(application, successCallback, errorCallback){

			var req = {
			 method: 'POST',
			 url: 'http://localhost:8081/sch/api/v1/applications',
			 headers: {
			   'Content-Type': "application/json"
			 },
			 data: application
			}

			$http(req).then(successCallback, errorCallback);
			return true;
		};

		return{
			createApplication : createApplication
		};

	};

	app.factory('RegisterService', RegisterService);

})();
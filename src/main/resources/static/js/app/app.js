(function(){

	var app = angular.module('school', ['ui.router','ui.bootstrap']);

	app.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/home');

        $stateProvider
            .state('home', {
                url: '/home',
                templateUrl: 'js/app/home/home.html',
                controller: 'HomeController'
            })
            .state('index', {
                url: '/index',
                templateUrl: 'js/app/home/home.html',
                controller: 'HomeController'
            })
            .state('register', {
                url: '/register',
                templateUrl: 'js/app/register/register.html',
                controller: 'RegisterController'
            })
            .state('dashboard', {
                url: '/dashboard/:username',
                templateUrl: 'js/app/dashboard/dashboard.html',
                controller: 'DashboardController',

            });

	  });

}());



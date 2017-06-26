var app = angular.module("myApp", ['ngRoute','ngResource']);
app.config(['$routeProvider', '$locationProvider', function($routeProvider,$locationProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "includes/homeTest.html"
    }).when("/login", {
        templateUrl : "views/login.html",
        controller : 'signUpCtrl'
    }).when("/error", {
        templateUrl : "views/error.html"
    }).when("/signup", {
        templateUrl : "views/signup.html",
        controller : 'signUpCtrl'
    }).when("/addAccount", {
        templateUrl : "success.html",
        controller : 'signUpCtrl'
    })
    $locationProvider.html5Mode({
    	  enabled: true
    	});
}]);
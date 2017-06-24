var app = angular.module("myApp", ["ngRoute"]);
app.config(['$routeProvider', '$locationProvider', function($routeProvider,$locationProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "includes/homeTest.html"
    }).when("/login", {
        templateUrl : "/dropshuttl_view/views/login.html"
    }).when("/error", {
        templateUrl : "/dropshuttl_view/views/error.html"
    }).when("/signup", {
        templateUrl : "/dropshuttl_view/views/signup.html",
        controller : 'signUpCtrl'
    }).when("/addAccount", {
        templateUrl : "/dropshuttl_view/success.html",
        controller : 'signUpCtrl'
    })
    $locationProvider.html5Mode({
    	  enabled: true
    	});
}]);
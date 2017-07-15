var app = angular.module("myApp", ['ngRoute','ngResource']);
app.config(['$routeProvider', '$locationProvider',function($routeProvider,$locationProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "includes/home.html",
        controller :"globalctrl"
    }).when("/home", {
        templateUrl : "includes/home.html"
    }).when("/login", {
        templateUrl : "views/login.html",
        controller : 'signUpCtrl'
    }).when("/aboutus", {
        templateUrl : "includes/aboutus.html"
    }).when("/features", {
        templateUrl : "includes/features.html"
    }).when("/estimate", {
        templateUrl : "includes/priceestimate.html"
    }).when("/signIn", {
        templateUrl : "views/signin.html"
    }).when("/reviews", {
        templateUrl : "includes/reviews.html"
    }).when("/contact", {
        templateUrl : "includes/contactus.html"
    }).when("/signup", {
        templateUrl : "views/signup.html",
        controller : 'signUpCtrl'
    }).when("/addAccount", {
        templateUrl : "success.html",
        controller : 'signUpCtrl'
    }).when("/booknow", {
        templateUrl : "views/booknow.html",
        controller : 'bookingCtrl'
        
    }).when("/estprice",{
        templateUrl : "views/booknow.html",
         controller : 'bookingCtrl'
        	
    }).otherwise({
    	redirect: '/home'
    })
  
    $locationProvider.html5Mode({
    	  enabled: true
    	});
}]);


app.service("bookingservice", function($http, $q){
    return {
   	 getCost: function(data) {
   		 var deferred = $q.defer();

   		      $http.post('/dropshuttl/checkAvailablePrice', data,{'Content-Type': 'application/json'}).then(function onSuccess(response) {
   		    	deferred.resolve(response.data);
   		      }).catch(function onError(response) {
   			    // Handle error
   			      var data = response.data;
   			      deferred.reject(response.statusText);
   			    
   			    console.log(response.status+" "+response.statusText);
   			   

       })
   		   return deferred.promise;

   	 }
    
  }
    });
var app = angular.module("myApp", ['ngRoute','ngResource']);
app.config(['$routeProvider', '$locationProvider','$qProvider',function($routeProvider,$locationProvider,$qProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "includes/home.html",
        controller :"globalctrl"
    }).when("/home", {
        templateUrl : "includes/home.html",
        controller :"globalctrl"
    }).when("/login", {
        templateUrl : "views/login.html",
        controller : 'signUpCtrl'
    }).when("/aboutus", {
        templateUrl : "includes/aboutus.html"
    }).when("/features", {
        templateUrl : "includes/features.html"
    }).when("/estimate", {
        templateUrl : "includes/priceestimate.html",
        controller :"globalctrl"
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
    }).when("/logoutSuccess",{
        templateUrl : "views/home.html",
    }).when("/userSetting",{
        templateUrl : "views/profileSetting.html",
        controller : 'bookingCtrl'
   }).when("/orderconfirm", {
	   templateUrl : "views/orderDetails.html",
	   controller : 'bookingCtrl'
  }).otherwise({
    	redirect: 'index.html'
    })
  
    $locationProvider.html5Mode({
    	  enabled: true
    	});
    
    $qProvider.errorOnUnhandledRejections(false);
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

app.service("identifyCustomer", function($http,$q){
    return {
   	 getUser: function() {
   		var deferred = $q.defer();

   		      $http.get('/dropshuttl/getUser').then(function onSuccess(response) {
   		    	deferred.resolve(response.data);
   		    	//  $scope.username=response.data.uname;
   		      }).catch(function onError(response) {
   			    // Handle error
   			    //  var data = response.data;
   			    deferred.reject(response.statusText);
   			    
   			    console.log(response.status+" "+response.statusText);
   			   

       })
   		   return deferred.promise;


   	 }
    
  }
    });

app.service("creatingAccount", function($http,$q){
    return {
    	createUser: function(data) {
   		var deferred = $q.defer();
          $http.post('/dropshuttl/addUser', data,{'Content-Type': 'application/json'}).then(function onSuccess(response) {
   			deferred.resolve(response.data);
   			$scope.errorStatus = '';
   			console.log(response.status+"   ");
          }).catch(function onError(response) {
   			    // Handle error
   			    console.log(response.status+" "+response.statusText);
   			    $scope.errorStatus = 'true';
   			    $scope.errorMessage = response.data.message;
   			 deferred.reject(response.statusText);
   			  })
   		   return deferred.promise;

   	 }
    
  }
    });

app.service("proceedOrder", function($http,$q){
    return {
    	getPaymentStaus: function(data) {
   		var deferred = $q.defer();
          $http.post('/dropshuttl/receiveOrderPayment', data,{'Content-Type': 'application/json'}).then(function onSuccess(response) {
   			deferred.resolve(response.data);
   			//$scope.errorStatus = '';
   			console.log(response.status+" status   ");
          }).catch(function onError(response) {
   			    // Handle error
   			    console.log(response.status+" "+response.statusText);
   			    //$scope.errorStatus = 'true';
   			   // $scope.errorMessage = response.data.message;
   			  //  deferred.reject(response.statusText);
   			  })
   		   return deferred.promise;

   	 }
    
  }
    });



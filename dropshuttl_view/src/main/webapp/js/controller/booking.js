/**
 * 
 */
app.controller('bookingCtrl', function($scope, $http,$location,$q,$rootScope,bookingservice) {
	/*$scope.getPrice = function()
	{
		$location.path("/signup");

	}*/
  
	$scope.getPrice = function()
	{
		$scope.showLoader = true;
		//var defer = $q.defer();
		var orderData=$scope.order;
		var order=new Object();
		order.deliverydate=orderData.deliverydate;
		order.orderType=orderData.documentType;
		order.fromAdderss=orderData.pickupadd;
		order.toAddress=orderData.dropadd;
		
		 var data=JSON.stringify(order);
	   //  $location.path("estprice");
	     
	  /* var price=$http.post('/dropshuttl/checkAvailablePrice', data,{'Content-Type': 'application/json'}).then(function onSuccess(response) {
		console.log(response.status+"   "+price);
	    	 deferred.resolve(price);
	    	 $scope.showLoader = false;
	    	 return deferred.promise;
	    	 $location.path('/error');
		
		}).catch(function onError(response) {
		    // Handle error
		    var data = response.data;
		    var status = response.status;
		    var statusText = response.statusText;
		    var headers = response.headers;
		    var config = response.config;
		    console.log(status+" "+statusText);
		   
		  });*/
		
	    	 var promise = bookingservice.getCost(data);
	         promise.then(
	        		 function(response) {
	        			 console.log("price "+response); 
	        			 $rootScope.price=response;
	        			 $location.path('estprice');
	            });
	       
	    	// $rootscope.price=promise;
	}
	
	
	
	
});
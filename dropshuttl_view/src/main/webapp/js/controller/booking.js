/**
 * 
 */
app.controller('bookingCtrl', function($scope, $http,$location,$q,$rootScope,bookingservice,identifyCustomer) {
	
	 $scope.showPrice=false;
	if(($location.search().id_token == undefined || $location.search().id_token == null) 
		&& ($rootScope.username ==undefined || $rootScope.username==null)){
	

	var userpromise = identifyCustomer.getUser();
	userpromise.then(
   		 function(response) {
   			 console.log("user "+response.uname); 
   			$rootScope.username=response.uname;
       });
}else
	{
	if($location.search().id_token != undefined || $location.search().id_token != null){
	 var id_token = $location.search().id_token;
	 console.log("user "+id_token); 
		$rootScope.username=id_token;
	}
	}
	console.log("username "+$rootScope.username);
	console.log("$rootScope "+$rootScope); 
	
	$scope.getPrice = function()
	{
		$scope.showLoader = true;
		 $scope.showPrice=false;
		//var defer = $q.defer();
		var orderData=$scope.order;
		var order=new Object();
		order.deliverydate=orderData.deliverydate;
		order.orderType=orderData.documentType;
		order.fromAdderss=orderData.pickupadd;
		order.toAddress=orderData.dropadd;
		order.fromLocation=orderData.pickuploaction;
		order.toLoaction=orderData.droplocation;
		
		 var data=JSON.stringify(order);
	     var promise = bookingservice.getCost(data);
	         promise.then(
	        		 function(response) {
	        			 console.log("price "+response);
	        			 $scope.price=response;
	        			 $scope.showLoader = false;
	        			 $scope.showPrice=true;
	        		 });
		}
	
	
	
	
});
/**
 * 
 */

app.controller('globalctrl', function($scope, $http,$location,$rootScope,bookingservice) {
    	
   $scope.findDistance=function(source,destination)
   {    
	   $scope.errorStatus="false";
    	
    	//var requestUrl="https://maps.googleapis.com/maps/api/geocode/json?address=";
		//var api_key="&key=AIzaSyDFuiFYl3dg1bm4xofhWp7sVE3y0dXTgag";
		//var source_address ="";
		//var destination_address="";
		
		/*source_address= source.split(' ').join('%20');
		var requestUrlSource=requestUrl+source_address+api_key;
		
		 $http.get(requestUrlSource).then(function (response) {
        	 $scope.sourcelat = response.data.results[0].geometry.location.lat;
             $scope.sourcelng = response.data.results[0].geometry.location.lng;
        	 
        });
		 destination_address=destination.split(' ').join('%20')
		 var requestUrlDestination=requestUrl+destination_address+api_key;
		 $http.get(requestUrlDestination).then(function (response) {
        	 $scope.destinationlat = response.data.results[0].geometry.location.lat;
             $scope.destinationlng = response.data.results[0].geometry.location.lng;
        	 
        });*/
	   if((source == undefined || source == null || source== '') || (destination == undefined || destination == null || destination== '') )
		   {
		   $rootScope.setInvalidError();
		   } else{
		 $scope.source_address=source;
	     $scope.destination_address=destination;
		 $scope.initMap(); 
		 $scope.getEstimatePrice(source,destination);
		   }
   } 
   
   $scope.initMap =function(){
       var bounds = new google.maps.LatLngBounds;
       var markersArray = [];
      // 28.7041° N, 77.1025° E
    // var origin1 = {lat: $scope.sourcelat, lng: $scope.sourcelng};
      var origin2 = $scope.source_address;
      var destinationA = $scope.destination_address;
      //var destinationB = {lat: $scope.destinationlat, lng: $scope.destinationlng};

       var destinationIcon = 'https://chart.googleapis.com/chart?' +
           'chst=d_map_pin_letter&chld=D|FF0000|000000';
       var originIcon = 'https://chart.googleapis.com/chart?' +
           'chst=d_map_pin_letter&chld=O|FFFF00|000000';
       var map = new google.maps.Map(document.getElementById('map'), {
         center: {lat: 28.7041, lng: 77.1025},
         zoom: 10
       });
       var geocoder = new google.maps.Geocoder();

       var service = new google.maps.DistanceMatrixService;
       service.getDistanceMatrix({
         origins: [origin2],
         destinations: [destinationA],
         travelMode: 'DRIVING',
         unitSystem: google.maps.UnitSystem.METRIC,
         avoidHighways: false,
         avoidTolls: false
       }, function(response, status) {
         if (status !== 'OK') {
           alert('Error was: ' + status);
         } else {
       	  
           var originList = response.originAddresses;
           var destinationList = response.destinationAddresses;
           var outputDiv = document.getElementById('output');
           outputDiv.innerHTML = '';
           $scope.deleteMarkers(markersArray);

           var showGeocodedAddressOnMap = function(asDestination) {
             var icon = asDestination ? destinationIcon : originIcon;
             return function(results, status) {
               if (status === 'OK') {
                 map.fitBounds(bounds.extend(results[0].geometry.location));
                 markersArray.push(new google.maps.Marker({
                   map: map,
                   position: results[0].geometry.location,
                   icon: icon
                 }));
               } else {
                 alert('Geocode was not successful due to: ' + status);
               }
             };
           };

           for (var i = 0; i < originList.length; i++) {
             var results = response.rows[i].elements;
             
             geocoder.geocode({'address': originList[i]},
                 showGeocodedAddressOnMap(false));
             for (var j = 0; j < results.length; j++) {
               geocoder.geocode({'address': destinationList[j]},
               	showGeocodedAddressOnMap(true));
               outputDiv.innerHTML += originList[i] + ' to ' + destinationList[j] +
                   ': <b>' + results[j].distance.text + '</b> in <b>' +
                   results[j].duration.text + '</b><br>';
             }
           }
         }
       });
      
     }

   $scope.getEstimatePrice=function(orgin,destination)
   {
	   $scope.showLoader = true;
	    var order=new Object();
		//order.deliverydate=orderData.deliverydate;
		//order.orderType=orderData.documentType;
		order.fromAdderss=orgin;
		order.toAddress=destination;
		 var data=JSON.stringify(order);
	     var promise = bookingservice.getCost(data);
	         promise.then(
	        		 function(response) {
	        			 console.log("price "+response); 
	        			 $scope.price=response;
	        			 $scope.showLoader = false;
	            });
		
   }
   
     $scope.deleteMarkers= function(markersArray) {
       for (var i = 0; i < markersArray.length; i++) {
         markersArray[i].setMap(null);
       }
       markersArray = [];
     }
        
$scope.booknowdetails=function(){
	console.log("inside book now");
	$location.path("booknow");
}

$scope.clearScope=function()
{
	console.log("deleting scope on logout");
	$rootScope.username='';
	  $http.get('/dropshuttl/logout').then(function onSuccess(response) {
		  $location.path("/");
		  }).catch(function onError(response) {
			    // Handle error
			    //  var data = response.data;
			  //   deferred.reject(response.statusText);
			    
			    console.log(response.status+" "+response.statusText);
			   

 })
	
	
}	
$rootScope.setInvalidError=function()
{
    $scope.errorStatus="true";
	$scope.errorMessage="Invalid input. ! Please enter correct location";
	
}

}); 
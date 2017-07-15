/**
 * 
 */

app.controller('globalctrl', function($scope, $http,$location) {
    	
   $scope.findDistance=function(source,destination)
   {    
	  
    	
    	var requestUrl="https://maps.googleapis.com/maps/api/geocode/json?address=";
		var api_key="&key=AIzaSyDFuiFYl3dg1bm4xofhWp7sVE3y0dXTgag";
		var source_address = source.split(' ').join('%20');
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
        	 
        });
		 $scope.initMap(); 
   } 
   
   $scope.initMap =function(){
       var bounds = new google.maps.LatLngBounds;
       var markersArray = [];
      // 28.7041° N, 77.1025° E
     var origin1 = {lat: $scope.sourcelat, lng: $scope.sourcelng};
      // var origin2 = 'New Delhi, India';
      // var destinationA = 'Ghaziabad, India';
      var destinationB = {lat: $scope.destinationlat, lng: $scope.destinationlng};

       var destinationIcon = 'https://chart.googleapis.com/chart?' +
           'chst=d_map_pin_letter&chld=D|FF0000|000000';
       var originIcon = 'https://chart.googleapis.com/chart?' +
           'chst=d_map_pin_letter&chld=O|FFFF00|000000';
       var map = new google.maps.Map(document.getElementById('map'), {
         center: {lat: 55.53, lng: 9.4},
         zoom: 10
       });
       var geocoder = new google.maps.Geocoder();

       var service = new google.maps.DistanceMatrixService;
       service.getDistanceMatrix({
         origins: [origin1],
         destinations: [destinationB],
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
                   ': ' + results[j].distance.text + ' in ' +
                   results[j].duration.text + '<br>';
             }
           }
         }
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

}); 
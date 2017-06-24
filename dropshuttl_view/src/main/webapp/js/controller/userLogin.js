/**
 * 
 */
app.controller('signUpCtrl', ['$scope','$http','$location',function($scope,$http,$location) {
	
	

	$scope.validateForm=function(){
		
	//var data=$scope.user;
	var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
	
//$location.path('addAccount');
	
	var resp=$http.post('/dropshuttl_view/addUser', $scope.user, config).then(function onSuccess(response) {
			    // Handle success
			    var data = response.data;
			    var status = response.status;
	
	
	}).catch(function onError(response) {
	    // Handle error
	    var data = response.data;
	    var status = response.status;
	    var statusText = response.statusText;
	    var headers = response.headers;
	    var config = response.config;
	   
	  });
	
	}
	/*var data =$scope.userForm;
	var resp=$http.post('/addUser', data, config).then(successCallback, errorCallback);
    alert(resp);
*/
}]);	
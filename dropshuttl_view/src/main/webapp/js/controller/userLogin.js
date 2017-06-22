/**
 * 
 */
app.controller('signUpCtrl', ['$scope','$http','$location',function($scope,$http,$location) {
	
	

	$scope.validateForm=function(){
		
	var data=$scope.user;
	var config = {
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }
	
//$location.path('addAccount');
	
	var resp=$http.post('/addUser', data, config).then(status)
			{
	     $scope.user=data;
	
	
	}
	}
	/*var data =$scope.userForm;
	var resp=$http.post('/addUser', data, config).then(successCallback, errorCallback);
    alert(resp);
*/
}]);	
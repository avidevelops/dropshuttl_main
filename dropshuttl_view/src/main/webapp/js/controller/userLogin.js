
app.controller('signUpCtrl', function($scope,$http,$q,$location,$rootScope,creatingAccount) {
	
	
	if($location.absUrl().indexOf('loginError') != -1)
		
	{
		$scope.errorStatus='true';
		$scope.errorMessage='Entered EmailId/Mobile and Password do not match !';
	}	
	
	$scope.validateForm=function(){
	$scope.errorStatus = 'false';
	var userData="";
	userData=$scope.user;
	if ($scope.user.uname == undefined || $scope.user.uname == null
			|| $scope.user.umailId == undefined || $scope.user.umailId == null
			|| $scope.user.umob == undefined ||  $scope.user.umob == null || $scope.user.pass==undefined || $scope.user.pass ==null)
	{
		 $scope.errorStatus = 'true';
		 $scope.errorMessage = 'Please enter all fields';	
		
	}else{
		var user=new Object();
		user.uname=userData.uname;
		user.umailId=userData.umailId;
		user.umob=userData.umob;
		user.pass=userData.pass;
		
		//$rootScope.username=user.uname;
		var data=JSON.stringify(user);
		var newname="";
	    
		var createuserpromise = creatingAccount.createUser(data);
		createuserpromise.then(
	   		 function(response) {
	   			 console.log("user "+response.uname); 
	   			$rootScope.username=response.uname;
	   			$location.path("/booknow")
	       });
		
			 
		}
		}

	});

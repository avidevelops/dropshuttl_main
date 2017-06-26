
app.controller('signUpCtrl', ['$scope','$http','$location',function($scope,$http,$location) {
	
	

	$scope.validateForm=function(){
		
	var userData=$scope.user;
	var user=new Object();
	user.uname=userData.uname;
	user.umailId=userData.umailId;
	user.umob=userData.umob;
	user.pass=userData.pass;
	//var data = 'uname=' + $scope.uname + '&umailId=' + $scope.umailId + '&umob=' + $scope.umob+ '&pass= '+$scope.pass;
	var data=JSON.stringify(user);
	
	/*var config = {
            headers : {
                'Content-Type': 'application/json;'
            }
        }
	*/
//$location.path('addAccount');
	
	var resp=$http.post('/dropshuttl/addUser', data,{'Content-Type': 'application/json'}).then(function onSuccess(response) {
			    // Handle success
			 //   var user = response.data;
			   
			   console.log(response.status);
	
	
	}).catch(function onError(response) {
	    // Handle error
	    var data = response.data;
	    var status = response.status;
	    var statusText = response.statusText;
	    var headers = response.headers;
	    var config = response.config;
	    console.log(status+" "+statusText);
	   
	  });
	
	}
	$scope.testForm=function(){
		var data="";
		var config = {
	            headers : {
	                'Content-Type': 'application/json;charset=utf-8;'
	            }
		}
	var re=$http.post('/testcontrol', JSON.stringify(data), config).then(function onSuccess(response) {
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
console.log(status+" "+statusText);

});
		
	};
	

}]);
/*app.factory('dataService', function ($q, $timeout) {
    return { 
        data : {},
        load : function(id) {
            var defer = $q.defer();
            var data = this.data;
            $timeout(function () {
                data.id = id;
                defer.resolve(data);
            }, 1000);
            return defer.promise;
        }
    };
});*/
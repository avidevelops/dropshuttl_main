
app.controller('signUpCtrl', ['$scope','$http','$location',function($scope,$http,$location) {
	
	

	$scope.validateForm=function(){
		
	var userData=$scope.user;
	var user=new Object();
	user.uname=userData.uname;
	user.umailId=userData.umailId;
	user.umob=userData.umob;
	user.pass=userData.pass;
	
	var data=JSON.stringify(user);
	
    var resp=$http.post('/dropshuttl/addUser', data,{'Content-Type': 'application/json'}).then(function onSuccess(response) {
	console.log(response.status+"   "+resp);
    $location.path('/login');
	
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
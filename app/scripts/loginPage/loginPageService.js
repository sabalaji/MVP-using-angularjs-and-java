angular.module("myapp")
	   .service ('loginPageService',['$state','$http','sessionStorageService','Notification', function ($state,$http,sessionStorageService,Notification) {

     this.addUser = function (email, password) {
       var data = {
        	email : email,
        	password : password,
        	isActive : true
       };
       var url = "http://localhost:8080/balaji/rest/user/add";
        	$http.post (url, data)
        		   .then (function successCallback (response) {
        			      Notification.primary("Signed up u can login now");
        			      $state.go('root.login');
        		    }, function errorCallback(response) {
        			      Notification.error("something went wrong - server error");
        			      $state.go('root.home');
        		    });
      }

  		this.loginAuthentication = function(email,password) {
  			var data = {
  						email : email,
  						password : password
  					};
  			var url = "http://localhost:8080/balaji/rest/user/auth";
  			$http.post(url, data)
  					 .then(function successCallback(response) {
  					if(response.status == 200){
  						var data = JSON.parse(response.data);
  						sessionStorageService.setId("userId", data.id);
  					  sessionStorageService.setEmail("email", data.email);
  						Notification.primary("Successfully Logged in..");
  						$state.go('root.userProfile.posts');
  					} else {
  						Notification.primary("provided credentials are wrong!");
  						$state.go('root.login');
  					}
  				});
  		}

  		this.signout= function() {
  			$state.go('root.home');
  		}

}]);

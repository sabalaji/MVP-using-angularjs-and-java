angular.module('myapp')
	   .controller ('loginPageCtrl', function ($scope, Notification, loginPageService) {

	$scope.emailExisting;
	$scope.passwordExisting;
  $scope.email;
	$scope.password;

	$scope.login = function login () {

    if ($scope.emailExisting != null && $scope.passwordExisting != null) {
		    loginPageService.loginAuthentication($scope.emailExisting, $scope.passwordExisting);
    } else { Notification.error("fill all credentials") }

	}

	$scope.addUser = function () {

    if ($scope.email != null && $scope.password != null) {
		    loginPageService.addUser($scope.email, $scope.password);
    } else { Notification.error("fill all credentials") }

	}

});

angular.module('myapp', ["ui.router","ui-notification"])
    .config(function($stateProvider, $urlRouterProvider,NotificationProvider){

      $stateProvider
          .state('root', {
              abstract: true,
              url: ''
          }).state('root.login', {
              url: '/login',
              controller : 'loginPageCtrl',
              templateUrl: 'views/user/loginPage.html'
          }).state('root.userProfile', {
              url: '/userProfile',
              controller : 'userCtrl',
              templateUrl: 'views/user/userProfile.html'
          }).state('root.userProfile.view', {
              url: '/view',
              controller : 'userCtrl',
              templateUrl: 'views/user/userProfileView.html'
          }).state('root.userProfile.edit', {
              url: '/edit',
              controller : 'userCtrl',
              templateUrl: 'views/user/userProfileEdit.html'
          }).state('root.userProfile.posts', {
              url: '/posts',
              controller : 'userCtrl',
              templateUrl: 'views/user/posts.html'
          }).state('root.userProfile.post', {
              url: '/post',
              controller : 'userCtrl',
              templateUrl: 'views/user/post.html'
          }).state('root.userProfile.findFriends', {
              url: '/findFriends',
              controller : 'userCtrl',
              templateUrl: 'views/user/findFriends.html'
          }).state('root.userProfile.friendRequest', {
              url: '/friendRequest',
              controller : 'userCtrl',
              templateUrl: 'views/user/friendRequest.html'
          });

        $urlRouterProvider.otherwise("/login");

        NotificationProvider.setOptions({
          delay: 5000,
          startTop: 20,
          startRight: 10,
          verticalSpacing: 20,
          horizontalSpacing: 20,
          positionX: 'center',
          positionY: 'top'
      });
    });

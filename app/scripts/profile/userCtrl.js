angular.module('myapp')
       .controller ('userCtrl', function ($scope,$timeout, userCtrlService) {

         $scope.newPost = "";
         $scope.postId;
         $scope.rEmail = "";
         $scope.likedUsers;
         $scope.uPost = {};
         $scope.likesCount;

    var init = function init() {

       $scope.getAllPost();
       $scope.getUserById();
       $scope.friendList();
       $scope.getAllPostById();
       $scope.getAllUser();
       $scope.getFriendRequest();

    };

    var cSuccessUserDetail = function cSuccessUserDetail(response) {
        $scope.udetail = response;
    };

    var cSuccessAllUser = function cSuccessAllUser(response) {
        $scope.allUser = response;
    };

    var cSuccessAllPost = function cSuccessAllPost(response) {
        $scope.allPost = response;
    };

    var cSuccessRequest = function cSuccessRequest(response) {
        $scope.userRequest = response;
    };

    var cSuccessPostById = function cSuccessPostById(response) {
        $scope.uPost = response;
    };

    var cSuccessPostLikes = function cSuccessPostLikes(response) {
        $scope.likedUsers = response.data[0];
        $scope.likes = response.data.length;
    };

    var cSuccessFriendList = function cSuccessFriendList(response) {
        $scope.friends = response;
    };

    $scope.getUserById = function getUserById() {
        userCtrlService.doGetUserDetail(cSuccessUserDetail);
    };

    $scope.getAllUser = function getAllUser() {
        userCtrlService.doGetAllUser(cSuccessAllUser);
    };

    $scope.updateUserDetail = function updateUserDetail() {
        userCtrlService.doPostUserDetail($scope.udetail);
    };

    $scope.logout = function logout() {
        userCtrlService.doLogout();
    };

    $scope.getAllPostById = function getAllPostById() {
        userCtrlService.doGetAllPostById(cSuccessPostById);
    };

    $scope.getAllPost = function getAllPost() {
        userCtrlService.doGetAllPost(cSuccessAllPost);
    };

    $scope.addPost = function addPost(newPost) {
        userCtrlService.doAddPost($scope.newPost);
        // $timeout(callAtTimeout, 250);
    };

    $scope.deletePost = function deletePost(post) {
        userCtrlService.doDeletePost(post.postId);
        var index = $scope.uPost.indexOf(post);
        $scope.uPost.splice(index, 1);
    };

    $scope.friendRequest = function friendRequest(rEmail) {
        userCtrlService.doPostFriendRequest(rEmail);
    };

    $scope.getFriendRequest = function getFriendRequest() {
        userCtrlService.doGetFriendRequest(cSuccessRequest);
    };

    $scope.acceptFriendRequest = function acceptFriendRequest(sEmail) {
        userCtrlService.doGetAcceptFriendRequest(sEmail);
    };

    $scope.friendList = function friendList() {
        userCtrlService.doGetFriendList(cSuccessFriendList);
    };

    $scope.updatePost = function updatePost(post, postId) {
        userCtrlService.doPutPost(post, postId);
        $timeout(callAtTimeout, 250);
    };

    $scope.addLike = function addLike(postId) {
        userCtrlService.doPostLike(postId);
    };

    $scope.getAllLikeByPostId = function getAllLikeByPostId(postId) {
        userCtrlService.doGetAllLikeByPostId(postId,cSuccessPostLikes);
    };

    function callAtTimeout() {
        location.reload();
    }

    init();

});

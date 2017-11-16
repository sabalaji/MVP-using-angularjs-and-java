angular.module ('myapp')
       .service ('userCtrlService', [
                 '$http',
                 '$state',
                 'sessionStorageService',
                 'Notification', function (
                 $http,
                 $state,
                 sessionStorageService,
                 Notification) {

    var email = "email";

    this.doGetUserDetail = function doGetUserDetail (cSuccessUserDetail) {
        var id = sessionStorageService.getId('userId');
        $http.post ("http://localhost:8080/balaji/rest/userDetail?userDetailId="+id)
             .then (function(response) {
                cSuccessUserDetail (response.data[0]);
             }, function (response) {
               Notification.error("something went wrong - server error");
             });
    };

    this.doGetAllUser = function doGetAllUser (cSuccessAllUser){
        $http.get ("http://localhost:8080/balaji/rest/user")
           .then (function(response) {
              cSuccessAllUser (response.data);
           }, function (response) {
              Notification.error("something went wrong - server error");
          });
    };

    this.doAddPost = function doAddPost(newPost) {
        var id = sessionStorageService.getId('userId');
        var data = {
                      userPost : newPost,
                      loginDetail :
                      { id : id }
                    };

        var url = "http://localhost:8080/balaji/rest/post/add";
        $http.post (url, data)
             .then (function (response) {
                Notification.primary("Succesfully posted");
             }, function (response) {
                Notification.error("something went wrong - server error");
            });
    };

    this.doLogout = function doLogout() {
        $state.go('root.login');
    };

    this.doGetAllPost = function doGetAllPost(cSuccessAllPost) {
        $http.get ("http://localhost:8080/balaji/rest/post")
             .then (function (response) {
                cSuccessAllPost (response.data);
             }, function (response) {
                Notification.error("something went wrong - server error");
            });
    };

    this.doGetAllPostById = function doGetPostById(cSuccessPostById) {
        var id = sessionStorageService.getId('userId');
        $http.post ("http://localhost:8080/balaji/rest/post?postId="+id)
             .then (function (response) {
                cSuccessPostById (response.data);
           }, function (response) {
              Notification.error("something went wrong - server error");
          });
    };

    this.doPostUserDetail = function doPostUserDetail(udetail) {
        var userId = sessionStorageService.getId('userId');
        var data = {
                      name : udetail.name,
                      dateOfBirth : udetail.dateOfBirth,
                      gender : udetail.gender,
                      phoneNumber : udetail.phoneNumber,
                      schoolName : udetail.schoolName,
                      collegeName : udetail.collegeName,
                      profilePicture : udetail.profilePicture,
                      workingStatus : udetail.workingStatus,
                      relationshipStatus : udetail.relationshipStatus,
                      country : udetail.country,
                      homeTown : udetail.homeTown,
                      languageKnown : udetail.languageKnown,
                      loginDetail : { id : userId }
			             };

        var url = "http://localhost:8080/balaji/rest/userDetail";
            $http.put (url, data)
                .then (function (response) {
                    Notification.primary ("Succesfully updated");

                }, function (response) {
                    Notification.error ("something went wrong - server error");
                    $state.go('root.home');
                });
        };

        this.doDeletePost = function doDeletePost(postId) {
            $http.delete ("http://localhost:8080/balaji/rest/post?postId="+postId)
                 .then (function (response) {
                   Notification.primary ("deleted");
               }, function (response) {
                  Notification.error ("something went wrong - server error");
              });
        };
        this.doPostFriendRequest = function doPostFriendRequest(rEmail) {
            var sEmail = sessionStorageService.getEmail([email]);
            var rEmail = rEmail;
            var data = {
                          idSender : sEmail,
                          idReceiver : rEmail,
                          isActive : 0
                        };

            var url = "http://localhost:8080/balaji/rest/friend";
            $http.post (url, data)
                 .then (function (response) {
                     if (response.data == "success") {
                         Notification.primary ("Request Send");
                     } else { Notification.error ("Request Already send") }
                 }, function (response) {
                    Notification.error("something went wrong - server error");
                });
        };

        this.doGetFriendRequest = function doGetFriendRequest(cSuccessRequest) {
            var receiverEmail = sessionStorageService.getEmail([email]);
            $http.get ("http://localhost:8080/balaji/rest/friend?receiverEmail="+receiverEmail)
                 .then (function (response) {
                    cSuccessRequest (response.data);
               }, function (response) {
                    Notification.error ("something went wrong - server error");
              });
        };

        this.doGetAcceptFriendRequest = function doGetAcceptFriendRequest(sEmail) {
            var rEmail = sessionStorageService.getEmail([email]);
            var sEmail = sEmail;
            var url = "http://localhost:8080/balaji/rest/friend?senderEmail="+sEmail+"&receiverEmail="+rEmail;
            $http.put (url)
                 .then (function(response) {
                    Notification.primary ("accepted");
                 }, function(response) {
                    Notification.error ("something went wrong - server error");
                });
        };

        this.doGetFriendList = function doGetFriendList(cSuccessFriendList) {
            var receiverEmail = sessionStorageService.getEmail([email]);
            $http.get ("http://localhost:8080/balaji/rest/friend/getFriendBySenderId?receiverEmail="+receiverEmail)
                 .then (function(response) {
                    cSuccessFriendList (response.data);
               }, function (response) {
                    Notification.error("something went wrong - server error");
              });
        };

        this.doPutPost = function doPutPost(post, postId) {
            var userId = sessionStorageService.getId('userId');
            var data = {
                          userPost : post,
                          postId : postId,
                          loginDetail : { id : userId }
                       };

            var url = "http://localhost:8080/balaji/rest/post";
                $http.put (url, data)
                    .then (function (response) {
                        Notification.primary ("Succesfully updated");
                    }, function (response) {
                        Notification.error(response);
                    });
        };

        this.doPostLike = function doPostLike(postId) {
            var userEmail = sessionStorageService.getEmail([email]);
            var data = {
                          postId : postId,
                          userEmail : userEmail
                       };

            var url = "http://localhost:8080/balaji/rest/postLike";
                $http.post (url, data)
                    .then (function (response) {
                        if (response.data == "success") {
                            Notification.primary ("liked");
                        } else { Notification.error ("Already liked") }
                    }, function (response) {
                        Notification.error ("Already liked");
                    });

        };

        this.doGetAllLikeByPostId = function doGetAllLikeByPostId(postId, cSuccessPostLikes) {
            $http.get ("http://localhost:8080/balaji/rest/postLike?postId="+postId)
                 .then (function (response) {
                    cSuccessPostLikes (response);
               }, function (response) {
                    Notification.error ("something went wrong - server error");
              });
        };
}]);

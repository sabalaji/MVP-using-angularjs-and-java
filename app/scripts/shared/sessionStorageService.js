angular.module ('myapp')
       .service ('sessionStorageService',function () {

        this.setId = function setId(key, id) {
            sessionStorage.setItem(key, id);
        };

        this.getId = function getId(key, id) {
            return JSON.parse(sessionStorage.getItem(key, id));
        };

        this.setEmail = function setEmail(key, email) {
            sessionStorage.setItem(key, JSON.stringify(email))
        };

        this.getEmail = function getEmail(key) {
            return JSON.parse(sessionStorage.getItem(key));
        };

});

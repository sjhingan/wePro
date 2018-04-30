//userService.svc.js
(function () {
    angular
        .module("weProApp")
        .service("UserService" , UserService);
    //UserService.$inject = ['$timeout', '$filter', '$q'];

    function UserService($http){

        var api={
            create:create
        };
        return api;

        function create(user){

            console.log("service: " + user);
            return $http.post("userprofile/register",user);

        }

    }
})();
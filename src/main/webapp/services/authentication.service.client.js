//authenticationService.js
(function () {
    angular
        .module('weProApp')
        .factory('AuthenticationService', AuthenticationService);

    function AuthenticationService($http){
        var api={
            loginuser:loginuser
        };
        return api;
        function loginuser(user){
            //console.log(user.password);
            return $http.get("userprofile/checkuser/"+user.email+"/"+user.password);
        }
    }

})();
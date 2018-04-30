//loginController.js
(function () {
    angular
        .module('weProApp')
        .controller('LoginController', LoginController);

    function LoginController(AuthenticationService,$location) {
        var vm = this;
        vm.login = login;

        function login(user) {
           // console.log(user);

            AuthenticationService.loginuser(user).then(function (response) {

                if (response.data!= -1) {
                    //alert('Login successful');
                    $location.url("/home");

                    //('#!/home');
                    // $location.path('/login');
                } else {
                    alert('Login Unsuccessful! Try Again!');
                   // $location.url("/login");

                }
            });
        }
    }
})();
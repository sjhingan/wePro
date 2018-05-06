(function () {
    angular
        .module('weProApp')
        .controller('RegisterController', registerController);

    function registerController(UserService, $location) {
        var vm = this;
        vm.register = register;
        
        
       //alert("Inside controller");
        function register(user) {
            //alert("Inside register from controller");
            console.log(user);
            UserService.create(user)
                .then(function (response) {
                    if (response.data==1) {
                        //alert('Registration successful');
                        $location.url("/login");
                        //('#!/login');
                       // $location.path('/login');
                    } else {
                        alert(response.message);
                        //vm.dataLoading = false;
                    }
                });
        }
        
    }
})();
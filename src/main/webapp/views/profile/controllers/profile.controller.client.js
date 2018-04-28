(function () {
    angular
        .module("weProApp")
        .controller("UserProfileController", userProfileController);
    function userProfileController(ProfileService) {
        var vm = this;

        function init() {
            vm.profile = undefined;
            loadUserProfile();
        }

        init();

        function loadUserProfile() {
            ProfileService.getProfile(1)
                .then(function (profile) {
                    vm.profile = profile.data;
                    console.log(vm.profile);
                });
        }
    }

})();
(function () {
    angular
        .module("weProApp")
        .controller("SetProfileController",profileController);

    function profileController(ProfileService) {
        var vm = this;
        //vm.addTopic = addTopic;
        vm.updateProfile = updateProfile;


        function init() {

             vm.oldprofile = undefined;
            // vm.topics = undefined;
            // loadAllTopics();
            loadOldUserProfile();

            console.log("Hi, inside profile controller!! ")
        }

        init();

        function updateProfile(profile){
            console.log(profile);

            ProfileService.updateProfile(profile).then(function (status) {
                                                                      init();
                                                                  });
        }


        function loadOldUserProfile() {
            ProfileService.getProfile(1)
                .then(function (profile) {
                    vm.oldprofile = profile.data;
                    console.log(vm.profile);
                });
        }
    }
})();
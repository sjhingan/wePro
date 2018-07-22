(function () {
    angular
        .module("weProApp")
        .controller("UserProfileController", userProfileController);
    function userProfileController(ProfileService, $location,$routeParams) {
        var vm = this;
        vm.allSkills = undefined;
        vm.userSkillsDetailedArray = undefined;
        vm.userSkills = undefined;
        vm.oldprofile = undefined;
        vm.userId = $routeParams['uid'];




        function init() {
            vm.profile = undefined;
            vm.oldprofile = undefined;
            vm.allSkills = undefined;
            vm.userSkills = ""

             loadSkills();
             console.log("Hi, inside profile controller!! ")
             loadUserProfile();

        }

        init();

        function loadUserProfile() {
        	console.log("USerid from dashboard :"+vm.userId);
            ProfileService.getProfile(vm.userId)
                .then(function (profile) {
                    vm.profile = profile.data;
                    vm.userSkillsDetailedArray = vm.profile.userSkills;
                    console.log("User Skills;")
                    for(var i = 0 ; i < vm.userSkillsDetailedArray.length; i++)
                    {
                        var each_skill = vm.userSkillsDetailedArray[i];
                           console.log(each_skill.skill);
                            vm.userSkills += each_skill.skill.name + " ";
                            console.log(vm.userSkills);
                     }

                    //console.log(vm.profile);
                });
        }
         function loadSkills() {
                            ProfileService.getAllSkills()
                                .then(function (skills) {
                                   vm.allSkills = skills.data;

                            });
                 }
         this.editProfile = function editProfile(user){
        	 console.log("Inside edit profile function");
        	 console.log(user);
        	 $location.url('/profile/setprofile/'+user.id);
         }
    }

})();
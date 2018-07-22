(function () {
    angular
        .module("weProApp")
        .controller("SetProfileController",profileController);

    function profileController(ProfileService, $location,$routeParams) {
        var vm = this;
        //vm.addTopic = addTopic;
        vm.updateProfile = updateProfile;
        vm.allSkills = undefined;
        vm.userSkills = undefined;
        vm.selectedSkills = undefined;
        vm.commonSkills = undefined;
        vm.oldprofile = undefined;
        
        vm.userId = $routeParams['uid'];


        vm.makingObject = undefined;

        function init() {

             vm.oldprofile = undefined;

             vm.allSkills = undefined;
            // vm.topics = undefined;
            // loadAllTopics();

           loadSkills();
           console.log("Hi, inside profile controller!! ");
           
           loadOldUserProfile();


        }

        init();

     function updateProfile(profile){
                    console.log("I am here");
                 console.log(profile);

                 console.log(vm.oldprofile);

                 profile.id = vm.oldprofile.id;
                 profile.password = vm.oldprofile.password;

                 console.log("Printing Skills Array");
                 console.log(vm.selectedSkills);
                 profile.userSkills = vm.selectedSkills;
                 //profile.userSkills.user_id = profile.id;

                 vm.makingObject = vm.selectedSkills;
                 vm.makingObject += profile.id;

                profile.userSkills = vm.makingObject;

                var skills = [];
                for(var i=0; i<vm.selectedSkills.length; i++){
                    skills.push(vm.selectedSkills[i]);
                }
                console.log("Printing Skills Array End");
                 ProfileService.updateProfile(profile).then(function (status) {

                                                                       });
                 ProfileService.updateSkills(profile.id, skills)
                 .then(function(status){
//                        init();
                    $location.url('/profile/viewprofile/'+profile.id);
                 });
             }


        function loadOldUserProfile() {
        	console.log("ID from profile page before getprofile call:"+vm.userId);
            ProfileService.getProfile(vm.userId)
                .then(function (profile) {
                    vm.oldprofile = profile.data;
                    console.log("In then function of getProfile email:" + vm.oldprofile.email);
                    console.log(vm.oldprofile);
                    console.log(vm.oldprofile.userSkills);
                    vm.userSkills = vm.oldprofile.userSkills;



                      console.log("Print: ");

                      for (var i = 0 ; i < vm.userSkills.length; i++){
                                    console.log("Skill: ");
                                    console.log(vm.userSkills[i]);
                      }

                       /*

                      for (var i = 0 ; i < vm.allSkills.length; i++){
                            for (var j = 0 ; j < vm.userSkills.length; j++)
                            {
                                if (vm.allSkills[i].id == vm.userSkills[j].id)
                                {
                                    var value = vm.allSkills[i].name;

                                    vm.commonSkills.push(value);
                                    console.log("Match" + value);
                                }
                            }
                      }
                      */
//                       console.log("Printing Common Skills");
//                        console.log(vm.commonSkills);
//
//
//                      console.log("print end");

                });
        }

         function loadSkills() {
                    ProfileService.getAllSkills()
                        .then(function (skills) {
                           vm.allSkills = skills.data;

                    });
         }

    }
})();
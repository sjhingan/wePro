(function () {
    angular
        .module("weProApp")
        .controller("OwnerSingleProjectController", ownerSingleProjectController);

    function ownerSingleProjectController($routeParams, OwnerProjectService, AssessmentStatusService, OpenProjectService) {
        var vm = this;
        vm.uid = $routeParams['uid'];
        vm.projectId = $routeParams['projectId'];
        vm.project = undefined;
        vm.confirmHire = confirmHire;
        vm.saveHire = saveHire;
        vm.hiredUsers = undefined;


        function init() {
            OwnerProjectService.getProjectById(vm.projectId)
                .then(function (project) {
                    vm.project = project.data;
                    console.log(vm.project);
                    if(vm.project.assessmentRequired == "Yes"){
                        loadApplicantsResult(vm.project.assessmentId);
                    }else{
                        loadAppliedApplicants(vm.project.id);
                    }
                    getProjectDevelopers();
                });
        }

        init();

        function loadApplicantsResult(assessmentId) {
            AssessmentStatusService.getAssessmentResultsById(assessmentId)
                .then(function (applicants) {
                    vm.applicantsResult = applicants.data;
                    console.log(vm.applicantsResult);
                    removeHired();
                });
        }
        
        function loadAppliedApplicants(projectId) {
            AssessmentStatusService.getAssessmentsByProjectId(projectId)
                .then(function (applicants) {
                    vm.appliedApplicants = applicants.data;
                    console.log(vm.appliedApplicants);
                });
        }

        function confirmHire(user) {
            vm.hire = user;
            vm.hire.name = user.projectAssessmentMappingForResultSubmission.user.firstname;
            $('#hireModal').modal('show');
        }

        function saveHire(user) {
            saveHireToDB(user);

        }

        function saveHireToDB(user) {
            var userProject = new Object();
            userProject.user_id = user.projectAssessmentMappingForResultSubmission.user.id;
            userProject.active = 1;
            userProject.project = vm.project;
            console.log(userProject);
            OpenProjectService.addUserToProject(userProject)
                .then(function (status) {
                    vm.applicantsResult.splice(vm.applicantsResult.indexOf(user),1);
                    init();
                });
            $('#hireModal').modal('hide');
            removeHired();
        }
        
        function getProjectDevelopers() {
            OpenProjectService.getUsersByProjectId(vm.project.id)
                .then(function (userProfiles) {
                    vm.hiredUsers = userProfiles.data;
                    var elem = document.getElementById("hiredUserProgressBar");
                    let calWidth = (vm.hiredUsers.length * 100) / vm.project.positions;
                    elem.style.width = calWidth + '%';
                });

        }

        function removeHired(){
            var removeData = [];
            for(var i=0; i<vm.applicantsResult.length; i++){
                for(var j=0; j<vm.hiredUsers.length; j++){
                    if(vm.applicantsResult[i].projectAssessmentMappingForResultSubmission.user.id == vm.hiredUsers[j].user_id){
                        removeData.push(vm.applicantsResult[i]);
                    }
                }
            }
            for(var i=0; i<removeData.length; i++){
                vm.applicantsResult.splice(removeData[i],1);
            }
        }
    }

})();
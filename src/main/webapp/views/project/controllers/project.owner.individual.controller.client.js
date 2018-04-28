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
                        console.log("loadAppliedApplicants");
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
            console.log(user);
            vm.hire = user;
            vm.hire.name = user.projectAssessmentMappingForResultSubmission.userId;
            $('#hireModal').modal('show');
        }

        function saveHire(user) {
            var userProject = new Object();
            userProject.user_id = user.projectAssessmentMappingForResultSubmission.userId;
            userProject.active = 1;
            userProject.project = vm.project;
            console.log(userProject);
            OpenProjectService.addUserToProject(userProject)
                .then(function (status) {

                });
            $('#hireModal').modal('hide');
            getProjectDevelopers();
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
    }

})();
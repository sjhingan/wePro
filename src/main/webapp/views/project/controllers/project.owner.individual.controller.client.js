//Client Side controller code for the Owner Individual Projects
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
        vm.projectStarted = projectStarted;
        vm.projectCompleted = projectCompleted;


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
                    setProjectStatus(vm.project.statusId);
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
                    removeHired();
                });
        }

        function confirmHire(user) {
            vm.hire = user;
            if(user.projectAssessmentMappingForResultSubmission != null && user.projectAssessmentMappingForResultSubmission != undefined){
                vm.hire.name = user.projectAssessmentMappingForResultSubmission.user.firstname;
            }else{
                vm.hire.name = user.user.firstname;
            }

            $('#hireModal').modal('show');
        }

        function saveHire(user) {
            var userProject = new Object();
            if(user.projectAssessmentMappingForResultSubmission != null && user.projectAssessmentMappingForResultSubmission != undefined) {
                userProject.user_id = user.projectAssessmentMappingForResultSubmission.user.id;
            }else{
                userProject.user_id = user.user.id;
            }
            userProject.active = 1;
            userProject.project = vm.project;
            console.log(userProject);
            OpenProjectService.addUserToProject(userProject)
                .then(function (status) {
                    if(vm.applicantsResult != null && vm.applicantsResult != undefined) {
                        vm.applicantsResult.splice(vm.applicantsResult.indexOf(user), 1);
                    }else{
                        console.log("Deleted");
                        vm.appliedApplicants.splice(vm.appliedApplicants.indexOf(user), 1);
                    }
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
                    if(calWidth == 100){
                        setProjectStatus(2);
                    }
                });

        }

        function removeHired(){
            var removeData = [];
            if(vm.applicantsResult != null && vm.applicantsResult != undefined){
                for(var i=0; i<vm.applicantsResult.length; i++){
                    for(var j=0; j<vm.hiredUsers.length; j++){
                        if(vm.applicantsResult[i].projectAssessmentMappingForResultSubmission.user.id == vm.hiredUsers[j].user_id){
                            removeData.push(vm.applicantsResult[i]);
                            vm.hiredUsers[j].user_name = vm.applicantsResult[i].projectAssessmentMappingForResultSubmission.user.firstname;
                        }
                    }
                }
                for(var i=0; i<removeData.length; i++){
                    vm.applicantsResult.splice(removeData[i],1);
                }
            }else if(vm.appliedApplicants != null && vm.appliedApplicants != undefined){
                for(var i=0; i<vm.appliedApplicants.length; i++){
                    for(var j=0; j<vm.hiredUsers.length; j++){
                        if(vm.appliedApplicants[i].user.id == vm.hiredUsers[j].user_id){
                            removeData.push(vm.appliedApplicants[i]);
                            vm.hiredUsers[j].user_name = vm.appliedApplicants[i].user.firstname;
                        }
                    }
                }
                for(var i=0; i<removeData.length; i++){
                    vm.appliedApplicants.splice(removeData[i],1);
                }
            }
        }

        function projectStarted() {
            OwnerProjectService.updateProjectStatus(vm.project.id, "IN_PROGRESS")
                .then(function (status) {
                    setProjectStatus(3);
                });
        }

        function setProjectStatus(statusId) {
            if(statusId == 0){
                vm.projectStatus = "SAVED";
            }else if(statusId == 1){
                vm.projectStatus = "OPEN";
            }else if(statusId == 2){
                vm.projectStatus = "CLOSE";
            }else if(statusId == 3){
                vm.projectStatus = "IN_PROGRESS";
            }else{
                vm.projectStatus = "COMPLETED";
            }
        }

        function projectCompleted() {
            OwnerProjectService.updateProjectStatus(vm.project.id, "COMPLETED")
                .then(function (status) {
                    setProjectStatus(4);
                });
        }
    }

})();
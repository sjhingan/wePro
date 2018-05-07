//Client Side controller code for the Open Project
(function () {
    angular
        .module("weProApp")
        .controller("OpenProjectController", openProjectController);

    function openProjectController(OpenProjectService, AssessmentStatusService, $routeParams) {
        var vm = this;
        vm.applyJob = applyJob;
        vm.uid = $routeParams['uid'];

        function init() {
            vm.getOpenProjectsList = undefined;
            loadAllTopics();
        }

        init();

        function loadAllTopics() {
            OpenProjectService.getAllProjects(vm.uid ,"OPEN")
                .then(function (projects) {
                    vm.getOpenProjectsList = projects.data["content"];
                });
        }

        function applyJob(project) {
            var assessment = new Object();
            assessment.user = { "id" : vm.uid};
            assessment.project = {"id" : project.id};
            if(project.assessmentRequired == "Yes"){
                assessment.assesmentStatus = "Pending";
            }else{
                assessment.assesmentStatus = "NA";
            }

            AssessmentStatusService.applyToProject(assessment)
                .then(function (status) {
                    loadAllTopics()
                });
        }

    }

})();
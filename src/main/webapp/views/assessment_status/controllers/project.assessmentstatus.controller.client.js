//Client Side controller code for the Assessment_Status


(function () {
    angular
        .module("weProApp")
        .controller("assessmentStatusController", assessmentStatusController);

    function assessmentStatusController(AssessmentStatusService, $location, $routeParams) {
        var vm = this;
        vm.getAssessmentStatusPending = getAssessmentStatusPending;
        vm.uid = $routeParams['uid'];
        vm.taskAssessment = taskAssessment;

        function init() {
            vm.getAssessmentStatusPending = undefined;
            getAssessmentStatusPending();
        }

        init();


        function getAssessmentStatusPending() {
            AssessmentStatusService.getAllProjectsByOwnerStatus(vm.uid, "Pending")
                .then(function (assessments) {
                    vm.getAssessmentStatusPending = assessments.data;
                    console.log(vm.getAssessmentStatusPending);
                });
        }

        function taskAssessment(assessment) {
            console.log()
            $location.url("/takeassesment/" + vm.uid + "/" + assessment.project.assessmentId);
        }

    }

})();
(function () {
    angular
        .module("weProApp")
        .controller("assessmentStatusController", assessmentStatusController);

    function assessmentStatusController(AssessmentStatusService) {
        var vm = this;
        vm.getAssessmentStatusPending = getAssessmentStatusPending;

        function init() {
            vm.getAssessmentStatus = undefined;
            vm.getAssessmentStatusPending = undefined;
            loadAllTopics();
        }

        init();

        function loadAllTopics() {
            AssessmentStatusService.getAllProjectsByOwner(1)
                .then(function (assessments) {
                    vm.getAssessmentStatus = assessments.data;
                    console.log(vm.getAssessmentStatus);
                });
        }

        function getAssessmentStatusPending(status) {
            AssessmentStatusService.getAllProjectsByOwnerStatus("pending")
                .then(function (assessments) {
                    vm.getAssessmentStatusPending = assessments.data;
                    console.log(vm.getAssessmentStatusPending);
                });
        }


    }

})();
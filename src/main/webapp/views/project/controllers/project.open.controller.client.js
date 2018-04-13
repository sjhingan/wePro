(function () {
    angular
        .module("weProApp")
        .controller("OpenProjectController", openProjectController);

    function openProjectController(OpenProjectService) {
        var vm = this;
        vm.applyJob = applyJob;

        function init() {
            vm.getOpenProjectsList = undefined;
            loadAllTopics();
        }

        init();

        function loadAllTopics() {
            OpenProjectService.getAllProjects("OPEN")
                .then(function (projects) {
                    vm.getOpenProjectsList = projects.data;
                });
        }

        function applyJob(project) {

        }

    }

})();
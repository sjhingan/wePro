(function () {
    angular
        .module("weProApp")
        .controller("OpenProjectController", openProjectController);

    function openProjectController(OpenProjectService) {
        var vm = this;

        function init() {
            vm.getOpenProjectsList = undefined;
            loadAllTopics();
        }

        init();

        function loadAllTopics() {
            OpenProjectService.getAllProjects("OPEN")
                .then(function (projects) {
                    vm.getOpenProjectsList = projects.data;
                    console.log(vm.getOpenProjectsList);
                });
        }
    }

})();
(function () {
    angular
        .module("weProApp")
        .controller("OwnerProjectController", ownerProjectController);
    
    function ownerProjectController($routeParams, OpenProjectService) {
        var vm = this;
        vm.uid = $routeParams['uid'];
        vm.createProject = createProject;


        function init() {
            vm.getOwnerProjectsList = undefined;
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
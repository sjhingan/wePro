(function () {
    angular
        .module("weProApp")
        .controller("OwnerSingleProjectController", ownerSingleProjectController);

    function ownerSingleProjectController($routeParams, OwnerProjectService) {
        var vm = this;
        vm.uid = $routeParams['uid'];
        vm.projectId = $routeParams['projectId'];
        vm.project = undefined;
        vm.getList = [1,2,3,4,5];


        function init() {
            OwnerProjectService.getProjectById(vm.projectId)
                .then(function (project) {
                    vm.project = project.data;
                    console.log(vm.project);
                });
        }

        init();

    }

})();
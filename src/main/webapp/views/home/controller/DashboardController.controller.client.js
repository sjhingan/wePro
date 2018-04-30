(function () {
    angular
        .module("weProApp")
        .controller("DashboardController", DashboardController);

    function DashboardController($routeParams) {
        var vm = this;
        vm.uid = $routeParams['uid'];
    }

})();
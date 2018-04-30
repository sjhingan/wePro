(function () {
    angular
        .module("weProApp")
        .controller("DashboardController", DashboardController);

    function DashboardController($routeParams,$location) {
        var vm = this;
        vm.uid = $routeParams['uid'];
    }

})();
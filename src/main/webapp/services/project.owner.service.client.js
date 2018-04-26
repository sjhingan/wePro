(function () {
    angular
        .module("weProApp")
        .factory("OwnerProjectService", ownerProjectService)

    function ownerProjectService($http) {
        var api = {
            getAllProjects : getAllProjects
        };

        return api;

        function getAllProjects(status){
            return $http.get("/project/get?status="+status);
        }
    }

})();
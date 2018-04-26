(function () {
    angular
        .module("weProApp")
        .factory("OpenProjectService", openProjectService)

    function openProjectService($http) {
        var api = {
            getAllProjects : getAllProjects
        };

        return api;

        function getAllProjects(status){
            return $http.get("/project/get?status="+status);
        }
    }

})();
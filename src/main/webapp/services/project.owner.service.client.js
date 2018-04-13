(function () {
    angular
        .module("weProApp")
        .factory("OwnerProjectService", ownerProjectService)

    function ownerProjectService($http) {
        var api = {
            getAllOwnerProjects : getAllOwnerProjects,
            addProject : addProject,
            updateProject : updateProject,
            deleteProject : deleteProject,
            getAllSkills : getAllSkills
        };

        return api;

        function getAllOwnerProjects(uid){
            return $http.get("/project/get/owner/" + uid );
        }

        function addProject(project) {
            return $http.post("/project/add",project);
        }

        function updateProject(project) {
            return $http.put("/project/update",project);
        }

        function deleteProject(projectId) {
            return $http.delete("/project/delete/" + projectId);
        }

        function getAllSkills() {
            return $http.get("/skills/all");
        }
    }

})();
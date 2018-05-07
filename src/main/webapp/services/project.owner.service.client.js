//This Service code is for Project Owner, where each http request is mapped to a function based on its requirement
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
            getAllSkills : getAllSkills,
            getProjectById : getProjectById,
            updateProjectStatus : updateProjectStatus
        };

        return api;

        function getAllOwnerProjects(uid, offset, size){
            return $http.get("/project/get/owner/" + uid +"?page=" + offset + "&size=" + size);
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

        function getProjectById(projectId) {
            return $http.get("/project/get/" + projectId);
        }

        function updateProjectStatus(projectId, status) {
            return $http.put("/project/update/" + projectId + "/" + status);
        }
    }

})();
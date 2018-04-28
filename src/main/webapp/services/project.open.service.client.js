(function () {
    angular
        .module("weProApp")
        .factory("OpenProjectService", openProjectService)

    function openProjectService($http) {
        var api = {
            getAllProjects : getAllProjects,
            getUsersOpenProjects : getUsersOpenProjects,
            getUsersClosedProjects : getUsersClosedProjects,
            addUserToProject : addUserToProject,
            getUsersByProjectId : getUsersByProjectId
        };

        return api;

        function getAllProjects(uid, status){
            return $http.get("/project/get/applying/" + uid + "?status="+status);
        }
        
        /**
         * Method used to map back end method to fetch all the open projects for users
         */
        function getUsersOpenProjects(userId){
            return $http.get("/project/userprojects/"+userId);
        }
        
        /**
         * Method to map with back end mapping to fetch closed projects
         */
        function getUsersClosedProjects(userId){
            return $http.get("/project/userprojects/history/"+userId);
        }

        function addUserToProject(userProject) {
            return $http.post("/project/userprojects/add", userProject);
        }

        function getUsersByProjectId(projectId) {
            return $http.get("/project/userprojects/getusers/" + projectId);
        }
    }

})();
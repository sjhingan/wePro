//This Service code is for assessment_status where each http request is mapped to a function based on its requirement

(function () {
    angular
        .module("weProApp")
        .factory("AssessmentStatusService", assessmentStatusService)

    function assessmentStatusService($http) {
        var api = {
            getAllProjectsByOwner : getAllProjectsByOwner,
            getAllProjectsByOwnerStatus : getAllProjectsByOwnerStatus,
            applyToProject : applyToProject,
            getAssessmentResultsById : getAssessmentResultsById,
            getAssessmentsByProjectId : getAssessmentsByProjectId
        };

        return api;

        function getAllProjectsByOwner(uid){
            return $http.get("/assessment_status/get/"+uid);
        }

        function getAllProjectsByOwnerStatus(uid, status){
            return $http.get("/assessment_status/get/"+uid+"/"+status);
        }

        function applyToProject(assessment) {
            return $http.post("/assessment_status/add", assessment);
        }

        function getAssessmentResultsById(assessmentId) {
            return $http.get("/assessment/result/get/" + assessmentId);
        }

        function getAssessmentsByProjectId(projectId) {
            return $http.get("/assessment_status/get/applied/" + projectId);
        }
    }

})();
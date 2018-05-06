(function () {
    angular
        .module("weProApp")
        .factory("ManagerHireAssessService", ManagerHireAssessService)

    function ManagerHireAssessService($http) {
        var api = {
        		addAssessment : addAssessment
        };

        return api;

        /**
         * Sends post request to server to save the assessment data into DB.
         * @param List of all questions from the assessment
         * @return 
         */
        function addAssessment(projectId,assessmentSet){
            return $http.post("/assessment/add/"+projectId,assessmentSet);
        }
    }

})();
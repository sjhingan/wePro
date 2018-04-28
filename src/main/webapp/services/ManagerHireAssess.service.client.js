(function () {
    angular
        .module("weProApp")
        .factory("ManagerHireAssessService", ManagerHireAssessService)

    function ManagerHireAssessService($http) {
        var api = {
        		addAssessment : addAssessment
        };

        return api;

        function addAssessment(projectId,assessmentSet){
            return $http.post("/assessment/add/"+projectId,assessmentSet);
        }
    }

})();
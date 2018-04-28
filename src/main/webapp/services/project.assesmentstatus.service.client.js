(function () {
    angular
        .module("weProApp")
        .factory("AssessmentStatusService", assessmentStatusService)

    function assessmentStatusService($http) {
        var api = {
            getAllProjectsByOwner : getAllProjectsByOwner,
            getAllProjectsByOwnerStatus : getAllProjectsByOwnerStatus
        };

        return api;

        function getAllProjectsByOwner(uid){
            return $http.get("/assessment_status/get/"+uid);
        }

        function getAllProjectsByOwnerStatus(uid, status){
            return $http.get("/assessment_status/get/"+uid+"/"+status);
        }
    }

})();
(function () {
    angular
        .module("weProApp")
        .factory("ProfileService", profileService)

    function profileService($http) {

        var api = {
            getAllTopics : getAllTopics,
            addTopic : addTopic,
            updateProfile : updateProfile,
            getProfile : getProfile
        }

        return api;

        function getAllTopics() {
            return $http.get("/topics");
        }

        function addTopic(topic) {
            return $http.post("/topics",topic);
        }
        function updateProfile(profile) {
            return $http.put("/userprofile/updateProfile/"+1,profile);
        }
        function getProfile(userId){
            return $http.get("/userprofile/getprofile/"+1);
        }
    }
})();
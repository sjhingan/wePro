(function () {
    angular
        .module("weProApp")
        .factory("ProfileService", profileService)

    function profileService($http) {

        var api = {
            getAllTopics : getAllTopics,
            addTopic : addTopic,
            updateProfile : updateProfile,
            getProfile : getProfile,
            getAllSkills : getAllSkills,
            updateSkills : updateSkills
        }

        return api;

        function getAllTopics() {
            return $http.get("/topics");
        }

        function addTopic(topic) {
            return $http.post("/topics",topic);
        }
        function updateProfile(profile, userId) {
            return $http.put("/userprofile/updateProfile/"+userId,profile);
        }
        function getProfile(userId){
        	console.log("Inside GUI service :"+userId);
            return $http.get("/userprofile/getprofile/"+userId);
        }
        function getAllSkills() {
                    return $http.get("/skills/all");
        }
        function updateSkills(uid,skills){
            return $http.post("/userprofile/update/skills/"+uid, skills);
        }
    }
})();
(function () {
    angular
        .module("weProApp")
        .factory("TopicService", topicService)
    
    function topicService($http) {

        var api = {
            getAllTopics : getAllTopics,
            addTopic : addTopic
        }

        return api;
        
        function getAllTopics() {
            return $http.get("/topics");
        }

        function addTopic(topic) {
            return $http.post("/topics",topic);
        }
    }
})();
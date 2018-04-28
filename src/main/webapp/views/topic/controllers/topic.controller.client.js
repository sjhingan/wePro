(function () {
    angular
        .module("weProApp")
        .controller("TopicController",topicController);

    function topicController(TopicService) {
        var vm = this;
        vm.addTopic = addTopic;

        function init() {

            vm.topics = undefined;
            loadAllTopics();
        }


        init();

        function loadAllTopics() {
            TopicService.getAllTopics()
                .then(function (topics) {
                    vm.topics = topics.data;
                });
        }
        
        function addTopic(topic) {
            console.log(topic);

            console.log("Hi, some one clicked addTopic")

            TopicService.addTopic(topic)
                .then(function (status) {
                    init();
                });
        }
    }
})();
(function () {
    angular
        .module("weProApp")
        .controller("ProfileController",profileController);

    function profileController(TopicService) {
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
            TopicService.addTopic(topic)
                .then(function (status) {
                    init();
                });
        }
    }
})();
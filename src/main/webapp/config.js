(function () {
    angular
        .module("weProApp")
        .config(configuration);

    function configuration($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl: "views/topic/templates/topic.view.client.html",
                controller: "TopicController",
                controllerAs: "model"
            })
            .when("/project/:uid/open", {
                templateUrl: "views/project/templates/project.open.view.client.html",
                controller: "OpenProjectController",
                controllerAs: "model"
            })
            .when("/project/:uid/add", {
                templateUrl: "views/project/templates/project.owner.view.client.html",
                controller: "OwnerProjectController",
                controllerAs: "model"
            })
            .when("/project/individual/:uid/:projectId", {
                templateUrl: "views/project/templates/project.owner.individual.view.client.html",
                controller: "OwnerSingleProjectController",
                controllerAs: "model"
            })
            .otherwise({
                redirectTo: "/"
            });
    };
})();
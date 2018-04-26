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

            .when("/mhire", {
                templateUrl: "views/ManagerHireAssess/templates/ManagerHireAssess.view.client.html",
                controller: "ManagerHireAssess",
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
            .otherwise({
                redirectTo: "/"
            });
    };
})();

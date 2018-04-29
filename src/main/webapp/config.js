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
            .when("/takeassessment", {
	                templateUrl: "views/takeassessment/templates/takeassessment.view.client.html",		
	                controller: "TakeAssessmentController",		
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
            .when("/login", {
                templateUrl: "views/Login/templates/login.view.client.html",
                controller: "LoginController",
                controllerAs: "model"
            })
            .when("/home", {
                templateUrl: "views/home/templates/dashboard.html",
                controller: "HomeController",
                controllerAs: "model"
            })
            .when("/register", {
                templateUrl: "views/Register/templates/register.view.client.html",
                controller: "RegisterController",
                controllerAs: "model"
            })
            .otherwise({
                redirectTo: "/login"
            });
    }
    run.$inject = ['$rootScope'];

    function run(){
        console.clear();
    }
})();
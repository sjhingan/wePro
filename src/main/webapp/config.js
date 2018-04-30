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
            .when("/mhire/:uid/:projectId", {
                templateUrl: "views/ManagerHireAssess/templates/ManagerHireAssess.view.client.html",
                controller: "ManagerHireAssess",
				controllerAs: "model"
            })
            .when("/takeassesment/:uid/:assessmentId", {
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
            .when("/project/individual/:uid/:projectId", {
                templateUrl: "views/project/templates/project.owner.individual.view.client.html",
                controller: "OwnerSingleProjectController",
                controllerAs: "model"
            })
            .when("/login", {
                templateUrl: "views/Login/templates/login.view.client.html",
                controller: "LoginController",
                controllerAs: "model"
            })
            .when("/register", {
                templateUrl: "views/Register/templates/register.view.client.html",
                controller: "RegisterController",
                controllerAs: "model"
            })
            .when("/assessment_status/:uid", {
                templateUrl: "views/assessment_status/templates/project.assessmentStatus.view.client.html",
                controller: "assessmentStatusController",
                controllerAs: "model"
            })
            .when("/project/userprojects/:uid", {
                templateUrl: "views/project/templates/UserOpenProjects.html",
                controller: "UserOpenProjects",
                controllerAs: "model"
            })
            // http://localhost:8090/#/project/userprojects/history/1
            .when("/project/userprojects/history/:uid", {
                templateUrl: "views/project/templates/UserClosedProjects.html",
                controller: "UserClosedProjects",
                controllerAs: "model"
            })
            .when("/profile/viewprofile/:uid", {
                 templateUrl: "views/profile/templates/profile.view.client.html",
                 controller: "UserProfileController",
                 controllerAs: "model"
             })
             .when("/profile/setprofile/:uid", {
                  templateUrl: "views/profile/templates/profile.setprofile.html",
                  controller: "SetProfileController",
                  controllerAs: "model"
             })
            .when("/dashboard", {
                templateUrl: "views/home/templates/dashboard.html",
                controller: "DashboardController",
                controllerAs: "model"
            })
            .when("/notifications/:uid", {
                templateUrl: "views/notification/templates/notification.html",
                controller: "NotificationController",
                controllerAs: "model"
            })
            .when("/home", {
                templateUrl: "views/home/templates/home.html",
                controller: "DashboardController",
                controllerAs: "model"
            })
            .otherwise({
                redirectTo: "/home"
            });
    };
    run.$inject = ['$rootScope'];

    function run(){
        console.clear();
    }

})();

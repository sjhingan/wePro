(function () {
    angular
        .module("weProApp")
        .factory("NotificationService", notificationService)

    function notificationService($http) {
        var api = {
        	getAllNotificationForUser : getAllNotificationForUser,
        	markNotificationAsRead : markNotificationAsRead,
        	deleteNotification : deleteNotification
        };

        return api;

        function getAllNotificationForUser(userId){
            return $http.get("/notification/get/"+userId);
        }
        
        function markNotificationAsRead(notificationId){
            return $http.get("/notification/markRead/"+notificationId);
        }
        
        function deleteNotification(notificationId){
            return $http.get("/notification/delete/"+notificationId);
        }
    }

})();
(function () {
    angular
        .module("weProApp")
        .controller("NotificationController", notificationController);

    
    function notificationController(NotificationService, $routeParams) {
        var vm = this;
        vm.notificationList = undefined;
        vm.uid = $routeParams['uid'];
        /**
         * This method will load all the notification  for a user
         */
        function loadAllNotificationsForUser() {
        	NotificationService.getAllNotificationForUser(vm.uid)
                .then(function (projects) {
                	console.log(projects.data);
                	vm.notificationList = projects.data;
                	
                });
        }
        
        loadAllNotificationsForUser();
        
        /**
         * Method used to mark a notification as read
         */
        this.markRead = function markRead(notificationId) {
        	NotificationService.markNotificationAsRead(notificationId)
            .then(function (projects) {
            	console.log(projects.data);
            	vm.notificationList = projects.data;
            	
            });
          };
          
          /**
           * Method used to delete a user notification
           */
          this.deleteNotification = function deleteNotification(notificationId) {
          	NotificationService.deleteNotification(notificationId)
              .then(function (projects) {
              	console.log(projects.data);
              	vm.notificationList = projects.data;
              	
              });
            };
    }
})();
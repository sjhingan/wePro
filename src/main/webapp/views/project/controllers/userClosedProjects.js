(function () {
    angular
        .module("weProApp")
        .controller("UserClosedProjects", userClosedProjects);

    
    function userClosedProjects(OpenProjectService) {
        var vm = this;
        vm.getUsersClosedProjectsList = undefined;
        vm.dataTableOpt = {
        		   //custom datatable options 
        		  // or load data through ajax call also
        		  "aLengthMenu": [[10, 50, 100,-1], [10, 50, 100,'All']],
        		  };
        
        
        function loadUsersClosedProjects() {
            OpenProjectService.getUsersClosedProjects("1")
                .then(function (projects) {
                	console.log(projects.data);
                	vm.getUsersClosedProjectsList = projects.data;
                	
                });
        }
        
        loadUsersClosedProjects();
  
    }

})();
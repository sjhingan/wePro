(function () {
    angular
        .module("weProApp",)
        .controller("UserOpenProjects", userOpenProjects);

    
    function userOpenProjects(OpenProjectService, $routeParams) {
        var vm = this;
        vm.getUsersOpenProjectsList = undefined;
        vm.dataTableOpt = {
        		   //custom datatable options 
        		  // or load data through ajax call also
        		  "aLengthMenu": [[10, 50, 100,-1], [10, 50, 100,'All']],
        		  };
        vm.uid = $routeParams['uid'];
        
        
        function loadUsersOpenProjects() {
            OpenProjectService.getUsersOpenProjects(vm.uid)
                .then(function (projects) {
                	console.log(projects.data);
                	vm.getUsersOpenProjectsList = projects.data;
                	//return vm.getUsersOpenProjectsList;
                    
                });
        }
        
        loadUsersOpenProjects();
       
    }

})();
(function () {
    angular
        .module("weProApp")
        .controller("OwnerProjectController", ownerProjectController);
    
    function ownerProjectController($routeParams, OwnerProjectService) {
        var vm = this;
        vm.uid = $routeParams['uid'];
        vm.addProject = addProject;
        vm.editProject = editProject;
        vm.updateProject = updateProject;
        vm.deleteProjectPrompt = deleteProjectPrompt;
        vm.deleteProject = deleteProject;




        function init() {
            vm.getOwnerProjectsList = undefined;
            loadAllOwnerProjects();
            vm.allSkills = undefined;
            loadSkills();
        }

        init();

        function loadAllOwnerProjects() {
            OwnerProjectService.getAllOwnerProjects(vm.uid)
                .then(function (projects) {
                    vm.getOwnerProjectsList = projects.data;
                    console.log(vm.getOwnerProjectsList);
                });
        }

        function addProject(project) {
            if(project != null && project !== undefined){
                project.owner = vm.uid;
                console.log(project);
                OwnerProjectService.addProject(project)
                    .then(function (status) {
                        $('#addProject').modal('hide');
                        init();
                    });
            }
        }

        function editProject(project) {
            vm.editingProject = JSON.parse(JSON.stringify(project));
            vm.editingProject.dueDate = new Date(project.dueDate);
            $('#editProject').modal('show');
        }

        function updateProject(project) {
            OwnerProjectService.updateProject(project)
                .then(function (status) {
                    $('#editProject').modal('hide');
                    init();
                });
        }

        function deleteProjectPrompt(project) {
            vm.deletingProject = project;
            $('#deleteProject').modal('show');
        }

        function deleteProject(project) {
            OwnerProjectService.deleteProject(project.id)
                .then(function (status) {
                    $('#deleteProject').modal('hide');
                    init();
                });
        }

        function loadSkills() {
            OwnerProjectService.getAllSkills()
                .then(function (skills) {
                   vm.allSkills = skills.data;
                });
        }
    }

})();
(function () {
    angular
        .module("weProApp")
        .controller("OwnerProjectController", ownerProjectController);

    function ownerProjectController($routeParams, OwnerProjectService, $location) {
        var vm = this;
        vm.uid = $routeParams['uid'];
        vm.addProject = addProject;
        vm.editProject = editProject;
        vm.updateProject = updateProject;
        vm.deleteProjectPrompt = deleteProjectPrompt;
        vm.deleteProject = deleteProject;
        vm.setPage = setPage;
        vm.ownerIndividualProjectPage = ownerIndividualProjectPage;
        const pageSize = 5;
        var firstLoad = true;
        vm.getProjectStatus = getProjectStatus;
        vm.createAssessment = createAssessment;

        function init() {
            vm.getOwnerProjectsList = undefined;
            loadAllOwnerProjects(0, pageSize);
            vm.allSkills = undefined;
            loadSkills();
        }

        init();


        function loadAllOwnerProjects(offset, size) {
            OwnerProjectService.getAllOwnerProjects(vm.uid, offset, size)
                .then(function (projects) {
                    vm.getOwnerProjectsList = projects.data["content"];
                    vm.totalPages = projects.data["totalPages"];
                    console.log("Total: "+vm.totalPages);
                    if(firstLoad){
                        paginationBlock(1);
                        firstLoad = false;
                    }
                });
        }

        function addProject(project) {
            if(project != null && project !== undefined){
                project.owner = vm.uid;
                project.skills = convertToObject(project.skills);
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
            vm.editingProject.oldSkills = vm.editingProject.skills;
            var skills = [];
            project.skills.forEach(function (skill) {
                skills.push(skill.skillId.toString());
            });
            vm.editingProject.skills = skills.reverse();
            console.log(vm.editingProject);
            $('#editProject').modal('show');
        }

        function updateProject(project) {
            var skills = vm.editingProject.skills;
            var skillsObj = vm.editingProject.oldSkills;
            var allSkills = [];

            for(var i=0; i<skillsObj.length; i++){
                for(var j=0; j<skills.length; j++){
                    if(skills[j] == skillsObj[i].skillId){
                        skills.splice(j,1);
                        allSkills.push(skillsObj[i]);
                        break;
                    }
                }
            }

            skills.forEach(function (newSkill) {
                allSkills.push({
                    skillId : newSkill
                });
            });

            project.skills = allSkills;
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

        function convertToObject(skills) {
            var skillsList = [];
            skills.forEach(function (skill) {
                var skillObj = {};
                skillObj["skillId"] = skill;
                skillsList.push(skillObj);
            });
            return skillsList;
        }

        function setPage(page) {
            paginationBlock(page);
            console.log(page);
            loadAllOwnerProjects(page-1,pageSize)
        }
        
        function paginationBlock(startPage) {
            var endPage;
            vm.currentPage = startPage;
            if (vm.totalPages <= 5) {
                startPage = 1;
                endPage = vm.totalPages;
            } else {
                // if (vm.currentPage <= 3) {
                //     startPage = 1;
                // } else
                    if (vm.currentPage + 1 >= vm.totalPages) {
                    startPage = vm.totalPages - 4;
                        endPage = vm.totalPages;
                } else {
                    startPage = vm.currentPage - 2;
                    endPage = vm.currentPage+2;
                }
            }

            var pagesArray = [];
            for(var i=0; i<endPage; i++){
                pagesArray.push(startPage + i);
            }
            console.log(pagesArray);
            vm.pages = pagesArray;
        }

        function ownerIndividualProjectPage(project) {
            console.log(project.id);
            $location.url("/project/individual/" + vm.uid + "/" + project.id);
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

        function getProjectStatus(statusId) {
            var status;
            if(statusId == 0){
                status = "SAVED";
            }else if(statusId == 1){
                status = "OPEN";
            }else if(statusId == 2){
                status = "CLOSE";
            }else if(statusId == 3){
                status = "IN_PROGRESS";
            }else{
                status = "COMPLETED";
            }
            return status;
        }

        function createAssessment(project) {
            $location.url("/mhire/" + vm.uid + "/" + project.id);
        }
    }

})();
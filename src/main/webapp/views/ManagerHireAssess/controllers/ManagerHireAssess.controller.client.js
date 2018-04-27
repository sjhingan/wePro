(function () {
    angular
        .module("weProApp")
        .controller("ManagerHireAssess",managerHireAssess);

    function managerHireAssess(ManagerHireAssessService) {
        var vm = this;
        vm.assessmentList = []
        vm.addAssessment = addAssessment;
        vm.addQuestion = addQuestion; 

       function addQuestion(assessment)
       {
    	   vm.assessmentList.push("");
       }
       
       function addAssessment(assessment)
       {
    	 //  console.log(assessment);
    	   var assessmentSet =  {"assessmentQuestions":assessment};
    	   console.log(assessmentSet);
    	   var projectId = 9999; 
    	   ManagerHireAssessService.addAssessment(projectId,assessmentSet).then(function (assessment_id) {
               console.log("Assessment ID from server"+assessment_id);
           });
       }    	
    }
})();


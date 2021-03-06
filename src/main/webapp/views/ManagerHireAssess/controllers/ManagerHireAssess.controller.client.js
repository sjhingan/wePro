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
    	   console.log(assessment);
    	   var i;
    	   for(i=0;i<assessment.length;i++)
    		   {
    		   		if(assessment[i].correctAnswer == null)
    		   			alert("Select the correct answer for all questions");
    		   		else
    		   			{
				   			var assessmentSet =  {"assessmentQuestions":assessment};
				     	   console.log(assessmentSet);
				     	   var projectId = 4444; 
				     	   ManagerHireAssessService.addAssessment(projectId,assessmentSet).then(function (assessment_id) {
				                console.log("Assessment ID from server"+assessment_id);
				            });
    		   			}
    		   }   	   
       }    	
    }
})();
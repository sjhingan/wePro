(function () {
    angular
        .module("weProApp")
        .controller("TakeAssessmentController", TakeAssessmentController);

    function TakeAssessmentController(TakeAssessmentService) {
        
    	var vm = this;
        vm.takedata = takedata;
        vm.getallQuestionList = undefined;
        vm.submittedAssessment = [];
        vm.questionid = [];
        vm.submitTakenAssessment = submitTakenAssessment; 
        var assessmentId = "Assessment_4444";
        
        function takedata()
        {
        	
        	TakeAssessmentService.retrieveAssessment(assessmentId).then(function (assessmentList) {
                vm.getallQuestionList = assessmentList.data;
                console.log(vm.getallQuestionList);
        		var i;
            	for(i=0;i<vm.getallQuestionList.length;i++)
            		{
            			vm.questionid[i]=vm.getallQuestionList[i].questionId;
            		}
            });
        }
        
        function submitTakenAssessment(takenAssessment)
        {
        	var i;
        	// We have to handle case if user is not selecting answer for single question.
	        		for(i=0;i<vm.questionid.length;i++)
	        		{
	        			takenAssessment[i].qid=vm.questionid[i];
	        		}     	
        	console.log(takenAssessment);
        	var takenAssessmentSet =  {"submittedQA":takenAssessment,"assessmentId":assessmentId};
     	   console.log(takenAssessmentSet);
     	  TakeAssessmentService.submitAssessmentResult(takenAssessmentSet);
        }
    } //Main Function End

})();
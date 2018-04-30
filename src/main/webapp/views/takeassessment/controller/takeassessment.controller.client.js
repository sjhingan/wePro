(function () {
    angular
        .module("weProApp")
        .controller("TakeAssessmentController", TakeAssessmentController);

    function TakeAssessmentController(TakeAssessmentService, $routeParams, $location) {
        
    	var vm = this;
        vm.takedata = takedata;
        vm.getallQuestionList = undefined;
        vm.submittedAssessment = [];
        vm.questionid = [];
        vm.submitTakenAssessment = submitTakenAssessment;
        vm.uid = $routeParams['uid'];
        vm.assessmentId = $routeParams['assessmentId'];
        
        function takedata()
        {
        	
        	TakeAssessmentService.retrieveAssessment(vm.assessmentId).then(function (assessmentList) {
                vm.getallQuestionList = assessmentList.data;
                console.log(vm.getallQuestionList);
        		var i;
            	for(i=0;i<vm.getallQuestionList.length;i++)
            		{
            			vm.questionid[i]=vm.getallQuestionList[i].questionId;
            		}
            });
        }

        takedata();
        
        function submitTakenAssessment(takenAssessment)
        {
        	var i;
        	// We have to handle case if user is not selecting answer for single question.
	        		for(i=0;i<vm.questionid.length;i++)
	        		{
                        if(takenAssessment[i] == null)
                        {
                            takenAssessment.push({"qid":vm.questionid[i],"selectedSolution":"0"});
                        }
	        			takenAssessment[i].qid=vm.questionid[i];
	        		}     	
        	console.log(takenAssessment);
        	var takenAssessmentSet =  {"submittedQA":takenAssessment,"assessmentId":vm.assessmentId};
     	   console.log(takenAssessmentSet);
     	  TakeAssessmentService.submitAssessmentResult(vm.uid, takenAssessmentSet)
              .then(function (status) {
                  $location.url("/assessment_status/" + vm.uid);
              });
        }
    } //Main Function End

})();
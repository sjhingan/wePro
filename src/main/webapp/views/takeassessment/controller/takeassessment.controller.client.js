(function () {
    angular
        .module("weProApp")
        .controller("TakeAssessmentController", takeAssessmentController);

    function takeAssessmentController(TakeAssessmentService) {
        
    	var vm = this;
        vm.takedata = takedata;
        vm.getallQuestionList = undefined;
        //alert('Inside Controller!');
        
        function takedata()
        {
        	//alert('Inside function in controller');
        	var assessmentId = "Assessment_9999";
        	TakeAssessmentService.retrieveAssessment(assessmentId).then(function (assessmentList) {
                vm.getallQuestionList = assessmentList.data;
                //console.log(assessmentList);
        		console.log(vm.getallQuestionList);
            });
        }
        
        

    } //Main Function End

})();
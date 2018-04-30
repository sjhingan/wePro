(function () {
    angular
        .module("weProApp")
        .factory("TakeAssessmentService", TakeAssessmentService)
        
       
    	function TakeAssessmentService($http) {
            var api = {
            		retrieveAssessment : retrieveAssessment,
            		submitAssessmentResult : submitAssessmentResult
            };

            return api;

            function retrieveAssessment(assessmentId){
            	//alert('Inside Service Function');
                return $http.get("/assessment/get/"+assessmentId);
            }
            
            function submitAssessmentResult(userId, takenAssessmentSet)
            {
            	return $http.post("/assessment/result/add/" + userId,takenAssessmentSet);
            }
        }    	
    	
})();
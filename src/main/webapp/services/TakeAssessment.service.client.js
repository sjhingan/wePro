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

            /**
             * Sends get request to server to get the details of the assessment
             * @param assessmentId
             * @return 
             */
            function retrieveAssessment(assessmentId){
            	//alert('Inside Service Function');
                return $http.get("/assessment/get/"+assessmentId);
            }
            
            /**
             * Sends post request to server to save the data of taken_assesment
             * @param userId
             * @param set of questionId & their respective selected answer
             * @return 
             */
            function submitAssessmentResult(userId, takenAssessmentSet)
            {
            	return $http.post("/assessment/result/add/" + userId,takenAssessmentSet);
            }
        }    	
    	
})();
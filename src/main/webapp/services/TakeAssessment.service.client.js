(function () {
    angular
        .module("weProApp")
        .factory("TakeAssessmentService", TakeAssessmentService)
        
       
    	function TakeAssessmentService($http) {
            var api = {
            		retrieveAssessment : retrieveAssessment
            };

            return api;

            function retrieveAssessment(assessmentId){
            	//alert('Inside Service Function');
                return $http.get("/assessment/get/"+assessmentId);
            }
        }    	
    	
})();
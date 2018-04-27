(function () {
    angular
        .module("weProApp")
        .controller("ManagerHireAssess",managerHireAssess);

    function managerHireAssess() {
        var vm = this;
        vm.displayedForms = [];
        vm.addForm = addForm;
        
        var forms = [
	      "form1.tpl.html",
	    ];

       function addForm(formIndex) {
      		vm.displayedForms.push(forms[formIndex]);
    	}
    	
    	
    }
})();
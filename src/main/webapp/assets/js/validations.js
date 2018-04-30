window.onload = function() {

    var highlight = document.getElementsByClassName("hilightable");

    for (var i = 0; i < highlight.length; i++) {
        highlight[i].addEventListener("focus", toggleHighlight);
        highlight[i].addEventListener("blur", toggleHighlight);
    }

    function toggleHighlight(e){
        e.target.classList.toggle("highlight");
    }

    var required = document.getElementsByClassName("required");

    function submit(e){
        e.preventDefault();

        if(required[0].value === ""){
            required[0].classList.add("error");
        }
        if(required[1].value === ""){
            required[1].classList.add("error");
        }
        if(required[2].value === ""){
            required[2].classList.add("error");
        }
    }

    document.getElementById("addProject").onsubmit = submit;

    for (var i = 0; i < required.length; i++) {
        required[i].addEventListener("change", removeError);
    }

    function removeError(e){
        e.target.classList.remove("error");
    }

}
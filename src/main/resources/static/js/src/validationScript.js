var formValidation = function () {
    var elementValid = document.getElementsByClassName("text-field");
    var errCount = 0;
    for(var i=elementValid.length-1;i>=0;i--) {
        if (elementValid[i].value !="") {
            elementValid[i].style.color="black";
            if (errCount>0)
                errCount--;
        }
        else{
            alert("Элемент: " + elementValid[i].placeholder + "\nНе может быть пустым");
            elementValid[i].focus();
            elementValid[i].style.color ="red";
            errCount++;
        }
    }
    return errCount === 0
};
var formValidation = function () {
    var elementValid = document.getElementsByClassName("text-field");
    var noValidArray = [];
    var errCount = 0;
    for(var i=elementValid.length-1;i>=0;i--) {
        if (elementValid[i].value !="") {
            elementValid[i].style.color="black";
            if (errCount>0)
                errCount--;
        }
        else{
            noValidArray.push(elementValid[i]);
            elementValid[i].focus();
            elementValid[i].style.color ="red";
            errCount++;
        }

    }
    if (noValidArray.length > 0){
        alert("Элемент: " + noValidArray[noValidArray.length - 1].placeholder + "\nНе может быть пустым");
    }
    return noValidArray.length === 0
};
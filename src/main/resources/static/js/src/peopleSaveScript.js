var SaveNewPeople = function () {
    var JSONObject = {
        'firstName': document.querySelector("[name='firstName']").value,
        'secondName': document.querySelector("[name='secondName']").value,
        'thirdName': document.querySelector("[name = 'thirdName']").value,
        'age': document.querySelector("[name='age']").value,
        'mobilephoneNumber': document.querySelector("[name='mobilephoneNumber']").value,
        'telephoneNomber': document.querySelector("[name= 'telephoneNomber']").value,
        'bday': document.querySelector("[name='bday']").value,
        'homeAddres': document.querySelector("[name='homeAddres']").value,
        'gender': document.querySelector("[name='gender']").value,
        'isMarry': document.querySelector("[name='isMarry'").checked
    };
    if (validationCookieData() & formValidation()) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:9191/peoples/save/new',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: true,
            success: function (result) {
                alert(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
}
var authorisation = function () {
    var authJsonObject = {
        "login": document.getElementById("login").value,
        "password": document.getElementById("password").value
    };
    if (formValidation()) {
        $.ajax({
            type: "POST",
            url: "",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(authJsonObject),
            dataType: 'json',
            async: false,
            success: function (authResult) {
                window.location("http://localhost:9090/peoples/save/authResult")
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText + "\n" + textStatus.toString() + "\n" +
                errorThrown.toString());
            }
        })
    }
}
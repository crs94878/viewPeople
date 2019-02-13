var authorisation = function () {
    var authJsonObject = {
        "login": document.getElementById("login").value,
        "password": document.getElementById("password").value,
        "appName": "TODO"
    };
    if (formValidation()) {
        $.ajax({
            type: "POST",
            url: "http://localhost:9090/session/auth",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(authJsonObject),
            dataType: 'json',
            async: false,
            success: function (authResult) {
                if(sessionAuthResponseParser(authResult)) {
                    location.href = "http://localhost:9090/peoples/view/"
                }
                else alert("Авторизация НЕ была пройдена")
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText + "\n" + textStatus.toString() + "\n" +
                errorThrown.toString());
            }
        })
    }
};

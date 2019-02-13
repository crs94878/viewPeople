var sessionAuthResponseParser = function (response) {
    if (response["validation"]) {
        var date = new Date(new Date().getTime() + (60 * 2) * 1000);
        document.cookie = "token=" + response["tokenStr"] + "; path=/;" + "expires=" + date.toDateString();
        document.cookie = "userName=" + response["userName"] + "; path=/;" + "expires=" + date.toDateString();
        document.cookie = "sessionId=" + response["sessionId"] + "; path=/;" + "expires=" + date.toDateString();
        document.cookie = "dateAuth=" + response["dateAuth"] + "; path=/;" + "expires=" + date.toDateString();
        return true;
    }
    return false;
};

function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}

var validationCookieData = function () {
    var session = {
        "sessionId": getCookie("sessionId"),
        "userName": getCookie("userName"),
        "tokenStr": getCookie("token"),
        "dateAuth": getCookie("dateAuth")
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:9090/session/validation',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(session),
        dataType: 'json',
        async: true,
        success: function (result) {
            if(getCookie("sessionId" === result["sessionName"]))
            return result["validation"];
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Вам необходимо авторизоваться");
            location.href = 'http://localhost:9090/page/auth'
            return false;
        }
    });
}
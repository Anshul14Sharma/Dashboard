function login(url, obj){
    $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify(obj),
                headers: {
                'Content-Type': 'application/json'
            },
            contentType: "application/json",
            crossDomain: true,
//            async: false,
            success: function (response) {
                $("#validCred").show();
                window.location.replace("/dashboard");
            },
            error: function(e,response, xhr){
                 if(e.status == 401){
                    $("#invalidCred").show();
                 }
            }
     });
}
function loginAdmin(){
    var email = $('#inputEmail').val();
    var password = $('#inputPassword').val();
    var obj = {
        email: email,
        password: password,
    };
    login("/dashboard/login", obj);
}
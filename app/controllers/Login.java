package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class Login extends Controller {

    public Result loginPage() {
        return ok(views.html.login.render());
    }

    public Result login(Http.Request request) {
        try {
            JsonNode form = request().body().asJson();
            if (form != null) {
                Logger.info("for::{}", form);
                String email = form.get("email").asText();
                String pwd = form.get("password").asText();
                if (checkEmailAndPwd(email, pwd)) {
                    return ok("200").addingToSession(request, "connected", email);
                } else {
                    return unauthorized();
                }
            } else {
                return badRequest();
            }
        } catch (Exception e) {
            return internalServerError();
        }
    }

    private boolean checkEmailAndPwd(String email, String pwd) {
        if (email.equals("admin@gmail.com") && pwd.equals("admin")) {
            return true;
        }
        return false;
    }

    public Result logout(Http.Request request) {
        return redirect(routes.Login.loginPage()).removingFromSession(request, "connected");
    }
}

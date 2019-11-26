package controllers.action;

import controllers.routes;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import java.util.Optional;

public class Secured extends Security.Authenticator {

    @Override
    public Optional<String> getUsername(Http.Request request) {
        return request.session().getOptional("connected");
    }

    @Override
    public Result onUnauthorized(Http.Request request) {
        return redirect(routes.Login.loginPage());
    }
}

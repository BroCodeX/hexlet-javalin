package exercise.controller;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;


public class SessionsController {
    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    public static void create(Context ctx) {
        String nickname = ctx.formParam("nickname");
//        try {
//            String password = ctx.formParamAsClass("password", String.class)
//                    .check(pass -> !pass.isEmpty(), "Pass is empty")
//                    .check(pass -> pass.length() >= 8, "Pass is less then 8 chars")
//                    .get();
//            ctx.sessionAttribute("currentUser", nickname);
//            ctx.redirect(NamedRoutes.rootPath());
//        } catch (ValidationException ex) {
//            String password = ctx.formParam("nickname");
//
//        }
        String password = ctx.formParam("password");
        ctx.sessionAttribute("currentUser", nickname);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
}

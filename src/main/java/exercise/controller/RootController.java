package exercise.controller;
import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.MainPage;
import io.javalin.http.Context;

public class RootController {
    public static void index(Context ctx) {
        Boolean cookieVisited = Boolean.valueOf(ctx.cookie("visited"));
        String session = ctx.sessionAttribute("currentUser");
        MainPage page = new MainPage(session, cookieVisited);
        ctx.cookie("visited", String.valueOf(true));
        ctx.render("index.jte", model("page", page));
    }
}

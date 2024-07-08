package exercise;

import exercise.dto.users.BuildUserPage;
import io.javalin.Javalin;

import java.sql.ResultSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", UsersController::index);

        app.get("/users/build", UsersController::build);

        app.patch("/users/{id}", UsersController::update);

        app.delete("/users/{id}", UsersController::destroy);

        app.post("/users", UsersController::create);

        app.get("/users/{id}", UsersController::show);

        app.get("/users/{id}/edit", UsersController::edit);

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

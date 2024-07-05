package exercise;

import exercise.dto.users.BuildUserPage;
import io.javalin.Javalin;
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

        app.get("/u", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
//            var page = new BuildUserPage();
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/u/build", context -> {
            var page = new BuildUserPage();
            context.render("users/build.jte", model("page", page));
        });

        app.get("/u/{id}", context -> {
            Long id = context.pathParamAsClass("id", Long.class)
                    .check(num -> num instanceof Long, "It's not long")
                    .get();
            var user = UserRepository.find(id);
            context.result("User is null");
            context.result(user == null ? "User is null" : user.get().getFirstName());
        });

        app.post("/u", context -> {
            var firstName = StringUtils.capitalize(context.formParam("firstName"));
            var lastName = StringUtils.capitalize(context.formParam("lastName"));
            var email = context.formParam("email").trim().toLowerCase();

            try {
                String passwordConfirmation = context.formParam("passwordConfirmation");
                String password = context.formParamAsClass("password", String.class)
                        .check(pass -> pass.equals(passwordConfirmation), "Пароли не совпадают")
                        .check(pass -> pass.length() >= 8, "Пароль не менее 8 символов")
                        .get();
                String passSec = Security.encrypt(password);
                User user = new User(firstName, lastName, email, passSec);
                UserRepository.save(user);
                context.redirect("/u");
            } catch (ValidationException ex) {
                List<User> users = UserRepository.getEntities();
                BuildUserPage page = new BuildUserPage(users, firstName, email, ex.getErrors());
                context.render("users/build.jte", model("page", page));
            }
        });
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

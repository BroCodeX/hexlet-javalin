package exercise;

import exercise.dto.users.BuildUserPage;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import exercise.model.User;
import exercise.repository.UserRepository;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {
    public static void index(Context context) {
        List<User> users = UserRepository.getEntities();
        var page = new UsersPage(users);
        context.render("users/index.jte", model("page", page));
    }

    public static void show(Context context) {
        Long id = context.pathParamAsClass("id", Long.class)
                .check(num -> num instanceof Long, "It's not long")
                .get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        UsersPage page = new UsersPage(List.of(user));
        context.render("users/show.jte", model("page", page));
    }

    public static void build(Context context) {
        var page = new BuildUserPage();
        context.render("users/build.jte", model("page", page));
    }

    public static void create(Context context) {
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
            context.redirect(NamedRoutes.usersPath());
        } catch (ValidationException ex) {
            List<User> users = UserRepository.getEntities();
            BuildUserPage page = new BuildUserPage(users, firstName, email, ex.getErrors());
            context.render("users/build.jte", model("page", page));
        }
    }

    public static void edit(Context context) {
        Long id = context.pathParamAsClass("id", Long.class)
                .check(num -> num instanceof Long, "It's not long")
                .get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        //UsersPage page = new UsersPage(List.of(user));
        UserPage page = new UserPage(user);
        context.render("users/edit.jte", model("page", page));
    }


    public static void update(Context context) {
        var id = context.pathParamAsClass("id", Long.class).get();

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

            User user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(passSec);

            UserRepository.save(user);
            context.redirect(NamedRoutes.usersPath());
        } catch (ValidationException ex) {
            List<User> users = UserRepository.getEntities();
            BuildUserPage page = new BuildUserPage(users, firstName, email, ex.getErrors());
            context.render("users/build.jte", model("page", page));
        }
    }

    public static void destroy(Context context) {
        try {
            Long id = context.pathParamAsClass("id", Long.class)
                    .check(num -> num instanceof Long, "It's not long")
                    .get();
            UserRepository.delete(id);
            context.redirect(NamedRoutes.usersPath());
        } catch (ValidationException ex) {
            context.result(ex.getMessage());
        }

    }
}

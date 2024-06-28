package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.Validator;
import org.example.hexlet.Model;
import org.example.hexlet.DTO;

import java.util.List;
import java.util.Optional;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/users/{id}", ctx -> {
            Integer id = ctx.pathParamAsClass("id", Integer.class).getOrDefault(0);
            if (id == 1) {
                Model model = new Model("Java #1", "New Course desc");
                model.setId(1L);
                DTO dto = new DTO(List.of(model), "This is My header");
                ctx.render("index.jte", model("dto", dto));
            } else {
                throw new NotFoundResponse("This is bad id: " + id);
            }

        });
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.start(7070); // Стартуем веб-сервер
    }
}
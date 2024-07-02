package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import org.apache.commons.text.StringEscapeUtils;


import java.util.List;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/users/prot/{id}", ctx -> {
            var id = ctx.pathParam("id");
            String escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result("This is protected id: " + escapedId);
        });

        app.get("/users/{id}", ctx -> {
            Integer id = ctx.pathParamAsClass("id", Integer.class).getOrDefault(0);
            if (id != 0) {
                Model model = new Model("BroCodeX", "New Course desc");
                model.setId(Long.valueOf(id));
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
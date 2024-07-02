package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import org.apache.commons.text.StringEscapeUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/users", ctx -> {
            Model model = new Model("User 1", "New Course desc 1");
            Model model1 = new Model("User 2", "New Course desc 2");
            Model model2 = new Model("User 3", "New Course desc 3");
            model.setId(1L);
            model1.setId(2L);
            model2.setId(3L);
            List<Model> allModels = new ArrayList<>(List.of(model, model2, model1));
            Long courseNameFilter = ctx.queryParamAsClass("term", Long.class).getOrDefault(0L);
            List<Model> filtredModels = new ArrayList<>();
            if (courseNameFilter != null && courseNameFilter != 0L && courseNameFilter != 10L) {
                filtredModels.add(allModels.stream()
                        .filter(item -> item.getId().equals(courseNameFilter))
                        .findFirst().orElseThrow(() -> new NotFoundResponse("fuck off")));
                DTO fDto = new DTO(filtredModels, "filtredModels");
                ctx.render("indexForm.jte", model("dto", fDto));
            } else if (courseNameFilter != null && courseNameFilter.equals(10L)) {
                DTO dto = new DTO(allModels, "This is terms of Use");
                ctx.render("index.jte", model("dto", dto));
            } else {
                DTO fDto = new DTO(filtredModels, "filtredModels");
                ctx.render("indexForm.jte", model("dto", fDto));
            }
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
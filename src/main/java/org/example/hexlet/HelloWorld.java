package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.validation.Validator;

import java.util.Optional;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/users/{id}/post/{postId}", ctx -> {
            Integer id = ctx.pathParamAsClass("id", Integer.class).getOrDefault(0);
            Integer postId = ctx.pathParamAsClass("postId", Integer.class).getOrDefault(0);
            ctx.result(String.format("id:%d postId:%d", id , postId));
        });
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.start(7070); // Стартуем веб-сервер
    }
}
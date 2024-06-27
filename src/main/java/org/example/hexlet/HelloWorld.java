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
        app.get("/hello", ctx -> {
            var page = ctx.queryParamAsClass("name", String.class);
            String anw = page.get().isEmpty() ? "Hello, World!" : String.format("Hello, %s", page.get());
            ctx.result(anw);
        });
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.start(7070); // Стартуем веб-сервер
    }
}
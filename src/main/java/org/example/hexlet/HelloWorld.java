package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/users", hnd -> hnd.result("GET /users"));
        app.post("/users", hnd -> hnd.result("POST /users"));
        app.start(7070); // Стартуем веб-сервер
    }
}
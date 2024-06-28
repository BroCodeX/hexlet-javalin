package org.example.hexlet;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Model {
    private Long id;

    @ToString.Include
    private String name;
    private String description;

    public Model(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

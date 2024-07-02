package org.example.hexlet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.Model;

import java.util.List;

@AllArgsConstructor
@Getter
public class DTO {
    private List<Model> models;
    private String term;
}

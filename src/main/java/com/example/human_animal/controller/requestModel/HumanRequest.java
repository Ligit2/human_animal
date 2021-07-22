package com.example.human_animal.controller.requestModel;

import java.util.ArrayList;
import java.util.List;

public class HumanRequest {

    private Long id;
    private String name;
    private int age;
    private final List<Long> animalIds = new ArrayList<>();

    public List<Long> getAnimalIds() {
        return animalIds;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

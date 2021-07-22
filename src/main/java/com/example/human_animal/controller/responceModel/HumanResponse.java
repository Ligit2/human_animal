package com.example.human_animal.controller.responceModel;

import java.util.ArrayList;
import java.util.List;

public class HumanResponse {
    private Long id;
    private String name;
    private int age;
    private final List<Long> animalIds = new ArrayList<>();

    public HumanResponse( String name, int age) {
        this.name = name;
        this.age = age;
    }

    public HumanResponse(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

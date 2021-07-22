package com.example.human_animal.controller.requestModel;

public class AnimalRequest {

    private Long id;
    private String name;
    private int age;
    private Long humanId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHumanId(Long humanId) {
        this.humanId = humanId;
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

    public Long getHumanId() {
        return humanId;
    }

}

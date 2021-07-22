package com.example.human_animal.controller.responceModel;

public class AnimalResponse {
    private Long id;
    private String name;
    private int age;
    private Long humanId;

    public AnimalResponse() {
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

    public void setHumanId(Long humanId) {
        this.humanId = humanId;
    }

    public AnimalResponse( String name, int age, Long humanId) {
        this.name = name;
        this.age = age;
        this.humanId = humanId;
    }

    public AnimalResponse(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public AnimalResponse(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

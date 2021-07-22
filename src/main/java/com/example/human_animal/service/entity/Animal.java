package com.example.human_animal.service.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    private Human human;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {
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

    public Human getHuman() {
        return human;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && id.equals(animal.id) && name.equals(animal.name) && human.equals(animal.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, human);
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
                ", age=" + age;
    }
}

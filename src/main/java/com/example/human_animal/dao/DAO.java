package com.example.human_animal.dao;

import com.example.human_animal.service.entity.Human;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import com.example.human_animal.service.entity.Animal;


import java.util.List;

@Component
public class DAO {

    private SessionFactory sessionFactory = new Configuration().
            configure("hibernate.cfg.xml").
            addAnnotatedClass(Animal.class).
            addAnnotatedClass(Human.class).
            buildSessionFactory();

    public void createAnimal(Animal animal) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(animal);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public Animal getAnimalById(Long animalId) {
        sessionFactory.getCurrentSession().beginTransaction();
        Animal animal = sessionFactory.getCurrentSession().find(Animal.class, animalId);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return animal;
    }

    public void deleteAnimal(Long animalId) {
        Animal animalById = getAnimalById(animalId);
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(animalById);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public void updateAnimalByName(Long animalId, String name) {
        sessionFactory.getCurrentSession().beginTransaction();
        Animal animal = sessionFactory.getCurrentSession().find(Animal.class, animalId);
        animal.setName(name);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public void updateAnimalByAge(Long animalId, int age) {
        sessionFactory.getCurrentSession().beginTransaction();
        Animal animal = sessionFactory.getCurrentSession().find(Animal.class, animalId);
        animal.setAge(age);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public void updateAnimalByHumanId(Long animalId, Long humanId) {
        Human humanById = getHumanById(humanId);
        sessionFactory.getCurrentSession().beginTransaction();
        Animal animal = sessionFactory.getCurrentSession().find(Animal.class, animalId);
        animal.setHuman(humanById);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public Human getHumanById(Long humanId) {
        sessionFactory.getCurrentSession().beginTransaction();
        Human human = sessionFactory.getCurrentSession().get(Human.class, humanId);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return human;
    }

    public List<Animal> getAllAnimals() {
        sessionFactory.getCurrentSession().beginTransaction();
        List<Animal> animals = sessionFactory.getCurrentSession().createQuery("from Animal").list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return animals;
    }

    public void createHuman(Human human) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(human);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public void deleteHuman(Long humanId) {
        Human humanById = getHumanById(humanId);
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(humanById);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public List<Human> getAllHumans() {
        sessionFactory.getCurrentSession().beginTransaction();
        List<Human> humans = sessionFactory.getCurrentSession().createQuery("from Human").list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return humans;
    }

    public void updateHumanByName(Long humanId, String name) {
        sessionFactory.getCurrentSession().beginTransaction();
        Human human = sessionFactory.getCurrentSession().find(Human.class, humanId);
        human.setName(name);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public void updateHumanByAge(Long humanId, int age) {
        sessionFactory.getCurrentSession().beginTransaction();
        Human human = sessionFactory.getCurrentSession().find(Human.class, humanId);
        human.setAge(age);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }
}

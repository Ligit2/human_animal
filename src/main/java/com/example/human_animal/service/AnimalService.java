package com.example.human_animal.service;

import com.example.human_animal.controller.responceModel.AnimalResponse;
import com.example.human_animal.controller.requestModel.AnimalRequest;
import com.example.human_animal.dao.DAO;
import com.example.human_animal.service.entity.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private final DAO dao;

    public AnimalService(DAO dao) {
        this.dao = dao;
    }

    public void create(AnimalRequest animalRequest) {
        Animal animal = new Animal(animalRequest.getName(),animalRequest.getAge());
        dao.createAnimal(animal);
    }

    public AnimalResponse getById(Long animalId) {
        Animal animalById = dao.getAnimalById(animalId);
        AnimalResponse animalResponse = new AnimalResponse(animalById.getName(), animalById.getAge());
        animalResponse.setId(animalById.getId());
        return animalResponse;
    }

    public void delete(Long animalId) {
        dao.deleteAnimal(animalId);
    }

    public void update(Long animalId, AnimalRequest animalRequest) {
        if(animalRequest.getName()!=null){
            dao.updateAnimalByName(animalId,animalRequest.getName());
        }
        if(animalRequest.getAge()!=0){
            dao.updateAnimalByAge(animalId,animalRequest.getAge());
        }
        if(animalRequest.getHumanId()!=null){
            dao.updateAnimalByHumanId(animalId,animalRequest.getHumanId());
        }
    }

    public List<AnimalResponse> getAll() {
        List<AnimalResponse> animalResponses = new ArrayList<>();
        List<Animal> allAnimals = dao.getAllAnimals();
        allAnimals.forEach(each->{
            AnimalResponse animalResponse = new AnimalResponse(each.getId(), each.getName(), each.getAge());
            if(each.getHuman()!=null){
                animalResponse.setHumanId(each.getHuman().getId());
            }
            animalResponses.add(animalResponse);
        });
        return animalResponses;
    }

}

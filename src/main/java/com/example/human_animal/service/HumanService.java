package com.example.human_animal.service;

import com.example.human_animal.controller.responceModel.HumanResponse;
import com.example.human_animal.controller.requestModel.HumanRequest;
import com.example.human_animal.dao.DAO;
import com.example.human_animal.service.entity.Human;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanService {

    private final DAO dao;

    public HumanService(DAO dao) {
        this.dao = dao;
    }

    public void create(HumanRequest humanRequest) {
        Human human = new Human(humanRequest.getName(), humanRequest.getAge());
        dao.createHuman(human);
    }

    public HumanResponse getById(Long humanId) {
        Human humanById = dao.getHumanById(humanId);
        HumanResponse humanResponse = getHumanResponse(humanById);
        return humanResponse;
    }

    private HumanResponse getHumanResponse(Human human) {
        HumanResponse humanResponse = new HumanResponse(human.getId(), human.getName(), human.getAge());
        if (!human.getAnimals().isEmpty()) {
            human.getAnimals().forEach(each -> humanResponse.
                    getAnimalIds().
                    add(each.getId()));
        }
        return humanResponse;
    }

    public void delete(Long humanId) {
        dao.deleteHuman(humanId);
    }

    public List<HumanResponse> getAll() {
        List<Human> allHumans = dao.getAllHumans();
        List<HumanResponse> humanResponses = new ArrayList<>();
        allHumans.forEach(each->{
            HumanResponse humanResponse = getHumanResponse(each);
            humanResponses.add(humanResponse);
        });
        return humanResponses;
    }

    public void update(Long humanId, HumanRequest humanRequest) {
        if(humanRequest.getName()!=null){
            dao.updateHumanByName(humanId,humanRequest.getName());
        }
        if(humanRequest.getAge()!=0){
            dao.updateHumanByAge(humanId,humanRequest.getAge());
        }
        if(!humanRequest.getAnimalIds().isEmpty()){
           humanRequest.getAnimalIds().forEach(each->{
               dao.updateAnimalByHumanId(each,humanId);
           });
        }
    }

    public void assign(Long humanId, Long animalId) {
        dao.updateAnimalByHumanId(animalId,humanId);
    }
}

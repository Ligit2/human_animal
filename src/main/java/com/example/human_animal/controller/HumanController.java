package com.example.human_animal.controller;

import com.example.human_animal.controller.responceModel.HumanResponse;
import com.example.human_animal.controller.requestModel.HumanRequest;
import com.example.human_animal.service.HumanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HumanController {

    private final HumanService humanService;

    public HumanController( HumanService humanService) {
        this.humanService = humanService;
    }

    @PostMapping("/human")
    public void create(@RequestBody HumanRequest humanRequest) {
       humanService.create(humanRequest);
    }

    @GetMapping("/human/{humanId}")
    public HumanResponse getById(@PathVariable Long humanId){
        return humanService.getById(humanId);
    }

    @DeleteMapping("/human/{humanId}")
    public void delete(@PathVariable Long humanId){
        humanService.delete(humanId);
    }

    @PutMapping ("/human/{humanId}")
    public void update(@PathVariable Long humanId,@RequestBody HumanRequest humanRequest){
        humanService.update(humanId,humanRequest);
    }

    @GetMapping("/human")
    public List<HumanResponse> getAll(){
        return humanService.getAll();
    }

    @PutMapping("/human/assign/{humanId}/{animalId}")
    public void assignHumanToAnimal(@PathVariable Long humanId, @PathVariable Long animalId){
        humanService.assign(humanId,animalId);
    }
}

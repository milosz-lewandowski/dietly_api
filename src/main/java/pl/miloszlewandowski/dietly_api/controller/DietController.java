package pl.miloszlewandowski.dietly_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.miloszlewandowski.dietly_api.model.Diet;
import pl.miloszlewandowski.dietly_api.repository.DietRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class DietController {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    DietRepository dietRepository;

    @GetMapping("/diets")
    public Map<String, Set<Diet>> getDietList() {
        Set<Diet> diets = dietRepository.getDiets();
        Map<String, Set<Diet>> responseData= new HashMap<>();
        responseData.put("diets", diets);
        return responseData;
    }

    @GetMapping("/{id}")
    public Map<String, Diet> getDiet(@PathVariable Integer id) {
        Diet diet1 = new Diet();
        diet1.setDietId(1);
        diet1.setName("diet1");
        diet1.setDescription("dieta 1");
        dietRepository.saveDiet(diet1);
        Map<String, Diet> responseData = new HashMap<>();
        responseData.put("diet", dietRepository.getDietById(id));
        return responseData;
    }

    @PostMapping("/save")
    public void saveDiet(@RequestBody Diet diet) {
        dietRepository.saveDiet(diet);
    }

    @PutMapping("/edit")
    public void editDiet(@RequestBody Diet diet) {
        dietRepository.editDiet(diet);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDiet(@PathVariable Integer id) {
        dietRepository.deleteDiet(id);
    }

}
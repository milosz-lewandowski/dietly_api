package pl.miloszlewandowski.dietly_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.miloszlewandowski.dietly_api.model.Diet;
import pl.miloszlewandowski.dietly_api.repository.DietRepository;

import java.util.Set;

@RestController("/diets")
public class DietController {

    @Autowired
    DietRepository dietRepository;

    @GetMapping("/")
    public Set<Diet> getDietList() {
        return dietRepository.getDiets();
    }

    @GetMapping("/{id}")
    public Diet getDiet(@PathVariable Integer id) {
        return dietRepository.getDietById(id);
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
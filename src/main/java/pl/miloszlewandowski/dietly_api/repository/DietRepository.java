package pl.miloszlewandowski.dietly_api.repository;

import org.springframework.stereotype.Component;
import pl.miloszlewandowski.dietly_api.model.Diet;

import java.util.HashSet;
import java.util.Set;

@Component
public class DietRepository {

    Set<Diet> diets;

    public void setDiets(Set<Diet> diets) {
        this.diets = diets;
    }

    public Set<Diet> getDiets() {
        if (diets == null){
            diets = new HashSet<>();
        }
        return diets;
    }

    public Diet getDietById(Integer id) {
        return diets.stream().filter(
                diet -> diet.getDietId().equals(id)).findFirst().orElse(null);
    }

    public Integer deleteDiet(Integer id) {
        Diet toDeleteDiet = getDietById(id);
        diets.remove(toDeleteDiet);
        return toDeleteDiet.getDietId();
    }

    public Integer saveDiet(Diet diet) {
        diets.add(diet);
        return diet.getDietId();
    }

    public Integer editDiet(Diet newDiet){
        Diet editedDiet = updateDietObject(newDiet);
        deleteDiet(newDiet.getDietId());
        saveDiet(editedDiet);
        return newDiet.getDietId();
    }

    private Diet updateDietObject(Diet newDietData) {
        Diet editedDiet =
                getDietById(newDietData.getDietId());
        editedDiet.setName(
                newDietData.getName());
        editedDiet.setDescription(
                newDietData.getDescription());
        editedDiet.setDietOptions(
                newDietData.getDietOptions());
        return editedDiet;
    }


}

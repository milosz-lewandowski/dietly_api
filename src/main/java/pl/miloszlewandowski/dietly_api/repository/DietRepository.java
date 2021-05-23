package pl.miloszlewandowski.dietly_api.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.miloszlewandowski.dietly_api.model.Diet;
import pl.miloszlewandowski.dietly_api.model.DietCalories;
import pl.miloszlewandowski.dietly_api.model.DietOption;

import java.util.HashSet;
import java.util.Set;


@Repository
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

    public void loadData(){
        Diet diet1 = new Diet();
        diet1.setDietId(1);
        diet1.setName("diet1");
        diet1.setDescription("dieta 1");

        //  create DietOption Set
        Set<DietOption> dietOptionSet1 = new HashSet<>();

        //  create DietOption Object
        DietOption dietOption1 = new DietOption();
        dietOption1.setDietOptionId(1);
        dietOption1.setDiet(diet1);
        dietOption1.setAbbreviation("abbreviation1");

        //  create DietCalories Set
        Set<DietCalories> dietCaloriesSet1 = new HashSet<>();

        //  create DietCalories Object
        DietCalories dietCalories1 = new DietCalories();
        dietCalories1.setDietCaloriesId(1);
        dietCalories1.setCalories(1000);

        //  add object to Set
        dietOptionSet1.add(dietOption1);
        dietCaloriesSet1.add(dietCalories1);

        diet1.setDietOptions(dietOptionSet1);

        dietCalories1.setDietOption(dietOption1);
        saveDiet(diet1);
    }

//    private DietOption getDietOptionById(Integer dietId, Integer dietOptionId){
//        return getDietById(dietId).getDietOptions().stream().filter(
//                dietOption -> dietOption.getDietOptionId()
//                        .equals(dietOptionId)).findFirst().orElse(null);
//    }
//
//    private void createDietOption(Integer dietID, DietOption dietOption){
//
//    }
}

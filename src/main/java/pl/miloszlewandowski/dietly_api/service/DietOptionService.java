package pl.miloszlewandowski.dietly_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miloszlewandowski.dietly_api.model.DietOption;

import java.util.ArrayList;
import java.util.List;

@Service
public class DietOptionService implements IDietOptionService{

    @Autowired
    private IDietService dietService;

    @Override
    public List<DietOption> getDietOptions(Integer dietId) {
        List<DietOption> dietOptions = new ArrayList<>();
        DietOption dietOption1 = new DietOption();
        DietOption dietOption2 = new DietOption();
        DietOption dietOption3 = new DietOption();
        dietOptions.add(dietOption1);
        dietOptions.add(dietOption2);
        dietOptions.add(dietOption3);
        dietOptions.stream().forEach(dietOption -> dietOption
                .setDiet(dietService.getDietById(dietId)));
        for (int i = 0; i < dietOptions.size(); i++) {
            dietOptions.get(i).setDietOptionId(i);
            dietOptions.get(i).setAbbreviation("Option " + i);
            dietOptions.get(i).setName("Diet Option: " + i);
        }
        return dietOptions;
    }
}

package pl.miloszlewandowski.dietly_api.service;

import org.springframework.stereotype.Service;
import pl.miloszlewandowski.dietly_api.model.Diet;

import java.util.ArrayList;
import java.util.List;

@Service
public class DietService implements IDietService {

    @Override
    public List<Diet> getDiets() {

        List<Diet> dietList = new ArrayList<>();

        Diet diet1 = new Diet();
        diet1.setDietId(1);
        diet1.setName("a1");
        diet1.setDescription("a1");
        dietList.add(diet1);
        Diet diet2 = new Diet();
        diet2.setDietId(2);
        diet2.setName("a2");
        diet2.setDescription("a2");
        dietList.add(diet2);
        return dietList;
    }

    @Override
    public Diet getDietById(Integer dietId) {
        return getDiets().get(dietId);
    }


}

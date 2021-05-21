package pl.miloszlewandowski.dietly_api.service;

import pl.miloszlewandowski.dietly_api.model.Diet;

import java.util.List;

public interface IDietService {

    List<Diet> getDiets();
    Diet getDietById(Integer dietId);
}

package pl.miloszlewandowski.dietly_api.service;

import pl.miloszlewandowski.dietly_api.model.DietOption;

import java.util.List;

public interface IDietOptionService {

    List<DietOption> getDietOptions(Integer dietId);
}

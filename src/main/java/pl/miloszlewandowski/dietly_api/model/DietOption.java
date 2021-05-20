package pl.miloszlewandowski.dietly_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.Set;

@Data
public class DietOption { //wariant diety, np. "5 posiłków" lub "3 posiłki"
    private Integer dietOptionId;
    private String name;
    private String abbreviation;
    @JsonBackReference
    private Diet diet;
    @JsonManagedReference
    private Set<DietCalories> dietCalories;
}
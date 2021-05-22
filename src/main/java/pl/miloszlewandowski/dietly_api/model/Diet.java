package pl.miloszlewandowski.dietly_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
public class Diet { //typ diety, np. wegetariańska, sportowa
    private Integer dietId;
    private String name;
    private String description;
    @JsonManagedReference
    private Set<DietOption> dietOptions;
}

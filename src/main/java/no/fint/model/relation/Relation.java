package no.fint.model.relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relation {
    private String type;
    private String main;
    private String related;

    @JsonIgnore
    public RelationType getRelationType() {
        return new RelationType(type);
    }
}

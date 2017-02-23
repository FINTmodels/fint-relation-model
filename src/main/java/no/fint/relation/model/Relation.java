package no.fint.relation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relation {
    private String type;
    private String leftKey;
    private String rightKey;
}

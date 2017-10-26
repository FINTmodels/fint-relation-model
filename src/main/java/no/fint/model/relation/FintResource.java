package no.fint.model.relation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import no.fint.model.FintObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class FintResource implements Serializable {
    private FintObject resource;
    private List<Relation> relations = new ArrayList<>();

    public FintResource(FintObject resource) {
        this.resource = resource;
        this.relations = new ArrayList<>();
    }

    public FintResource addRelations(Relation... relation) {
        this.relations.addAll(Arrays.asList(relation));
        return this;
    }

    public FintResource addRelations(List<Relation> relations) {
        this.relations.addAll(relations);
        return this;
    }

    public static FintResource with(FintObject model) {
        return new FintResource(model);
    }

}

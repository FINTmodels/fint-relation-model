package no.fint.model.relation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class FintResource<T> implements Serializable {
    private T resource;
    private List<Relation> relations = new ArrayList<>();

    public FintResource(T resource) {
        this.resource = resource;
        this.relations = new ArrayList<>();
    }

    public FintResource<T> addRelations(Relation... relation) {
        this.relations.addAll(Arrays.asList(relation));
        return this;
    }

    public FintResource<T> addRelations(List<Relation> relations) {
        this.relations.addAll(relations);
        return this;
    }

    public static <T> FintResource<T> with(T model) {
        return new FintResource<>(model);
    }

}

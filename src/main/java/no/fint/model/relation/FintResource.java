package no.fint.model.relation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FintResource<T> {
    private T resource;
    private String type;
    private List<Relation> relations;

    public FintResource() {
        this.relations = new ArrayList<>();
    }

    public FintResource(Class<?> type, T resource) {
        this.type = type.getSimpleName().toLowerCase();
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
        return new FintResource<>(model.getClass(), model);
    }
}

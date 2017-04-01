package no.fint.model.relation;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class FintResource<T> {
    private T resource;
    private List<Relation> relasjoner;

    public FintResource() {
        this.relasjoner = new ArrayList<>();
    }

    public FintResource(T resource) {
        this.resource = resource;
        this.relasjoner = new ArrayList<>();
    }

    public FintResource<T> addRelasjon(Relation relation) {
        this.relasjoner.add(relation);
        return this;
    }

    public FintResource<T> addRelasjoner(Relation... relation) {
        this.relasjoner.addAll(Arrays.asList(relation));
        return this;
    }

    public static <T> FintResource<T> with(T model) {
        return new FintResource<>(model);
    }
}

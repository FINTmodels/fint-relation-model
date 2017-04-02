package no.fint.model.relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class FintResource<T> {
    private T resource;
    private Class<?> type;
    private String selfField;
    private List<Relation> relasjoner;

    @JsonIgnore
    private ObjectMapper objectMapper = new ObjectMapper();

    public FintResource() {
        this.relasjoner = new ArrayList<>();
    }

    public FintResource(Class<?> type, T resource) {
        this.type = type;
        this.resource = resource;
        this.relasjoner = new ArrayList<>();
    }

    public FintResource<T> selfField(String selfField) {
        this.selfField = selfField;
        return this;
    }

    public FintResource<T> addRelasjon(Relation relation) {
        this.relasjoner.add(relation);
        return this;
    }

    public FintResource<T> addRelasjoner(Relation... relation) {
        this.relasjoner.addAll(Arrays.asList(relation));
        return this;
    }

    @JsonIgnore
    @SuppressWarnings("unchecked")
    public T getConvertedResource() {
        if (resource instanceof LinkedHashMap) {
            return (T) objectMapper.convertValue(resource, type);
        } else {
            return resource;
        }
    }

    @JsonIgnore
    public String getId() {
        final Object value;
        if (resource instanceof LinkedHashMap) {
            value = objectMapper.convertValue(resource, type);
        } else {
            value = resource;
        }

        if (value instanceof Identifiable) {
            return ((Identifiable) value).getId();
        } else {
            return "";
        }
    }

    public static <T> FintResource<T> with(T model) {
        return new FintResource<>(model.getClass(), model);
    }
}

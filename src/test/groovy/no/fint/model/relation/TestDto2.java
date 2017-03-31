package no.fint.model.relation;

import lombok.Data;

import java.util.List;

@Data
public class TestDto2 implements FintModel {
    private List<Relation> relasjoner;
}

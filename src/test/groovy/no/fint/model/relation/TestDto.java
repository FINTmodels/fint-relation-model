package no.fint.model.relation;

import lombok.Data;

import java.util.List;

@Data
public class TestDto implements FintModel {
    private List<Relation> relasjoner;

    public enum Relasjonsnavn {
        TESTREL
    }
}

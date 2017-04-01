package no.fint.model.relation;

import lombok.Data;

import java.util.List;

@Data
public class TestDto implements FintModel {
    private List<Relation> relasjoner;

    public enum Relasjonsnavn {
        TESTREL
    }

    @Override
    public void addRelasjon(Relation relasjon) {
        relasjoner.add(relasjon);
    }

    @Override
    public String getId() {
        return "id";
    }

}

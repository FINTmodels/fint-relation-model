package no.fint.model.relation;

import lombok.Data;

@Data
public class TestDto implements Identifiable {
    public enum Relasjonsnavn {
        TESTREL
    }

    private String id = "id";

    @Override
    public String getId() {
        return id;
    }

}

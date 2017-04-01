package no.fint.model.relation;

import lombok.Data;

@Data
public class TestDto implements Identifiable {
    public enum Relasjonsnavn {
        TESTREL
    }

    @Override
    public String getId() {
        return "id";
    }

}

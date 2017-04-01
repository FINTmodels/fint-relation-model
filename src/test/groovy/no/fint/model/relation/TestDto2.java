package no.fint.model.relation;

import lombok.Data;

@Data
public class TestDto2 implements Identifiable {
    @Override
    public String getId() {
        return "id";
    }
}

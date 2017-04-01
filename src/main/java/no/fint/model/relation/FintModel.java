package no.fint.model.relation;

import java.util.List;

public interface FintModel {
    List<Relation> getRelasjoner();

    void addRelasjon(Relation relasjon);

    String getId();
}

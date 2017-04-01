package no.fint.model.relation;

import java.util.List;

public interface FintModel {
    List<Relation> getRelasjoner();

    void setRelasjoner(List<Relation> relasjoner);

    void addRelasjon(Relation relasjon);

    String getId();
}

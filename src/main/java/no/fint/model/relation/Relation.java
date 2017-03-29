package no.fint.model.relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relation {
    private String relationName;
    private String link;

    public static <T extends Enum<T>> Relation with(T relation) {
        Relation rel = new Relation();
        rel.setRelationName(relation.name().toLowerCase());
        return rel;
    }

    public Relation fromBase(String baseUrl) {
        this.setLink(baseUrl);
        return this;
    }

    public Relation path(String path) {
        this.setLink(this.getLink() + path);
        return this;
    }

    public Relation link(String link) {
        this.setLink(link);
        return this;
    }
}

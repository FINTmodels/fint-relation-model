package no.fint.model.relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relation {
    private String relationName;
    private String link;
    private Class type;
    private String path;

    public static <T extends Enum<T>> Relation with(T relation) {
        Relation rel = new Relation();
        rel.setRelationName(relation.name().toLowerCase());
        return rel;
    }

    public Relation forType(Class type) {
        this.setType(type);
        return this;
    }

    public Relation path(String path) {
        this.setPath(path);
        return this;
    }

    public Relation link(String link) {
        this.setLink(link);
        return this;
    }

    public String getUrl(Map<Class, String> map) {
        return map.get(this.type) + this.getPath();
    }

    public String getUrl() {
        return this.link;
    }
}

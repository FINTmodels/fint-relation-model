package no.fint.model.relation;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Relation type format urn:<namespace>:<mainClass>:<relationName>:<mainId>:<relatedId>
 */
@AllArgsConstructor
@Getter
public class RelationType {
    private String namespace;
    private String mainClass;
    private String relationName;
    private String mainId;
    private String relatedId;

    public RelationType(String relation) {
        String[] parts = relation.split(":");
        if (parts.length == 6) {
            namespace = parts[1];
            mainClass = parts[2];
            relationName = parts[3];
            mainId = parts[4];
            relatedId = parts[5];
        } else {
            throw new IllegalArgumentException(String.format("The relation is not valid: %s", relation));
        }
    }

    public String getType() {
        return String.format("urn:%s:%s:%s:%s:%s", namespace, mainClass, relationName, mainId, relatedId);
    }

    public boolean isValid() {
        return isNotEmpty(namespace, mainClass, relationName, mainId, relatedId);
    }

    private boolean isNotEmpty(String... values) {
        for (String value : values) {
            if (value == null || value.length() == 0) {
                return false;
            }
        }
        return true;
    }

    public static class Builder {
        private String namespace;
        private String mainClass;
        private String relationName;
        private String mainId;
        private String relatedId;

        public Builder namespace(String namespace) {
            this.namespace = namespace;
            return this;
        }

        public Builder mainClass(String mainClass) {
            this.mainClass = mainClass;
            return this;
        }

        public Builder relationName(String relationName) {
            this.relationName = relationName;
            return this;
        }

        public Builder mainId(String mainId) {
            this.mainId = mainId;
            return this;
        }

        public Builder relatedId(String relatedId) {
            this.relatedId = relatedId;
            return this;
        }

        public Builder main(Class<?> mainClass, String id) {
            this.mainClass = mainClass.getSimpleName().toLowerCase();
            this.mainId = String.format("%s.%s", mainClass.getSimpleName().toLowerCase(), id);
            return this;
        }

        public Builder related(Class<?> relatedClass, String id) {
            this.relatedId = String.format("%s.%s", relatedClass.getSimpleName().toLowerCase(), id);
            return this;
        }

        public RelationType build() {
            return new RelationType(namespace, mainClass, relationName, mainId, relatedId);
        }

        public String buildTypeString() {
            RelationType relationType = build();
            return relationType.getType();
        }
    }

}

# FINT Relation Model

## Installation

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven" 
    }
}

compile('no.fint:fint-relations:0.0.2')
```

## Usage

**To generate relation type:**
```java
new RelationType.Builder()
        .namespace("fint.no")
        .relationName("test")
        .main(Main.class, "systemid")
        .related(Related.class, "systemid")
        .build();
```

**Verify that the relation type is valid:**
```java
relationType.isValid();
```

**Get relation type string:**
```java
relationType.getType();
```

or

```java
new RelationType.Builder()
        .namespace("fint.no")
        .relationName("test")
        .main(Main.class, "systemid")
        .related(Related.class, "systemid")
        .buildTypeString();
```

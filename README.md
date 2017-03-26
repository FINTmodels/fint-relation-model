# FINT Relation Model

## Installation

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven" 
    }
}

compile('no.fint:fint-relation-model:0.0.3')
```

## Usage

**To generate relation type:**
```java
new RelationType.Builder()
        .namespace("fint.no")
        .relationName("personalressurs")
        .main(Arbeidsforhold.class, "systemid")
        .related(Personalressurs.class, "ansattnummer")
        .build();
```
or
```java
new RelationType.Builder()
                .namespace("fint.no")
                .mainClass("arbeidsforhold")
                .relationName("personalressurs")
                .mainId("arbeidsforhold.systemid")
                .relatedId("personalressurs.ansattnummer")
                .build();
```


**Verify that the relation type is valid:**
```java
relationType.isValid();
```
Verify that the class sent as input is in either mainClass, mainId or relationId:
```java
relationType.containsClass(Arbeidsforhold.class);
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

# FINT Relation Model

## Installation

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven" 
    }
}

compile('no.fint:fint-relation-model:0.0.13')
```

## Usage

**Create a new Relation**
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto.class).path("/test").build();
```
or
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).link("http://localhost/test").build();
```

**FintModel**
```java
@Data
public class TestDto implements FintModel {
    private List<Relation> relasjoner;

    public enum Relasjonsnavn {
        TESTREL
    }
    
    @Override
    public void addRelasjon(Relation relasjon) {
        relasjoner.add(relasjon);
    }
}
```
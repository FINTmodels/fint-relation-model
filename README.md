# FINT Relation Model

## Installation

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven" 
    }
}

compile('no.fint:fint-relation-model:0.0.17')
```

## Usage

**Create a new Relation**
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto.class).path("/test").field("test-field").value("123").build();
```
or
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto.class).path("/test").value("123").build();
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
    
    @Override
    public String getId() {
        ...
    }
}
```
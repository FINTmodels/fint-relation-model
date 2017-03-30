# FINT Relation Model

## Installation

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven" 
    }
}

compile('no.fint:fint-relation-model:0.0.11')
```

## Usage

**Create a new Relation**
```java
Relation.with(TestDto.Relasjonsnavn.TESTREL).fromBase("http://localhost").path("/test");
```
or
```java
Relation.with(TestDto.Relasjonsnavn.TESTREL).link("http://localhost/test");
```

**FintModel**
```java
@Data
public class TestDto implements FintModel {
    private List<Relation> relasjoner;

    public enum Relasjonsnavn {
        TESTREL
    }
}
```
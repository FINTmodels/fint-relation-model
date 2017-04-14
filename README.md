# FINT Relation Model

[![Build Status](https://travis-ci.org/FINTmodels/fint-relation-model.svg?branch=master)](https://travis-ci.org/FINTmodels/fint-relation-model)
[![FINT javadocs](https://img.shields.io/badge/FINT-javadocs-blue.svg)](https://javadocs.felleskomponent.no/docs/fint-relation-model/)

## Installation

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven" 
    }
}

compile('no.fint:fint-relation-model:0.0.21')
```

## Usage

**Create a new Relation**
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto.class).field("test-field").value("123").build();
```
or
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto.class).value("123").build();
```

**FintResource**
```java
FintResource.with(testDto).addRelasjoner(relation);
```
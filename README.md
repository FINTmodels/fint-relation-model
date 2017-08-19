# FINT Relation Model

[![Build Status](https://travis-ci.org/FINTmodels/fint-relation-model.svg?branch=master)](https://travis-ci.org/FINTmodels/fint-relation-model) 
[![Coverage Status](https://coveralls.io/repos/github/FINTmodels/fint-relation-model/badge.svg?branch=master)](https://coveralls.io/github/FINTmodels/fint-relation-model?branch=master) 
[![FINT javadocs](https://img.shields.io/badge/FINT-javadocs-blue.svg)](https://docs.felleskomponent.no/fint-relation-model/)

## Installation

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven" 
    }
}

compile('no.fint:fint-relation-model:1.0.2')
```

## Usage


### Relation

Create a new Relation with type, field and value
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto.class).field("test-field").value("123").build();
```
or with type and value
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto.class).value("123").build();
```
or with link
```java
new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).link("http://localhost/test").build();
```
----

### FintResource

```java
FintResource.with(testDto).addRelations(relation);
```
package no.fint.model.relation

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

class RelationSpec extends Specification {

    def "Create relation with base url, path, field and value"() {
        when:
        def relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto2).field('test-field').value('123').build()

        then:
        relation.relationName == 'testrel'
        relation.link == '${relation.testdto2}/test-field/123'
    }

    def "Create relation with base url, path and value"() {
        when:
        def relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto2).value('123').build()

        then:
        relation.relationName == 'testrel'
        relation.link == '${relation.testdto2}/123'
    }

    def "Create relation with link"() {
        when:
        def relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).link('http://localhost/test').build()

        then:
        relation.relationName == 'testrel'
        relation.link == 'http://localhost/test'
    }

    def "Throw IllegalArgumentException when link / type & path is not set"() {
        when:
        new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).build()

        then:
        thrown(IllegalArgumentException)
    }

    def "Create type with a FINT package structure"() {
        when:
        def type = Relation.createType('no.fint.model.test.TestDto')

        then:
        type == 'test.testdto'
    }

    def "Create type with a non FINT package structure"() {
        when:
        def type = Relation.createType(String.name)

        then:
        type == 'java.lang.string'
    }

    def "Serialize and deserialize Relation to JSON"() {
        given:
        def objectMapper = new ObjectMapper()
        def relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto2).value('123').build()

        when:
        def json = objectMapper.writeValueAsString(relation)
        def result = objectMapper.readValue(json, Relation)

        then:
        relation == result
    }
}

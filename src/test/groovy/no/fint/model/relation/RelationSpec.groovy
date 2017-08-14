package no.fint.model.relation

import spock.lang.Specification

class RelationSpec extends Specification {

    def "Create relation with base url, path, field and value"() {
        when:
        def relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto2).field('test-field').value('123').build()

        then:
        relation.relationName == 'testrel'
        relation.link == '${testdto2}/test-field/123'
    }

    def "Create relation with base url, path and value"() {
        when:
        def relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto2).value('123').build()

        then:
        relation.relationName == 'testrel'
        relation.link == '${testdto2}/123'
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
}

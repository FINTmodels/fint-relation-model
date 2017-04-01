package no.fint.model.relation

import spock.lang.Specification

class RelationSpec extends Specification {

    def "Create relation with base url and path"() {
        when:
        def relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto2).path('/test').build()

        then:
        relation.relationName == 'testrel'
        relation.link == '{no.fint.model.relation.TestDto2}/test'
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

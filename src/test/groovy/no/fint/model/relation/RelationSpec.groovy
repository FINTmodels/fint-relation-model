package no.fint.model.relation

import spock.lang.Specification

class RelationSpec extends Specification {

    def "Create relation with base url and path"() {
        when:
        def relation = Relation.of(TestDto.Relasjonsnavn.TESTREL).fromBase('http://localhost').path('/test')

        then:
        relation.relationName == 'testrel'
        relation.link == 'http://localhost/test'
    }

    def "Create relation with link"() {
        when:
        def relation = Relation.of(TestDto.Relasjonsnavn.TESTREL).link('http://localhost/test')

        then:
        relation.relationName == 'testrel'
        relation.link == 'http://localhost/test'
    }
}

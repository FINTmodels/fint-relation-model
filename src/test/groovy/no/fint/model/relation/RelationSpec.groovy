package no.fint.model.relation

import spock.lang.Specification

class RelationSpec extends Specification {

    def "Create relation with base url and path"() {
        when:
        def relation = Relation.with(TestDto.Relasjonsnavn.TESTREL).forType(TestDto2.class).path('/test')
        def map = new HashMap<>()
        map.put(TestDto2.class, 'http://localhost')

        then:
        def url = relation.getUrl(map)
        relation.relationName == 'testrel'
        url == 'http://localhost/test'
    }

    def "Create relation with link"() {
        when:
        def relation = Relation.with(TestDto.Relasjonsnavn.TESTREL).link('http://localhost/test')

        then:
        relation.relationName == 'testrel'
        relation.getUrl() == 'http://localhost/test'
    }
}

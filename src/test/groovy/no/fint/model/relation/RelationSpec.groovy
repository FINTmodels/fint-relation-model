package no.fint.model.relation

import spock.lang.Specification

class RelationSpec extends Specification {

    def "Create RelationType from Relation"() {
        given:
        def relation = new Relation(type: 'urn:fint.no:arbeidsforhold:personalressurs:arbeidsforhold.systemid:personalressurs.ansattnummer')

        when:
        def relationType = relation.getRelationType()

        then:
        relationType.isValid()
    }
}

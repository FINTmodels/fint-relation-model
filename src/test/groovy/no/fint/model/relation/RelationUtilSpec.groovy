package no.fint.model.relation

import spock.lang.Specification

class RelationUtilSpec extends Specification {

    def "Get relation types for class"() {
        when:
        def types = RelationUtil.getRelationTypes(TestDto)

        then:
        types.size() == 1
        types[0] == 'test-relation-type1'
    }
}

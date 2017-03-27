package no.fint.model.relation

import spock.lang.Specification

class RelationUtilSpec extends Specification {

    def "Get relation types for class"() {
        when:
        def types = RelationUtil.getRelationTypes(TestDto)

        then:
        types.size() == 3
        types[0] == 'test-relation-type1'
        types[1] == 'test-relation-type2'
    }

    def "Get constant value"() {
        when:
        def value = RelationUtil.getConstantValue(TestDto, 'TEST2')

        then:
        value.isPresent()
        value.get() == 'test-relation-type2'
    }
}

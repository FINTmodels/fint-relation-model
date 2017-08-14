package no.fint.model.relation

import spock.lang.Specification

class FintResourceSpec extends Specification {
    private Relation relation
    private TestDto testDto

    void setup() {
        relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).link('http://localhost/test').build()
        testDto = new TestDto()
    }

    def "Create new FintResource with single relation"() {
        when:
        def fintResource = FintResource.with(testDto).addRelations(relation)

        then:
        fintResource.type == 'testdto'
        fintResource.resource == testDto
        fintResource.relations.size() == 1
        fintResource.relations[0] == relation
    }

    def "Create new FintResource with relation list"() {
        when:
        def fintResource = FintResource.with(testDto).addRelations([relation, relation])

        then:
        fintResource.type == 'testdto'
        fintResource.resource == testDto
        fintResource.relations.size() == 2
        fintResource.relations[0] == relation
        fintResource.relations[1] == relation
    }
}

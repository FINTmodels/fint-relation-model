package no.fint.model.relation

import com.fasterxml.jackson.databind.ObjectMapper
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
        fintResource.type == 'relation.testdto'
        fintResource.resource == testDto
        fintResource.relations.size() == 1
        fintResource.relations[0] == relation
    }

    def "Create new FintResource with relation list"() {
        when:
        def fintResource = FintResource.with(testDto).addRelations([relation, relation])

        then:
        fintResource.type == 'relation.testdto'
        fintResource.resource == testDto
        fintResource.relations.size() == 2
        fintResource.relations[0] == relation
        fintResource.relations[1] == relation
    }

    def "Create new FintResource with a non FINT package structure"() {
        when:
        def resource = FintResource.with('test')

        then:
        resource.type == 'java.lang.string'
    }

    def "Serialize and deserialize FintResource to JSON"() {
        given:
        def objectMapper = new ObjectMapper()
        def fintResource = FintResource.with('test')

        when:
        def json = objectMapper.writeValueAsString(fintResource)
        def result = objectMapper.readValue(json, FintResource)

        then:
        fintResource == result
    }
}

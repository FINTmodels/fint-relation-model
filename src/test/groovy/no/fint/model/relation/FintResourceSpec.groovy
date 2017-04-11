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

    def "Create new FintResource"() {
        when:
        def fintResource = FintResource.with(testDto).addRelasjoner(relation)

        then:
        fintResource.resource == testDto
        fintResource.relasjoner.size() == 1
        fintResource.relasjoner[0] == relation
    }

    def "Get converted resource, TestDto resource type"() {
        given:
        def fintResource = FintResource.with(testDto).addRelasjoner(relation)

        when:
        def resource = fintResource.getConvertedResource()

        then:
        resource.id == 'id'
    }

    def "Get converted resource, LinkedHashMap resource type"() {
        given:
        def json = new ObjectMapper().writeValueAsString(new TestDto())
        def map = new ObjectMapper().readValue(json, LinkedHashMap)
        def fintResource = new FintResource(resource: map, type: TestDto)

        when:
        def resource = fintResource.getConvertedResource()

        then:
        resource.id == 'id'
    }

    def "Get id, TestDto resource type"() {
        given:
        def fintResource = FintResource.with(testDto).addRelasjoner(relation)

        when:
        def id = fintResource.getId()

        then:
        id.isPresent()
        id.get() == 'id'
    }

    def "Get id, LinkedHashMap resource type"() {
        given:
        def json = new ObjectMapper().writeValueAsString(new TestDto())
        def map = new ObjectMapper().readValue(json, LinkedHashMap)
        def fintResource = new FintResource(resource: map, type: TestDto)

        when:
        def id = fintResource.getId()

        then:
        id.isPresent()
        id.get() == 'id'
    }

    def "Get id, value is not of Identifiable"() {
        given:
        def fintResource = new FintResource(resource: '', type: TestDto)

        when:
        def id = fintResource.getId()

        then:
        !id.isPresent()
    }
}

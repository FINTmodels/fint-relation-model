package no.fint.model.relation

import spock.lang.Specification

class FintResourceSpec extends Specification {
    def "Create new FintResource"() {
        when:
        def relation = new Relation.Builder().with(TestDto.Relasjonsnavn.TESTREL).link('http://localhost/test').build()
        def testDto = new TestDto()
        def fintResource = FintResource.with(testDto).addRelasjoner(relation)

        then:
        fintResource.resource == testDto
        fintResource.relasjoner.size() == 1
        fintResource.relasjoner[0] == relation
    }
}

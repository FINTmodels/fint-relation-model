package no.fint.model.relation

import spock.lang.Specification

class RelationTypeSpec extends Specification {
    private String relation = 'urn:fint.no:arbeidsforhold:personalressurs:arbeidsforhold.systemid:personalressurs.ansattnummer'

    def "Create relation type from relation string"() {
        when:
        def relationType = new RelationType(relation)

        then:
        relationType.isValid()
        relationType.namespace == 'fint.no'
        relationType.mainClass == 'arbeidsforhold'
        relationType.relationName == 'personalressurs'
        relationType.mainId == 'arbeidsforhold.systemid'
        relationType.relatedId == 'personalressurs.ansattnummer'
    }

    def "Create relation type using builder"() {
        when:
        def type = new RelationType.Builder()
                .namespace('fint.no')
                .mainClass('arbeidsforhold')
                .relationName('personalressurs')
                .mainId('arbeidsforhold.systemid')
                .relatedId('personalressurs.ansattnummer')
                .buildTypeString()

        then:
        type == relation
    }

    def "Create relation type using builder and resource classes"() {
        when:
        def relationType = new RelationType.Builder()
                .namespace('fint.no')
                .relationName('test')
                .main(Relation, 'systemid')
                .related(String, 'systemid')
                .build()

        then:
        relationType.isValid()
        relationType.containsClass(Relation, String)
        relationType.namespace == 'fint.no'
        relationType.mainClass == 'relation'
        relationType.relationName == 'test'
        relationType.mainId == 'relation.systemid'
        relationType.relatedId == 'string.systemid'
    }

    def "Throw IllegalArgumentException when input relation string is not a valid format"() {
        given:
        def relation = 'test'

        when:
        new RelationType(relation)

        then:
        thrown(IllegalArgumentException)
    }

    def "Not valid relation type if null value"() {
        when:
        def relationType = new RelationType.Builder().build()

        then:
        !relationType.isValid()
    }

}

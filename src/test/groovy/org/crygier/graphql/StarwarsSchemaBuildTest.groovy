package org.crygier.graphql

import graphql.schema.GraphQLSchema
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.persistence.EntityManager

@Configuration
@ContextConfiguration(loader = SpringApplicationContextLoader, classes = TestApplication)
class StarwarsSchemaBuildTest extends Specification {

    @Autowired
    private EntityManager entityManager;

    private GraphQLSchemaBuilder builder;

    void setup() {
        builder = new GraphQLSchemaBuilder(entityManager);
    }

    def 'Correctly derives the schema from Given Entities'() {
        when:
        GraphQLSchema schema = builder.getGraphQLSchema();

        then:
        schema;
    }

}
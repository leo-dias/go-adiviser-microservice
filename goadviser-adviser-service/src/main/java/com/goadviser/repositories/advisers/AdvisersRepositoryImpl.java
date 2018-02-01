package com.goadviser.repositories.advisers;

import com.goadviser.models.Adviser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class AdvisersRepositoryImpl implements AdvisersRepositoryQuery {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Adviser> find(final String filter) {
        final Criteria criteriaDefinition = new Criteria();

        criteriaDefinition.orOperator(
                Criteria.where("name").regex(filter, "i"),
                Criteria.where("email").regex(filter, "i")
        );

        final Query query = Query.query(criteriaDefinition);
//        query.skip(offset);
//        query.limit(size);
        query.fields().exclude("financials");
        query.fields().exclude("created_at");

        query.with(new Sort(Sort.Direction.ASC, "name"));
        return mongoTemplate.find(query, Adviser.class);
    }

}

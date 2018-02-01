package com.goadviser.repositories;

import com.goadviser.models.Adviser;
import com.goadviser.repositories.advisers.AdvisersRepositoryQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "advisers2")
public interface AdvisersRepository extends MongoRepository<Adviser, String>, AdvisersRepositoryQuery {

    @RestResource(path = "by-email")
    List<Adviser> findByEmail(@Param("email") String email);
}

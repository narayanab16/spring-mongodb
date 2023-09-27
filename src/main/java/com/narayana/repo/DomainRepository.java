package com.narayana.repo;

import com.narayana.model.Domain;
import com.narayana.model.Result;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.List;

public interface DomainRepository extends MongoRepository<Domain, Serializable> {

    @Aggregation(pipeline = {
            "{'$match':{'domainName':'www.narayana.com'}}"
    })
    List<Domain> findNarayanaDomain(); // Allowed
    @Aggregation(pipeline = {
            "{'$match':{'domainName':?0}}"
    })
    List<Domain> findByDomain(String domainName);

    @Aggregation(pipeline = {
            "{$group:{_id:$domainName, total:{$sum:1}}}",
            "{$sort: {total: -1}}",
            "{$project:{domainResult:'$_id',total:'$total'}}"

    })
    List<Result> findAllAggByDomain();


}

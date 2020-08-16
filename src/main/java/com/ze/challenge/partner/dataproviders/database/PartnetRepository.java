package com.ze.challenge.partner.dataproviders.database;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.usercase.create.Create;
import com.ze.challenge.partner.core.usercase.find.Find;
import com.ze.challenge.partner.core.usercase.search.Search;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
@AllArgsConstructor
public class PartnetRepository implements Find, Create, Search {

    private MongoTemplate mongoTemplate;

    @Override
    public Partner create(Partner partner) {
        return mongoTemplate.insert(partner);
    }

    @Override
    public Partner find(String id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return (Partner) mongoTemplate.findOne(query, Partner.class);
    }

    @Override
    public List<Partner> search(Double latitude, Double longitude) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("latitude").is(latitude).and("longitude").is(longitude));
        return (List<Partner>) mongoTemplate.find(query, Partner.class);
    }
}

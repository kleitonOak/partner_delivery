package com.ze.challenge.partner.dataproviders.database;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.usercase.create.Create;
import com.ze.challenge.partner.core.usercase.find.Find;
import com.ze.challenge.partner.core.usercase.search.Search;
import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class PartnetRepository implements Find, Create, Search {

    private MongoTemplate mongoTemplate;
    public PartnetRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
        checkIndexes();
    }

    @Override
    public Partner create(Partner partner){
        return mongoTemplate.insert(partner);
    }

    @Override
    public Partner find(String id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return (Partner) mongoTemplate.findOne(query, Partner.class);
    }

    @Override
    public Partner findByDocument(String document){
        final Query query = new Query();
        query.addCriteria(Criteria.where("document").is(document));
        return (Partner) mongoTemplate.findOne(query, Partner.class);
    }

    @Override
    public List<Partner> search(Double latitude, Double longitude, Integer limit) {
        final Query query = new Query();
        //10 KM MAX DISTANCE
        query.addCriteria(Criteria.where("coverageArea").nearSphere(new Point(longitude, latitude)).maxDistance(10000)).limit(limit);
        return mongoTemplate.find(query, Partner.class);
    }

    private void checkIndexes(){
        GeospatialIndex geospatialIndexCoverageArea = new GeospatialIndex("coverageArea");
        geospatialIndexCoverageArea.typed(GeoSpatialIndexType.GEO_2DSPHERE);
        GeospatialIndex geospatialIndexAddress = new GeospatialIndex("address");
        geospatialIndexAddress.typed(GeoSpatialIndexType.GEO_2DSPHERE);

        TextIndexDefinition documentIndexDefinition = TextIndexDefinition.builder().onField("document").build();

        mongoTemplate.indexOps(Partner.class).ensureIndex(geospatialIndexCoverageArea);
        mongoTemplate.indexOps(Partner.class).ensureIndex(geospatialIndexAddress);
        mongoTemplate.indexOps(Partner.class).ensureIndex(documentIndexDefinition);
    }
}

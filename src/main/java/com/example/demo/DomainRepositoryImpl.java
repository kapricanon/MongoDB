package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteConcernResult;
import com.mongodb.WriteResult;

//Impl postfix of the name on it compared to the core repository interface
public class DomainRepositoryImpl implements DomainRepositoryCustom {

  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public int updateDomain(String domain, boolean displayAds) {

      Query query = new Query(Criteria.where("domain").is(domain));
      Update update = new Update();
      update.set("displayAds", displayAds);

      /*Domain testDomain = new Domain();
      testDomain.setDomain("test1");
      testDomain.setId(1);
      mongoTemplate.insert(testDomain);
      DBCollection collection = mongoTemplate.getCollection("domain");
      DBCursor cur = collection.find();
      for(DBObject c : cur) {
    	  System.out.println(c);
      }*/
    
      WriteResult result = mongoTemplate.updateFirst(query, update, Domain.class);

      if(result!=null)
          return result.getN();
      else
          return 0;

  }
}

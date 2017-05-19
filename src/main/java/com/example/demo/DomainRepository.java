package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DomainRepository extends MongoRepository<Domain, Long>, DomainRepositoryCustom {

	Domain findFirstByDomain(String domain);

	Domain findByDomainAndDisplayAds(String domain, boolean displayAds);

	// Supports native JSON query string
	@Query("{domain:'?0'}")
	Domain findCustomByDomain(String domain);
	
	// Supports native JSON query string
	@Query("{_id:?0}")
	Domain findCustomById(int domain);

	@Query("{domain: { $regex: ?0 } })")
	List<Domain> findCustomByRegExDomain(String domain);

}

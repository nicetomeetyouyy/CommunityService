package com.fy.ogm;

import com.fy.entity.House;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HouseRepository extends Neo4jRepository<House,Long> {
}

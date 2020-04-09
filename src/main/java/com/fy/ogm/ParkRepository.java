package com.fy.ogm;

import com.fy.entity.Park;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkRepository extends Neo4jRepository<Park,Long> {
    List<Park> findParkByLocationContaining(String location);

    @Query("match (p:park) where id(p)={0} set p.location={1}," +
            "p.state={2},p.sale_time={3},p.expired_time={4} return p")
    Park updatePark(Long id,String location,String state,String sale_time,String expired_time);
}

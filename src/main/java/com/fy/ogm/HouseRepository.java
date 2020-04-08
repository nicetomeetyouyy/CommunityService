package com.fy.ogm;

import com.fy.entity.House;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends Neo4jRepository<House,Long> {
    @Query("MATCH (h:house) where id(h)={0} set h.address={1},h.area={2},h.type={3}," +
            "h.register_time={4} return h")
    House updateHouse( Long id, String address, String area, String type, String register_time);
    List<House> findByAddressContaining(String address);


}

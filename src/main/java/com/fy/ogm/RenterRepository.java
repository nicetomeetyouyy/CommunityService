package com.fy.ogm;

import com.fy.entity.Renter;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface RenterRepository extends Neo4jRepository<Renter,Long> {
    @Query("MATCH (o:renter) where id(o)={0} set o.name={1},o.sex={2},o.age={3}," +
            "o.tel={4},o.identity={5},o.user_id={6},o.check_in={7}" +
            "return o")
    Renter updateRenter(Long id, String name, String sex, String age, String tel, String identity, String user_id, String check_in);
    List<Renter> findByNameContaining(String name);
    @Query("MATCH(o:renter{user_id:{0}}) return o")
    Renter findByUser_id(String user_id);

    @Query("Match(r:renter) where id(r)={0} match(h:house) where id(h)={1} create(r)-[:isRenter]->(h)")
    void relatedHouse(Long renter_id,Long house_id);

}

package com.fy.ogm;

import com.fy.entity.House;
import com.fy.entity.Owner;
import com.fy.entity.Park;
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

    /**
     * 将房子和租户关联
     * @param renter_id
     * @param house_id
     */
    @Query("Match(r:renter) where id(r)={0} match(h:house) where id(h)={1} create(r)-[:isRenter]->(h)")
    void relatedHouse(Long renter_id,Long house_id);

    /**
     * 查看租户租住的房子信息
     * @param renter_id
     * @return
     */
     @Query("Match(r:renter) where id(r)={0} match(r)-[:isRenter]->(h:house) return h")
    List<House> findHouse(Long renter_id);

    /**
     * 查看租户的业主信息
     * @param renter_id
     * @return
     */
     @Query("Match(r:renter) where id(r)={0} match(r)<-[:isLandlord]-(o:owner) return o")
    List<Owner> findOwner(Long renter_id);
    /**
     * 将租户与停车位关联
     * @param
     * @param park_id
     */
    @Query("Match(r:renter) where id(r)={0} match(p:park) where id(p)={1} create(r)-[:isRenter]->(p)")
    void relatedPark(Long renter_id,Long park_id);

    /**
     * 查看租户租的车位
     */
    @Query("MATCH (r:renter) where id(r)={0} Match (r)-[:isRenter]-(p:park) return p")
    List<Park> findPark(Long renter_id);

}

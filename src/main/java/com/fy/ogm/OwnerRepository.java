package com.fy.ogm;

import com.fy.entity.House;
import com.fy.entity.Owner;
import com.fy.entity.Park;
import com.fy.entity.Renter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OwnerRepository extends Neo4jRepository<Owner,Long> {
    @Query("MATCH (o:owner) where id(o)={0} set o.name={1},o.sex={2},o.age={3}," +
            "o.tel={4},o.identity={5},o.user_id={6}" +
            "return o")
    Owner updateOwner( Long id, String name, String sex, String age, String tel, String identity, String user_id);
    List<Owner> findByNameContaining(String name);
    @Query("MATCH(o:owner{user_id:{0}}) return o")
    Owner findByUser_id(String user_id);

    /**
     * 将业主和租户关联
     * @param owner_id
     * @param renter_id
     */
    @Query("Match(o:owner) where id(o)={0} match(r:renter) where id(r)={1} create(o)-[:isLandlord]->(r)")
    void relatedRenter(Long owner_id,Long renter_id);

    /**
     * 将业主和房产关联
     * @param owner_id
     * @param house_id
     */
    @Query("Match(o:owner) where id(o)={0} match(h:house) where id(h)={1} create(o)-[:isOwner]->(h)")
    void relatedHouse(Long owner_id,Long house_id);

    /**
     * 将业主与停车位关联
     * @param owner_id
     * @param park_id
     */
    @Query("Match(o:owner) where id(o)={0} match(p:park) where id(p)={1} create(o)-[:isOwner]->(p)")
    void relatedPark(Long owner_id,Long park_id);
    /**
     * 查看业主下的租户
     * @param
     * @return
     */
    @Query("MATCH (o:owner) where id(o)={0}  match (o)-[:isLandlord]->(r:renter) return r")
    List<Renter> findRenter(Long owner_id);

    /**
     * 查看业主租出去的房子
     * @param owner_id
     * @return
     */
    @Query("MATCH (o:owner) where id(o)={0} Match (o)-[:isOwner]-(h:house)<-[:isRenter]-(:renter) return h")
    List<House> findRenterHouse(Long owner_id);
    /**
     * 查看业主拥有的房子
     */
    @Query("MATCH (o:owner) where id(o)={0} Match (o)-[:isOwner]-(h:house) return h")
    List<House> findHouse(Long owner_id);

    /**
     * 查看业主粗出去的车位
     * @param owner_id
     * @return
     */
    @Query("MATCH (o:owner) where id(o)={0} Match (o)-[:isOwner]-(p:park)<-[:isRenter]-(:renter) return p")
    List<Park> findRenterPark(Long owner_id);
    /**
     * 查看业主拥有的车位
     */
    @Query("MATCH (o:owner) where id(o)={0} Match (o)-[:isOwner]-(p:park) return p")
    List<Park> findPark(Long owner_id);


}



package com.fy.ogm;

import com.fy.entity.Owner;
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
}

;
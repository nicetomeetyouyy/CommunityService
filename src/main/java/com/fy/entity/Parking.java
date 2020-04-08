package com.fy.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "parking")
public class Parking {
    @Id@GeneratedValue
    private Long id;

}

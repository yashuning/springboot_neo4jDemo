package com.nys.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.demo.entity
 * @Description: TODO
 * @date 2018/7/20 下午12:05
 */
@RelationshipEntity(type = "评分")
public class Rating implements Serializable{
    private static final long serialVersionUID = -8119714341396631090L;
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    @JsonBackReference
    private Person person;
    @EndNode
    @JsonBackReference
    private Movie movie;
    @Property
    private int stars;
    @Property
    private String comment;
    /*
    @DateLong
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create;
    */


    public Rating(){}


    public Rating(Person person,Movie movie,int stars,String comment){
        this.person = person;
        this.movie = movie;
        this.stars = stars;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

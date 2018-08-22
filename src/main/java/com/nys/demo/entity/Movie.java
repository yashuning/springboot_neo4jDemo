package com.nys.demo.entity;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.demo.entity
 * @Description: TODO
 * @date 2018/7/20 下午12:01
 */
@NodeEntity
public class Movie  {
    @Id
    @GeneratedValue
    private Long id;
    @Property(name="name")
    private String name;
    @Relationship(type = "评分",direction = Relationship.INCOMING)
    private List<Rating> ratings = new ArrayList<>();

    public Movie(){}

    public Movie(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}

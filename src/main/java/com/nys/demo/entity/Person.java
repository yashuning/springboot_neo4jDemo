package com.nys.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.Properties;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;

/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.demo.entity
 * @Description: TODO
 * @date 2018/7/19 下午8:46
 */
@NodeEntity
public class Person implements Serializable{

    private static final long serialVersionUID = 3368078870166842751L;
    @Id
    @GeneratedValue
    private Long id;

    @Property(name="name")
    private String name;
    @Property(name="sex")
    private int sex;
    //@DateLong
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create;


    //关系
    @Relationship(type="朋友",direction = Relationship.OUTGOING)
    @JsonIgnore
    private List<Person> friends = new ArrayList<>();

    @Relationship(type = "评分")
    private List<Rating> ratings = new ArrayList<>();

    @Relationship(type = "观看",direction = Relationship.OUTGOING)
    private List<Show> visiters = new ArrayList<>();

    //建立朋友关系
    public void beFriend(Person person){
        friends.add(person);
    }

    public void addVistiter(Show show){
        visiters.add(show);
    }

    public Rating rate(Movie movie,int stars,String comment){
        Rating rating = new Rating(this,movie,stars,comment);
        ratings.add(rating);
        return rating;
    }


    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }


    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Show> getVisiters() {
        return visiters;
    }

    public void setVisiters(List<Show> visiters) {
        this.visiters = visiters;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}

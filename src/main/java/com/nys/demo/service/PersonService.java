package com.nys.demo.service;

import com.nys.demo.entity.Movie;
import com.nys.demo.entity.Person;
import com.nys.demo.entity.Rating;
import com.nys.demo.respository.MovieRespository;
import com.nys.demo.respository.PersonRespository;
import com.nys.demo.respository.RatingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.demo.service
 * @Description: TODO
 * @date 2018/7/20 下午2:55
 */
@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRespository personRespository;

    @Autowired
    private MovieRespository movieRespository;

    @Autowired
    private RatingRespository ratingRespository;


    @Transactional
    public void initData(){
        /**
         * 初始化观众
         */
        Person p1 = new Person("孙悟空");
        Person p2 = new Person("猪八戒");
        Person p3 = new Person("沙僧");
        Person p4 = new Person("唐僧");

        p1.beFriend(p2);
        p1.beFriend(p3);
        p3.beFriend(p4);

        /**
         * 初始化电影
         */
        Movie m1 = new Movie("泰囧");
        Movie m2 = new Movie("唐人街探案");
        Movie m3 = new Movie("三生三世十里桃花");

        /**
         * 初始化关系
         */
        Rating r1 = new Rating(p1,m1,4,"还行");
        Rating r2 = new Rating(p1,m2,5,"很好看，搞笑");
        Rating r3 = new Rating(p2,m2,5,"很搞笑，推力很好");
        Rating r4 = new Rating(p3,m3,2,"不好看，尴尬");
        Rating r5 = new Rating(p3,m1,4,"很逗呀");
        Rating r6 = new Rating(p4,m3,4,"哎呀不喜欢");

        Iterable<Person> personIterable = Arrays.asList(p1,p2,p3,p4);
        personRespository.saveAll(personIterable);
        Iterable<Movie> movieIterable = Arrays.asList(m1,m2,m3);
        movieRespository.saveAll(movieIterable);
        Iterable<Rating> ratingIterable = Arrays.asList(r1,r2,r3,r4,r5,r6);
        ratingRespository.saveAll(ratingIterable);
    }

    @Transactional
    public Person getPersonByName(String name){
        return personRespository.findByName(name);

    }

    @Transactional
    public List<Person> getPersonAll(){
        return (List<Person>) personRespository.findAll();

    }

}

package com.nys.demo.test;

import com.nys.demo.SpringbootSdnRemoteApplication;
import com.nys.demo.entity.Movie;
import com.nys.demo.entity.Person;
import com.nys.demo.respository.MovieRespository;
import com.nys.demo.service.MovieService;
import com.nys.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.test.neo4jTest
 * @Description: TODO
 * @date 2018/7/19 下午8:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootSdnRemoteApplication.class)
public class Neo4jTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private MovieService movieService;

    @Test
    public void initData(){
        personService.initData();
        //List<Person> ps = personService.getPersonAll();
        Movie m = movieService.getMoviesByName("泰囧");
        //Person p = personService.getPersonByName("孙悟空");

        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("========================================================");
        //System.out.println(Arrays.asList(ps));
        System.out.println(m);
        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("========================================================");
    }

}

package com.nys.demo.respository;

import com.nys.demo.entity.Movie;
import com.nys.demo.entity.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.demo.respository
 * @Description: TODO
 * @date 2018/7/23 上午10:48
 */
@Repository
public interface MovieRespository extends Neo4jRepository<Movie,Long> {

    /**
     * 查询电影
     */
    @Query("MATCH (m:Movie{name:{name}}) RETURN m")
    Movie getMoviesByName(@Param("name") String name);
}

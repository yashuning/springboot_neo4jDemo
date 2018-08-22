package com.nys.demo.respository;

import com.nys.demo.entity.Person;
import com.nys.demo.entity.Rating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
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
public interface RatingRespository extends Neo4jRepository<Rating,Long> {
}

package com.nys.demo.service;

import com.nys.demo.entity.Movie;
import com.nys.demo.respository.MovieRespository;
import com.nys.demo.respository.PersonRespository;
import com.nys.demo.respository.RatingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.demo.service
 * @Description: TODO
 * @date 2018/7/23 下午6:49
 */
@Service
@Transactional
public class MovieService {
    @Autowired
    private PersonRespository personRespository;

    @Autowired
    private MovieRespository movieRespository;

    @Autowired
    private RatingRespository ratingRespository;

    @Transactional
    public Movie getMoviesByName(String name){
        return movieRespository.getMoviesByName(name);
    }
}

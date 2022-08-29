package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * @author  Julian Schäfer - schaefer@synyx.de
 * @since  29.08.22
 */

public interface FooJDBCRepository extends CrudRepository<FooEntity, Long> {

    @Override
    List<FooEntity> findAll();


    List<FooEntity> findDistinctBy();


    long countDistinctBy();
}

package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author  Julian Schäfer - schaefer@synyx.de
 * @since  29.08.22
 */
@Repository
public class FooRepositoryImpl {

    private final FooJDBCRepository jdbcRepository;

    public FooRepositoryImpl(FooJDBCRepository jdbcRepository) {

        this.jdbcRepository = jdbcRepository;
    }

    public List<FooEntity> findAll() {

        return jdbcRepository.findAll();
    }
}

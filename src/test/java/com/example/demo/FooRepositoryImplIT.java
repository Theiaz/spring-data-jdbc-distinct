package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author  Julian Schäfer - schaefer@synyx.de
 * @since  29.08.22
 */
@DataJdbcTest
class FooRepositoryImplIT {

    @Autowired
    FooJDBCRepository jdbcRepository;

    FooRepositoryImpl sut;

    @BeforeEach
    public void setup() {

        sut = new FooRepositoryImpl(jdbcRepository);
    }


    @Test
    void distinctNotWorking() {

        var foo1 = new FooEntity(null, "bar");
        var foo2 = new FooEntity(null, "bar");

        jdbcRepository.save(foo1);
        jdbcRepository.save(foo2);

//      DEBUG 680681 --- [           main] o.s.jdbc.core.JdbcTemplate               : Executing prepared SQL statement [SELECT "FOO"."BAR" AS "BAR", "FOO"."PERSISTENCE_ID" AS "PERSISTENCE_ID" FROM "FOO"]
        var results = jdbcRepository.findDistinctBy();
        assertThat(results).hasSize(1);

//       DEBUG 680681 --- [           main] o.s.jdbc.core.JdbcTemplate              : Executing prepared SQL statement [SELECT COUNT(*) FROM "FOO"]
//        var results = jdbcRepository.countDistinctBy();
//        assertThat(results).isEqualTo(2);
    }
}

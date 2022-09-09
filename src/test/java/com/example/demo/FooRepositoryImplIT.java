package com.example.demo;

import com.example.demo.FooEntity.NameEntity;

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

        var firstname = "Max";
        var name = new NameEntity(firstname, "Mueller");
        var foo1 = new FooEntity(null, name);

        var name2 = new NameEntity(firstname, "Mustermann");
        var foo2 = new FooEntity(null, name2);

        jdbcRepository.save(foo1);
        jdbcRepository.save(foo2);

        var workingResult = jdbcRepository.workingCountDistinctByFirstname(firstname);
        assertThat(workingResult).isEqualTo(1);

        var failingResult = jdbcRepository.countDistinctByName_Firstname(firstname);
        assertThat(failingResult).isEqualTo(1);
    }
}

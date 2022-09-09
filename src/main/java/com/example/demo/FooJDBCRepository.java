package com.example.demo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * @author  Julian Schäfer - schaefer@synyx.de
 * @since  29.08.22
 */

public interface FooJDBCRepository extends CrudRepository<FooEntity, Long> {

    @Override
    List<FooEntity> findAll();


    /* This may be not a valid for Spring Data JDBC, because each aggregate is not distinct by its ID */
    List<FooEntity> findDistinctByName_Firstname(String firstname);


    long countDistinctByName_Firstname(String firstname);


    @Query(value = "SELECT COUNT(DISTINCT NAME_FIRSTNAME) FROM FOO WHERE NAME_FIRSTNAME=:firstname")
    long workingCountDistinctByFirstname(String firstname);
}

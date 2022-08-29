package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


/**
 * @author  Julian Schäfer - schaefer@synyx.de
 * @since  29.08.22
 */

@Table("FOO")
public class FooEntity {

    @Id
    final Long persistenceId;
    final String bar;

    public FooEntity(Long persistenceId, String bar) {

        this.persistenceId = persistenceId;

        this.bar = bar;
    }
}

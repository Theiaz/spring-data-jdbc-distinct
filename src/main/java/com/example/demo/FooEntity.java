package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;


/**
 * @author  Julian Schäfer - schaefer@synyx.de
 * @since  29.08.22
 */

@Table("FOO")
public class FooEntity {

    @Id
    final Long persistenceId;
    @Embedded.Nullable(prefix = "NAME_")
    final NameEntity name;

    public FooEntity(Long persistenceId, NameEntity name) {

        this.persistenceId = persistenceId;
        this.name = name;
    }

    public static class NameEntity {

        private final String firstname;
        private final String surname;

        public NameEntity(String firstname, String surname) {

            this.firstname = firstname;
            this.surname = surname;
        }
    }
}

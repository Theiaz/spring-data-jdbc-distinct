# What

Example project to demonstrate that `DISTINCT` is not working for Spring Data JDBC. 

[Spring docs](https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/#appendix.query.method.subject) does say that `DISTINCT` is supported.

# How

Run `FooRepositoryImplIT.distinctNotWorking()` test and have a look at the log output. No query with `DISTINCT` has been generated.


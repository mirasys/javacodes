package com.mirasysgroup.javacodes.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public abstract class AbstractDao {
    protected JdbcTemplate jdbcTemplate;
    protected static final String SINGLE_RESULT = "single";
    protected static final String MULTIPLE_RESULT = "list";
    protected static final String RESULT_COUNT = "count";
    protected static SimpleJdbcCall createJdbcCall;
    protected static SimpleJdbcCall updateJdbcCall;
    protected static SimpleJdbcCall findById;
    protected  static SimpleJdbcCall deleteById;
}

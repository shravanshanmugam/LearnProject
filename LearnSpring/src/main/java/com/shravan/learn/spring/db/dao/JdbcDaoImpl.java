package com.shravan.learn.spring.db.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoImpl extends JdbcDaoSupport {

    public int getCircleCount() {
        String sql = "select count(*) from Circle;";
        return this.getJdbcTemplate().queryForObject(sql, Integer.class);
    }
}

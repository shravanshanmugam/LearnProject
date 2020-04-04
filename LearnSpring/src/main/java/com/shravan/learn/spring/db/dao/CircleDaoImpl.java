package com.shravan.learn.spring.db.dao;

import com.shravan.learn.spring.db.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class CircleDaoImpl {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Circle getCircle(int id) {
        Circle circle = null;
        try {
            /**
             * <code>Class.forName("com.mysql.jdbc.Driver");
             * Connection con= DriverManager.getConnection(
             *       "jdbc:mysql://localhost:3306/LearnSpring","webaroo","webar00");</code>
             * Replaced by following code
             */
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from Circle where id = ? ;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                circle = new Circle(id, name);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return circle;
        }
    }

    /**
     * DDL (Data Definition Language) Statements like CREATE, ALTER, DROP
     */
    public void createCircleTable() {
        String sql = "drop table if exists Circle;";
        jdbcTemplate.execute(sql);
        String sql2 = "create table Circle(id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, name text);";
        jdbcTemplate.execute(sql2);
    }

    /**
     * DML (Data Manipulation Language) Statements like SELECT, INSERT, UPDATE
     */
    public int getCircleCount() {
        String sql = "select count(*) from Circle;";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public String getCircleName(int id) {
        String sql = "select name from Circle where id = ?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }

    public Circle getCircleById(int id) {
        String sql = "select  * from Circle where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
    }

    public List<Circle> getAllCircles() {
        String sql = "select * from Circle;";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    public int insertCircle(Circle circle) {
        String sql = "insert into Circle(id,name) values(?,?);";
        return jdbcTemplate.update(sql, new Object[]{circle.getId(), circle.getName()});
    }

    public int insertCircleWithNamedParameters(Circle circle) {
        String sql = "insert into Circle(id,name) values(:id,:name);";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
        return namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    private static final class CircleMapper implements RowMapper<Circle> {
        public Circle mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Circle(id, name);
        }
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}

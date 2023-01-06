package com.it.boot;

import com.it.boot.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@SpringBootTest
public class DataBaseTest {
    @Resource
    DataSource dataSource;

    @Resource
    SqlSessionFactory sqlSessionFactory;
    @Resource
    SqlSession sqlSession;
    @Resource
    SqlSessionTemplate sqlSessionTemplate;
    @Resource
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    public void test0() throws IOException, SQLException {
        Connection conn = dataSource.getConnection();
        PreparedStatement pst = conn.prepareStatement("select now() as now");
        ResultSet res = pst.executeQuery();
        res.next();
        System.out.println(res.getDate("now"));
    }

    @Test
    public void test6() throws IOException, SQLException {
        String sql = "select id,username,password from user where id=?";
        BeanPropertyRowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<>(UserEntity.class);
        UserEntity userEntity = jdbcTemplate.queryForObject(sql, rowMapper, 1);// 查询单个
        System.out.println(userEntity);
        //        List<User> users = jdbcTemplate.query(sql, rowMapper);
    }

    @Test
    public void testInsert() {
        String sql = "insert into user (username,password) values (:username,:password)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", "Nam Ha Minh").addValue("password", "Da Nang, Vietnam");
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Test
    public void testNamedParameter() {
        String sql = "insert into user (username,password) values (:username,:password)";
        UserEntity u = new UserEntity();
        u.setUserName("tom");
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(u);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Test
    public void testNamedParameter2() {
        String sql = "select username,password from user where id= :id";
        UserEntity u = new UserEntity();
        u.setId(1L);
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(u);
        List<UserEntity> res = namedParameterJdbcTemplate.query(sql, sqlParameterSource, BeanPropertyRowMapper.newInstance(UserEntity.class));
        System.out.println(res);
    }

    @Test
    public void test9() throws IOException, SQLException {
        //        Connection conn = sqlSession.getConnection(); // session is close;
        Connection conn = sqlSessionFactory.openSession().getConnection();
        PreparedStatement pst = conn.prepareStatement("select 1");
        ResultSet res = pst.executeQuery();
    }
}

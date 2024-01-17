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
    public void test_hello() throws SQLException {
        try (Connection conn = dataSource.getConnection()) { // sqlSession.getConnection()
            PreparedStatement pst = conn.prepareStatement("select 1");
            ResultSet res = pst.executeQuery();
            System.out.println(res);
        }
    }

    @Test
    public void test6() {
        String sql = "select id,user_name,password from user where id=?";
        BeanPropertyRowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<>(UserEntity.class);
        UserEntity userEntity = jdbcTemplate.queryForObject(sql, rowMapper, 1);// 查询单个
        System.out.println(userEntity);
        //        List<User> users = jdbcTemplate.query(sql, rowMapper);
    }

    @Test
    public void testNamedParameter2() {
        String sql = "select user_name,password from user where id= :id";
        UserEntity u = new UserEntity();
        u.setId(1L);
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(u);
        List<UserEntity> res = namedParameterJdbcTemplate.query(sql, sqlParameterSource, BeanPropertyRowMapper.newInstance(UserEntity.class));
        System.out.println(res);
    }

    @Test
    public void testNamedParameter3() {
        String sql = "select user_name,password from user where id= :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", 1);
        List<UserEntity> res = namedParameterJdbcTemplate.query(sql, params, BeanPropertyRowMapper.newInstance(UserEntity.class));
        System.out.println(res);
    }
}

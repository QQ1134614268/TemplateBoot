package com.it.jpa.controller;

import com.it.jpa.dto.UserDto;
import com.it.jpa.entity.UserEntity;
import com.it.jpa.dto.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {

    <T> List<T> findByUserName(String name, Class<T> type);

    <T> T findByUserNameAndEmail(String name, String Email, Class<T> type);

    @Query("select u.username as username ,u.email as email from UserJpaTable u")
    Collection<UserProjection> testJpaSql();

    @Query(value = "select * from user u where u.id=?1", nativeQuery = true)
    UserEntity testNativeQuery(Integer integer);

    @Query(value = "select * from user u where u.id=?1", nativeQuery = true)
    UserDto getNativeQuery2(Integer integer);
}
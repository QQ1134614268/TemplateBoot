package com.it.boot.repository;

import com.it.boot.projection.UserProjection;
import com.it.boot.entity.dto.UserDto;
import com.it.boot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {
    @Query("select u.userName as userName ,u.email as email from com.it.boot.entity.UserEntity u")
    Collection<UserProjection> findAllNameAndEmail();

    <T> List<T> findByUserName(String name, Class<T> type);

    <T> T findByUserNameAndEmail(String name, String Email, Class<T> type);

    @Query(value = "select * from user u where u.id=?1", nativeQuery = true)
    UserEntity getNativeQuery(Integer integer);

    @Query(value = "select * from user u where u.id=?1", nativeQuery = true)
    UserDto getNativeQuery2(Integer integer);

}

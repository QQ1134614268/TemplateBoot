package com.it.boot.service;

import com.it.boot.entity.DeptEntity;
import com.it.boot.entity.UserEntity;
import com.it.boot.repository.UserJpaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class UserJpaService {
    @Resource
    private EntityManager entityManager;
    @Resource
    private UserJpaRepository userJpaRepository;

    public Long create(UserEntity userEntity) {
        userJpaRepository.save(userEntity);
        return userEntity.getId();
    }

    public Page<UserEntity> getPage(Pageable page, UserEntity userEntity) {
        return userJpaRepository.findAll(Example.of(userEntity), page);
    }


    public Long updateById(UserEntity userEntity) {
        userJpaRepository.save(userEntity);
        return userEntity.getId();
    }

    public Integer removeById(Integer id) {
        userJpaRepository.deleteById(id);
        return id;
    }

    public void removeByIds(List<UserEntity> userEntities) {
        userJpaRepository.deleteAll(userEntities);
    }

    /**
     * jpa连表 更多实现方案
     */
    public Object join(UserEntity userEntity) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        // criteriaBuilder.createQuery指定了字段的结果视图
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        // createQuery.from拥有关联信息的实体类(基础表)
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        // join关联的实体类，方式为inner join
        //创建左外连接  Join<左，右>     root.join("副表实体在主表主体中的属性名"，连接方式)
        Join<UserEntity, DeptEntity> join = root.join("deptEntity", JoinType.LEFT);
        Predicate predicate = criteriaBuilder.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();
        // 设定动态查询条件
        if (userEntity.getId() != null) {
            expressions.add(criteriaBuilder.equal(root.get("id"), userEntity.getId()));
        }
        if (userEntity.getDeptId() != null) {
            expressions.add(criteriaBuilder.equal(join.get("id"), userEntity.getDeptId()));
        }
        // select ... from ... where ...
        criteriaQuery.where(predicate);
        TypedQuery<UserEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}

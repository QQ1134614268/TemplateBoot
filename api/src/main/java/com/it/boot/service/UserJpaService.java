package com.it.boot.service;

import com.it.boot.dao.repository.UserJpaRepository;
import com.it.boot.entity.DeptEntity;
import com.it.boot.entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.LinkedHashMap;
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

    public Object join(List<Integer> ids) {
        // todo join

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        // criteriaBuilder.createQuery指定了字段的结果视图
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        // createQuery.from拥有关联信息的实体类(基础表)
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);

        // join关联的实体类，方式为inner join
        //创建左外连接  Join<左，右>     root.join("副表实体在主表主体中的属性名"，连接方式)
        Join<UserEntity, DeptEntity> join = root.join("orgId", JoinType.INNER);

        Predicate predicate = criteriaBuilder.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();
        // // 设定动态查询条件
        // if (fileUpdateTime != null) {
        //     expressions.add(criteriaBuilder.equal(root.get("fileUpdateTime"), fileUpdateTime));
        // }
        // if (StringUtils.hasText(dirName)) {
        //     expressions.add(criteriaBuilder.equal(join.get("dirName"), dirName));
        // }
        // select ... from ... where ...
        criteriaQuery.select(criteriaBuilder.construct(UserEntity.class,
                        root.get("fileName").alias("fileName"),
                        root.get("fileUpdateTime").alias("fileUpdateTime"),
                        join.get("dirName").alias("dirName"),
                        join.get("dirDeep").alias("dirDeep")))
                .where(predicate);
        // 传入分页参数，查询出需要的记录
        // List<UserEntity> stFileVos = entityManager.createQuery(criteriaQuery)
        //         .setFirstResult(pageCount.first()).setMaxResults(pageCount.max())
        //         .getResultList();
        // pageCount.setData(stFileVos);
        // 构建joinMap，key和value与root.join的一致
        LinkedHashMap<String,JoinType> joinMap = new LinkedHashMap<String,JoinType>(){
            {
                put("storageDir",JoinType.INNER);
                put("storagePath",JoinType.INNER);
            }};
        // select count
        // Long total = entityManager.createQuery(pageCount.count(criteriaBuilder,predicate,StorageFile.class,joinMap)).getSingleResult();
        // pageCount.setTotal(total);
        // return pageCount;
        return null;
    }
}

package com.it.boot.repository;

import com.it.boot.entity.TestDateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TestDateRepository extends JpaRepository<TestDateEntity, Integer>, JpaSpecificationExecutor<TestDateEntity> {
}

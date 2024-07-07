package com.study.microservice.school;


import com.study.microservice.school.entity.School;
import com.study.microservice.school.pojo.SchoolProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    List<SchoolProjection> findAllProjectedBy();
}

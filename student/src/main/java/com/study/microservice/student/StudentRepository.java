package com.study.microservice.student;


import com.study.microservice.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<StudentProjection> findAllProjectedBy();

    List<StudentProjection> findBySchoolId(final Long schoolId);
}

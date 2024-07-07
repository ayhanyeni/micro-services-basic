package com.study.microservice.school.client;

import com.study.microservice.school.pojo.StudentInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-micro-service", url = "${application.config.students-url}")
public interface StudentsClient {


    @GetMapping("/for-school/{schoolId}")
    List<StudentInfo> listStudentsForSchool(@PathVariable final Long schoolId);
}

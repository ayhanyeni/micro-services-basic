package com.study.microservice.school.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SchoolDetailedInfo {

    private Long id;

    private String name;

    private String email;

    List<StudentInfo> students;
}

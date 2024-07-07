package com.study.microservice.student;

import lombok.Data;

@Data
public class StudentForm {

    private String firstName;
    private String lastName;
    private String email;
    private Long schoolId;
}

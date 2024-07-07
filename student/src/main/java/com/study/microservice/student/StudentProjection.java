package com.study.microservice.student;

public interface StudentProjection {

    Long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    Long getSchoolId();
}

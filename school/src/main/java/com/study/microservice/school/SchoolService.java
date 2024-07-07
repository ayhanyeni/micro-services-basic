package com.study.microservice.school;

import com.study.microservice.school.client.StudentsClient;
import com.study.microservice.school.entity.School;
import com.study.microservice.school.pojo.SchoolDetailedInfo;
import com.study.microservice.school.pojo.SchoolForm;
import com.study.microservice.school.pojo.SchoolProjection;
import com.study.microservice.school.pojo.StudentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    private final StudentsClient studentsClient;

    @Transactional(propagation = Propagation.REQUIRED)
    public Long insert(final SchoolForm schoolForm) {

        School school = School.builder()
                .name(schoolForm.getName())
                .email(schoolForm.getEmail())
                .build();

        schoolRepository.save(school);

        return school.getId();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<SchoolProjection> listAll() {

        return schoolRepository.findAllProjectedBy();
    }

    public SchoolDetailedInfo fetchDetailed(final Long schoolId) {

        School school = schoolRepository.findById(schoolId).orElse(null);

        if (school == null) {
            return null;
        } else {

            List<StudentInfo> students = studentsClient.listStudentsForSchool(schoolId);

            return SchoolDetailedInfo.builder()
                    .id(school.getId())
                    .name(school.getName())
                    .email(school.getEmail())
                    .students(students)
                    .build();
        }
    }
}

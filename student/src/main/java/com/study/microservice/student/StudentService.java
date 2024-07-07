package com.study.microservice.student;

import com.study.microservice.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Long insert(final StudentForm studentForm) {

        Student student = Student.builder()
                .firstName(studentForm.getFirstName())
                .lastName(studentForm.getLastName())
                .email(studentForm.getEmail())
                .schoolId(studentForm.getSchoolId())
                .build();

        studentRepository.save(student);

        return student.getId();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<StudentProjection> listAll() {

        return studentRepository.findAllProjectedBy();
    }

    public List<StudentProjection> listBySchoolId(final Long schoolId) {
        return studentRepository.findBySchoolId(schoolId);
    }
}

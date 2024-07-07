package com.study.microservice.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Long> insert(@RequestBody final StudentForm studentForm) {

        Long id = studentService.insert(studentForm);

        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<StudentProjection>> listAll() {

        List<StudentProjection> students = studentService.listAll();

        return ResponseEntity.ok(students);
    }

    @GetMapping("/for-school/{schoolId}")
    public ResponseEntity<List<StudentProjection>> listBySchoolId(@PathVariable final Long schoolId) {

        List<StudentProjection> students = studentService.listBySchoolId(schoolId);

        return ResponseEntity.ok(students);
    }
}

package com.study.microservice.school;

import com.study.microservice.school.pojo.SchoolDetailedInfo;
import com.study.microservice.school.pojo.SchoolForm;
import com.study.microservice.school.pojo.SchoolProjection;
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
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<Long> insert(@RequestBody final SchoolForm schoolForm) {

        Long id = schoolService.insert(schoolForm);

        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<SchoolProjection>> listAll() {

        List<SchoolProjection> schools = schoolService.listAll();

        return ResponseEntity.ok(schools);
    }

    @GetMapping("/{schoolId}/with-students")
    public ResponseEntity<SchoolDetailedInfo> fetchSchoolWithStudents(@PathVariable final Long schoolId) {

        SchoolDetailedInfo schoolDetailedInfo = schoolService.fetchDetailed(schoolId);

        return ResponseEntity.ok(schoolDetailedInfo);
    }
}

package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.StudentService;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class DefaultStudentService implements StudentService {
    Students studentRepository;

    @Override
    @Autowired
    public Collection<Student> getPassedStudents() {
        studentRepository = CsvStudents.getInstance();
        // TODO 1 : pass한 학생만 반환하도록 수정하세요. 한듯!
        return studentRepository.findAll()
            .stream().filter(student -> !student.getScore().isFail())
            .collect(Collectors.toList());
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {
        studentRepository = CsvStudents.getInstance();
        // TODO 4 : 성적 순으로 학생 정보를 반환합니다. 한듯!
        return studentRepository.findAll()
            .stream()
            .sorted(Comparator.comparing(s -> s.getScore().getScore()))
            .collect(Collectors.toList());
    }
}


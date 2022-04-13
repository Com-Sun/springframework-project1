package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultGradeQueryService implements GradeQueryService {
    @Override
    public List<Score> getScoreByStudentName(String name) throws IOException {
        // TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
        List<Student> students =
            CsvStudents.getInstance().findAll().stream().filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());

        List<Score> listScore = new ArrayList<>();
        for (Student student : students) {
            listScore.add(student.getScore());
        }

        return listScore;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        // TODO 6 : 학생 번호로 점수를 반환합니다.
        return ((CsvStudents)CsvStudents.getInstance()).getStudents().get(seq).getScore();
    }
}

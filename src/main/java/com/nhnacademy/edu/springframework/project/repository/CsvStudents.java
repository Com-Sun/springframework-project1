package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.util.Collection;


/** TODO 3 : load 를 완료전에 기타 메소드 실행시 IllegalStateException 이 발생해야 한다. 한듯
 **/

/**
 * TODO 7 : singleton 클래스를 만드세요.
 */
public class CsvStudents implements Students {

    private static final Students INSTANCE = new CsvStudents();

    public static Students getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("데이터가 제대로 로드되지 않았습니다.");
        }
        return INSTANCE;
    }

    // TODO 6 : student.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {

    }

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {

    }
}

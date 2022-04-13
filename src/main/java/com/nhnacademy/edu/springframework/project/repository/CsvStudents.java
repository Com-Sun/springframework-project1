package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * TODO 3 : load 를 완료전에 기타 메소드 실행시 IllegalStateException 이 발생해야 한다. 한듯
 **/

/**
 * TODO 7 : singleton 클래스를 만드세요.
 */
public class CsvStudents implements Students {
    private static final Students INSTANCE = new CsvStudents();
    private final Map<Integer, Student> students = new HashMap<>();


    public static Students getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("데이터가 제대로 로드되지 않았습니다.");
        }
        return INSTANCE;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    // TODO 6 : student.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() throws IOException {
        try (InputStream inputStream = getClass().getClassLoader()
            .getResourceAsStream("data/student.csv");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader);
        ) {
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] readStudent = line.split(",");
                students.put(Integer.parseInt(readStudent[0]),
                    new Student(Integer.parseInt(readStudent[0]), readStudent[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Student> findAll() {
        if (this.students.isEmpty()) {
            throw new IllegalStateException();
        }

        return this.students.values();
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        if (this.students.isEmpty()) {
            throw new IllegalStateException();
        }

        for (Score score : scores) {
            this.students.get(score.getStudentSeq()).setScore(score);
        }
    }
}

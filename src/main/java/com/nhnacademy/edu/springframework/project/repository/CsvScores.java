package com.nhnacademy.edu.springframework.project.repository;

import java.util.ArrayList;
import java.util.List;

/** TODO 2 : load 를 완료전에 기타 메소드 실행시 IllegalStateException 이 발생해야 한다. 한듯
 **/
public class CsvScores implements Scores {
    private static final Scores INSTANCE = new CsvScores();

    private CsvScores(){}

    public static Scores getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("데이터 로드가 완료되지 않았습니다.");
        }
        return null;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {

    }

    @Override
    public List<Score> findAll() {
        return null;
    }
}

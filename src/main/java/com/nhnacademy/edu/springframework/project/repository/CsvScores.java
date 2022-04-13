package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 2 : load 를 완료전에 기타 메소드 실행시 IllegalStateException 이 발생해야 한다. 한듯
 **/
public class CsvScores implements Scores {
    private static Scores INSTANCE = new CsvScores();
    // 여기에 멤버변수 선언
    // 다형성을 안쓰면 변수를 새로 계속만들어야함
    List<Score> scores = new ArrayList<>();

//    private CsvScores() {
//    }

    // 다형성: 상위타입에 레퍼런스로 하위타입을 참조할수있음
    public static Scores getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CsvScores();
        }
        return INSTANCE;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() throws IOException {
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("data/score.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);

            String line = "";
            String delimeter = ",";

            while ((line = br.readLine()) != null) {
                String[] readScore = line.split(delimeter);
                scores.add(
                    new Score(Integer.parseInt(readScore[0]), Integer.parseInt(readScore[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Score> findAll() {
        if (this.scores.isEmpty()) {
            throw new IllegalStateException();
        }
        return scores;
    }
}

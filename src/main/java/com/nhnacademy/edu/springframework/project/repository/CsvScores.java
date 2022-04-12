package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 2 : load 를 완료전에 기타 메소드 실행시 IllegalStateException 이 발생해야 한다. 한듯
 **/
public class CsvScores implements Scores {
    private static final Scores INSTANCE = new CsvScores();

    private CsvScores() {

    }

    public static Scores getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("데이터 로드가 완료되지 않았습니다.");
        }
        return null;
    }

    // classloader.getResourceAsStream - 클래스로더
    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() throws IOException {
//        InputStream inputStream = ClassLoader.getSystemResourceAsStream("src/main/resources/data/score.csv");

        List<List<String>> csvList = new ArrayList<List<String>>();
        File csv = new File("data/score.csv");
        BufferedReader br = null;
        String line = "";
        List<Score> scores = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            for (Score score : scores) {
                scores.add(new Score(score.getStudentSeq(), score.getScore()));
            }
            try {
                if (br != null) {
                    br.close(); // 사용 후 BufferedReader를 닫아준다.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Score> findAll() {
        return null;
    }
}

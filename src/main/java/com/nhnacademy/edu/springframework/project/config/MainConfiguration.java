package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public Students csvStudent() {
        return new CsvStudents();
    }

    @Bean
    public Scores csvScores() {
        return new CsvScores();
    }

}

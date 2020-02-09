package com.sb.part1;

import com.sb.part1.util.DBConnect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.Connection;

@SpringBootApplication
@EnableScheduling
public class Part1Application {

//    Connection con = DBConnect.connect();

    public static void main(String[] args) {

        SpringApplication.run(Part1Application.class, args);



    }

}

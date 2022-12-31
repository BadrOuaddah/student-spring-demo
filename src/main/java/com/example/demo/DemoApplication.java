package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

// TODO: add Angular App to API spring and start to learn front-end with Angular framework and add to spring
//https://www.youtube.com/watch?v=rdLJNGZvlAA&ab_channel=TechieOcean
//https://www.youtube.com/watch?v=9nxSvecSa50&ab_channel=CodeStepByStep
//StudentComponent
//First task display the List
//Insert a student
//Delete a student
//Update a student
//https://www.youtube.com/watch?v=yPqusXA5FNg&ab_channel=JavaTechie
//Youtube search : How to consume simple Api Angular
//localhost:8080
//https://www.youtube.com/watch?v=OJ7-EC69LfU&ab_channel=CodeStepByStep

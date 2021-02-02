package com.boyang.myflix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class MyflexApplication {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        SpringApplication.run(MyflexApplication.class, args);
    }
}

package com.boyang.myflix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {
    @GetMapping
    public String test(){
        return "Hello world!!!!!";
    }
//    @Autowired
//    private MongoTemplate mongoTemplate;
}

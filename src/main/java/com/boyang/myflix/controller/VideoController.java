package com.boyang.myflix.controller;

import com.boyang.myflix.bean.Video;
import com.boyang.myflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/all")
    public List<Video> findAll() {
        return videoService.findAll();
    }
}

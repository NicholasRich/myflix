package com.boyang.myflix.controller;

import com.boyang.myflix.bean.Video;
import com.boyang.myflix.service.VideoService;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/play/{videoName}")
    public byte[] play(@PathVariable("videoName") String videoName) throws SftpException {
        return videoService.play(videoName);
    }
}

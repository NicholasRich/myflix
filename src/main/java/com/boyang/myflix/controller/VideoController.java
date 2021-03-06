package com.boyang.myflix.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.boyang.myflix.bean.Video;
import com.boyang.myflix.service.VideoService;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/{category}")
    public List<Video> findByCategory(@PathVariable("category") String category) {
        return videoService.findByCategory(category);
    }

    @GetMapping("/all")
    public List<Video> findAll() {
        return videoService.findAll();
    }

    @PostMapping("/play/{videoName}")
    public byte[] play(@PathVariable("videoName") String videoName) throws SftpException {
        Sftp sftp = JschUtil.createSftp("35.187.40.59", 22, "root", "Wby102938");
        InputStream inputStream = sftp.getClient().get("/home/wby8456/video/" + videoName);
        byte[] bytes = IoUtil.readBytes(inputStream);
        sftp.close();
        return bytes;
    }

    @PostMapping()
    public Map<String, Object> upload(@RequestParam MultipartFile file, @RequestParam Map<String, Object> map) throws IOException {
        Sftp sftp = JschUtil.createSftp("35.187.40.59", 22, "root", "Wby102938");
        sftp.upload("/home/wby8456/video/", file.getResource().getFile());
//        System.out.println(name);
        return null;
    }
}

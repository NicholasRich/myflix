package com.boyang.myflix.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.boyang.myflix.bean.Video;
import com.boyang.myflix.service.VideoService;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/{category}}")
    public List<Video> findAll(@PathVariable("category") String category) {
        return videoService.findByCategory(category);
    }

    @PostMapping("/play/{videoName}")
    public byte[] play(@PathVariable("videoName") String videoName) throws SftpException {
        Sftp sftp = JschUtil.createSftp("35.187.40.59", 22, "root", "Wby102938");
        InputStream inputStream = sftp.getClient().get("/home/wby8456/nginx/html/video/" + videoName);
        byte[] bytes = IoUtil.readBytes(inputStream);
        sftp.close();
        return bytes;
    }
}

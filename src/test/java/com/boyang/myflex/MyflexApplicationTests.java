package com.boyang.myflex;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.boyang.myflix.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@SpringBootTest
class MyflexApplicationTests {
    @Autowired
    private VideoService videoService;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Test
    void contextLoads() {
        String s = gridFsTemplate.store(FileUtil.getInputStream("C:\\Users\\84565\\Desktop\\test.png"), "test.png").toString();
        System.out.println(s);
//        videoService.addVideo(new Video());
    }

    @Test
    void download() {
        videoService.getThumb("21a6583e62cb4065ab67f77a8d6041a9");
    }

    @Test
    void ssh() {
        Sftp sftp = JschUtil.createSftp("34.76.177.111", 22, "wby8456", "123456");
        System.out.println(sftp.home());
    }

}

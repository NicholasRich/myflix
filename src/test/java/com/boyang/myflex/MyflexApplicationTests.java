package com.boyang.myflex;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.boyang.myflix.MyflexApplication;
import com.boyang.myflix.bean.Category;
import com.boyang.myflix.bean.User;
import com.boyang.myflix.bean.Video;
import com.boyang.myflix.service.CategoryService;
import com.boyang.myflix.service.UserService;
import com.boyang.myflix.service.VideoService;
import com.jcraft.jsch.SftpException;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.io.InputStream;
import java.util.Date;

@SpringBootTest(classes = MyflexApplication.class)
class MyflexApplicationTests {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Test
    void contextLoads() {
        Video video = new Video();
        video.setCategories(CollUtil.toList("cartoon", "shorts"));
        video.setThumbnailName("test.png");
        video.setUpdateTime(new Date());
        video.setUserName("admin");
        video.setName("testVideo2");
        video.setFileName("hyperwangg.mp4");
        System.out.println(videoService.addVideo(video));
//        System.out.println(videoService.findAll().get(0).getName());
    }

    @Test
    void download() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        System.out.println(userService.addUser(user));
    }

    @Test
    void ssh() throws SftpException {
        Sftp sftp = JschUtil.createSftp("35.187.40.59", 22, "root", "Wby102938");
        InputStream inputStream = sftp.getClient().get("/home/wby8456/nginx/html/video/hyperwangg.mp4");
        FileUtil.writeFromStream(inputStream, "C:/test.mp4");
        sftp.close();
    }

    @Test
    void category() {
        Category category = new Category();
        category.setName("cartoon");
        System.out.println(categoryService.addCategory(category));
    }


    @Test
    void test3() throws FrameGrabber.Exception {
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault("C:/test.mp4");

        ff.start();
        int ffLength = ff.getLengthInFrames();
        Frame f = null;
        int i = 0;
        while (i < ffLength) {
            f = ff.grabImage();
            //截取第0帧
            if (i == 3) {
                //执行截图并放入指定位置
                videoService.doExecuteFrame(f);
                break;
            }
            i++;
        }
        ff.stop();


    }

}

package com.boyang.myflex;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.boyang.myflix.MyflexApplication;
import com.boyang.myflix.bean.Category;
import com.boyang.myflix.bean.User;
import com.boyang.myflix.bean.Video;
import com.boyang.myflix.service.CategoryService;
import com.boyang.myflix.service.UserService;
import com.boyang.myflix.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

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
        video.setName("testVideo1");
        video.setFileName("hyperwangg.mp4");
//        System.out.println(videoService.addVideo(video));
        System.out.println(videoService.findAll().get(0).getName());
    }

    @Test
    void download() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        System.out.println(userService.addUser(user));
    }

    @Test
    void ssh() {
        Sftp sftp = JschUtil.createSftp("34.76.177.111", 22, "wby8456", "123456");
        System.out.println(sftp.home());
    }

    @Test
    void category() {
        Category category = new Category();
        category.setName("cartoon");
        System.out.println(categoryService.addCategory(category));
    }

}

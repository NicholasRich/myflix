package com.boyang.myflix.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.boyang.myflix.bean.Video;
import com.boyang.myflix.repository.VideoRepository;
import com.boyang.myflix.service.VideoService;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public String addVideo(Video video) {
        return videoRepository.save(video).getId();
    }

    @Override
    public byte[] getThumb(String id) {
        return null;
//        Video video = videoRepository.findById(id).get();
//        FileUtil.writeBytes(video.getThumbnailId().getData(),"C:\\Users\\84565\\Desktop\\test2.png");
//        return null;
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll(Sort.by(Sort.Direction.DESC, "updateTime"));
    }

    @Override
    public byte[] play(String videoName) throws SftpException {
        Sftp sftp = JschUtil.createSftp("35.187.40.59", 22, "root", "Wby102938");
        InputStream inputStream = sftp.getClient().get("/home/wby8456/nginx/html/video/" + videoName);
        sftp.close();
        return IoUtil.readBytes(inputStream);
    }
}

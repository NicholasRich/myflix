package com.boyang.myflix.service.impl;

import com.boyang.myflix.bean.Video;
import com.boyang.myflix.repository.VideoRepository;
import com.boyang.myflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

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
//        video.setId(IdUtil.fastSimpleUUID());
        video.setFileName("test.png");
        video.setThumbnailId("");
        videoRepository.save(video);
        return null;
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
        return videoRepository.findAll();
    }
}

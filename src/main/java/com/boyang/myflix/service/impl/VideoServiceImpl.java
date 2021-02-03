package com.boyang.myflix.service.impl;

import com.boyang.myflix.bean.Video;
import com.boyang.myflix.repository.VideoRepository;
import com.boyang.myflix.service.VideoService;
import com.jcraft.jsch.SftpException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public List<Video> findByCategory(String category) {
//        mongoTemplate.find(Query.query(Criteria.where("categories").(Criteria.)))
        return videoRepository.findAllByCategories(category);
    }

    @Override
    public byte[] play(String videoName) throws SftpException {
        return null;
    }

    @Override
    public void doExecuteFrame(Frame frame) {
        String imagemat = "jpg";
        if (null == frame) {
            return;
        }
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bi = converter.getBufferedImage(frame);
        try {
            // 构造一个类型为预定义图像类型之一的 BufferedImage
            BufferedImage tag = new BufferedImage(240, 150, BufferedImage.TYPE_INT_RGB);

            //绘制图像  getScaledInstance表示创建此图像的缩放版本，返回一个新的缩放版本Image,按指定的width,height呈现图像
            //Image.SCALE_SMOOTH,选择图像平滑度比缩放速度具有更高优先级的图像缩放算法。
            tag.getGraphics().drawImage(bi.getScaledInstance(240, 150, Image.SCALE_DEFAULT), 0, 0, null);

            //创建文件输出流
            FileOutputStream out = new FileOutputStream("C:/test.jpg");
            //将图片按JPEG压缩，保存到out中
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            //关闭文件输出流
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

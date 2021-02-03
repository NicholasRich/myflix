package com.boyang.myflix.service;

import com.boyang.myflix.bean.Video;
import com.jcraft.jsch.SftpException;

import java.util.List;

public interface VideoService {
    String addVideo(Video video);

    byte[] getThumb(String id);

    List<Video> findAll();

    byte[] play(String videoName) throws SftpException;
}

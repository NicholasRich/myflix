package com.boyang.myflix.service;

import com.boyang.myflix.bean.Video;

public interface VideoService {
    String addVideo(Video video);

    byte[] getThumb(String id);
}

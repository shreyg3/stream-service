package com.streaming.stream.service.impl;

import com.streaming.stream.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingServiceImpl  implements StreamingService {

    @Autowired
    private ResourceLoader resourceLoader;


    @Override
    public Mono<Resource> getVideo(String title) {
        String video = "classpath:/videos/%s.mp4";
        return Mono.fromSupplier(
                ()->resourceLoader.getResource(String.format(video,title)));
    }
}

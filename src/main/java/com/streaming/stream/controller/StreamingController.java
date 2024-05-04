package com.streaming.stream.controller;

import com.streaming.stream.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StreamingController {

    @Autowired
    StreamingService streamingService;

    @GetMapping(path = {"stream/{title}"}, produces = "video/mp4")
    public Mono<Resource> getController(@PathVariable String title) {
        return streamingService.getVideo(title);
    }
}

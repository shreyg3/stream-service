package com.streaming.stream.controller;

import com.streaming.stream.config.AstraClient;
import com.streaming.stream.service.StreamingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StreamingController {

    private static final Logger log = LoggerFactory.getLogger(StreamingController.class);
    @Autowired
    StreamingService streamingService;

    @Value("${db.astraToken}")
    private String token;

    @GetMapping(path = {"stream/{title}"}, produces = "video/mp4")
    public Mono<Resource> getController(@PathVariable String title) {
        AstraClient dataAPIClient = new AstraClient();
        log.info("token is : " + token);
        dataAPIClient.getAstraClient(token);
        return streamingService.getVideo(title);
    }
}

package com.bluejeans.backend.controller;


import com.bluejeans.backend.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/video")
@AllArgsConstructor
public class VideoController {
    private VideoService videoService;


    // video_id, video_file, insurance_comment
    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException {
        videoService.saveVideo(file, name);
        return ResponseEntity.ok("Video saved successfully");
    }

    @GetMapping("{name}")
    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name) {
        return ResponseEntity
                .ok(new ByteArrayResource(videoService.getVideo(name).getData()));
    }

//    @GetMapping("{name}")
//    public ResponseEntity<Resource> getIdByName(@PathVariable("name") String name) {
//        return ResponseEntity
//                .ok(new ByteArrayResource(videoService.getVideo(name).getData()));
//    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllVideoNames() {
        return ResponseEntity.ok(videoService.getAllVideoNames());
    }


//    @PostMapping()
//    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException {
//        videoService.saveVideo(file, name);
//        return ResponseEntity.ok("Video saved successfully");
//    }
//
//    @GetMapping("{name}")
//    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name) {
//        return ResponseEntity
//                .ok(new ByteArrayResource(videoService.getVideo(name).getData()));
//    }
//
//
//    @GetMapping("/all")
//    public ResponseEntity<List<String>> getAllVideoNames() {
//        return ResponseEntity.ok(videoService.getAllVideoNames());
//    }
}

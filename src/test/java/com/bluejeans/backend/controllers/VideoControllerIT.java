package com.bluejeans.backend.controllers;

import com.bluejeans.backend.services.VideoService;
import com.bluejeans.backend.controller.VideoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class VideoControllerIT {

    @Autowired VideoController controller;
    @Autowired VideoService service;
    MultipartFile file = mock(MultipartFile.class);


    @Test
    void saveVideo(){

    }
}

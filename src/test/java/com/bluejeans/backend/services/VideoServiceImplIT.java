package com.bluejeans.backend.services;

//import com.bluejeans.backend.VideoService;
import com.bluejeans.backend.domain.Video;
import com.bluejeans.backend.repo.VideoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Transactional
public class VideoServiceImplIT {
    @Autowired VideoService service;
    @Autowired VideoRepo repo;

    String testName = "myVid";

    @Test
    void getVideo() {
        Video expected = new Video(testName, null);
        repo.save(expected);
        Video actual = service.getVideo(testName);

        assertEquals(expected, actual);
    }

    @Test
    void saveVideo() throws IOException {
        MultipartFile file = mock(MultipartFile.class);
        service.saveVideo(file, testName);
        assertTrue(repo.existsByName(testName));
    }

    @Test
    void getAllVideoNames() {
        List<String> expected = List.of(testName);
        repo.save(new Video(testName, null));
        List<String> actual = service.getAllVideoNames();

        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }



}

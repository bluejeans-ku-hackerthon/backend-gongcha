package com.bluejeans.backend.services;

//import com.bluejeans.backend.VideoService;
import com.bluejeans.backend.domain.Video;
import com.bluejeans.backend.repo.VideoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
class VideoServiceImplTest {

    VideoRepo repo = mock(VideoRepo.class);
    VideoService service = new VideoServiceImpl(repo);

    String testName = "myVid";

    @Test
    void getVideo() {
        Video expected = new Video(testName, null);

        when(repo.findByName(testName))
                .thenReturn(expected);

        when(repo.existsByName(testName))
                .thenReturn(true);
        Video actual = service.getVideo(testName);
        assertEquals(expected, actual);
        verify(repo, times(1)).existsByName(testName);
        verify(repo, times(1)).findByName(testName);
    }

    @Test
    void saveVideo() throws IOException {
        MultipartFile file = mock(MultipartFile.class);
        Video testVid = new Video(testName, file.getBytes());
        service.saveVideo(file, testName);
        verify(repo, times(1)).existsByName(testName);
        verify(repo, times(1)).save(testVid);
    }

    @Test
    void getAllVideoNames() {
        List<String> expected = List.of("myVid", "otherVid");
        when(repo.getAllEntryNames())
                .thenReturn(expected);
        List<String> actual = service.getAllVideoNames();
        assertEquals(expected, actual);
        verify(repo, times(1)).getAllEntryNames();
    }
}
package com.bluejeans.backend.services;

import com.bluejeans.backend.domain.Video;
import com.bluejeans.backend.exceptions.VideoAlreadyExistsException;
import com.bluejeans.backend.exceptions.VideoNotFoundException;
import com.bluejeans.backend.repo.VideoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {
    private VideoRepo repo;

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(repo.existsByName(name)) {
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, file.getBytes());
        repo.save(newVid);
    }

    @Override
    public Video getVideo(String name) {
        if(!repo.existsByName(name)) {
            throw new VideoNotFoundException();
        }
        return repo.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repo.getAllEntryNames();
    }

}

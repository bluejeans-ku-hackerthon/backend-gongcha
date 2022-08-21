package com.bluejeans.backend.repo;

import com.bluejeans.backend.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepo extends JpaRepository<Video, Long> {
    Video findByName(String name);



    boolean existsByName(String name);

    @Query(nativeQuery = true, value = "SELECT name FROM video")
    List<String> getAllEntryNames();

}

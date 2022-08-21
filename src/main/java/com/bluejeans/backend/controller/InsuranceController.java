package com.bluejeans.backend.controller;

import com.bluejeans.backend.domain.Insurance;
import com.bluejeans.backend.domain.Video;
import com.bluejeans.backend.repo.InsuranceRepository;
import com.bluejeans.backend.services.InsuranceService;
import com.bluejeans.backend.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
@AllArgsConstructor
public class InsuranceController {
    private InsuranceService insuranceService;
    private VideoService videoService;

    @GetMapping("/returnVideo/{name}")
    public Video returnJson(@PathVariable String name) {
        return videoService.getVideo(name);
    }

    @GetMapping("/returnComment/{id}")
    public Insurance returnComment(@PathVariable Long id) {
        return insuranceService.findOne(id);
    }


}

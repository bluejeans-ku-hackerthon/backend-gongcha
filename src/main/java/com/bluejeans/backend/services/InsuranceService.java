package com.bluejeans.backend.services;


import com.bluejeans.backend.domain.Insurance;
import com.bluejeans.backend.repo.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    public void write(Long id, int justice, String comment) {
        Insurance insurance = Insurance.createInsurance(id, justice, comment);
        insuranceRepository.save(insurance);
    }



//     전체 조회
    public List<Insurance> findMembers() {
        return insuranceRepository.findAll();
    }

//     단건 조회
    public Insurance findOne(Long memberId) {
        return insuranceRepository.findOne(memberId);
    }






}

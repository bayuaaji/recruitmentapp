package com.dansmultipro.recruitmentapp.services;

import com.dansmultipro.recruitmentapp.dto.RecruitmentDTO;

import java.util.List;

public interface RecruitmentService {
    List<RecruitmentDTO> getAllRecruitments();

    RecruitmentDTO getJobDetail(String id);
}

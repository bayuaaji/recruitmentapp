package com.dansmultipro.recruitmentapp.controllers;

import com.dansmultipro.recruitmentapp.dto.RecruitmentDTO;
import com.dansmultipro.recruitmentapp.dto.WebResponse;
import com.dansmultipro.recruitmentapp.services.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recruitments")
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @GetMapping(path = "/jobs")
    public ResponseEntity<WebResponse<List<RecruitmentDTO>>> getJobList() {
        List<RecruitmentDTO> allRecruitments = recruitmentService.getAllRecruitments();
        return new ResponseEntity<>(new WebResponse<>(Boolean.TRUE, "Success", allRecruitments), HttpStatus.OK);
    }

    @GetMapping(path = "/jobs/{id}")
    public ResponseEntity<WebResponse<RecruitmentDTO>> getJobDetail(@PathVariable("id") String id){
        RecruitmentDTO jobDetail = recruitmentService.getJobDetail(id);
        return new ResponseEntity<>(new WebResponse<>(Boolean.TRUE, "Success", jobDetail), HttpStatus.OK);
    }
}

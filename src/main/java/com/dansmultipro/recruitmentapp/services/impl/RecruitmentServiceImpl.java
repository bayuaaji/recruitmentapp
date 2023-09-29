package com.dansmultipro.recruitmentapp.services.impl;

import com.dansmultipro.recruitmentapp.dto.RecruitmentDTO;
import com.dansmultipro.recruitmentapp.services.RecruitmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    private static final String URL_ALL_RECRUITMENTS = "https://dev6.dansmultipro.com/api/recruitment/positions.json";
    private static final String RECRUITMENT_BY_ID = "https://dev6.dansmultipro.com/api/recruitment/positions/";
    @Override
    public List<RecruitmentDTO> getAllRecruitments() {

        try {
            List<RecruitmentDTO> recruitmentDTOList = new ArrayList<>();

            URL url = new URL(URL_ALL_RECRUITMENTS);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the API
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper objectMapper = new ObjectMapper();
                RecruitmentDTO[] jsonArray = objectMapper.readValue(response.toString(), RecruitmentDTO[].class);

                recruitmentDTOList.addAll(Arrays.asList(jsonArray));
            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            connection.disconnect();

            return recruitmentDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    public RecruitmentDTO getJobDetail(String jobId){

        try {
            RecruitmentDTO res = new RecruitmentDTO();
            URL url = new URL(RECRUITMENT_BY_ID + jobId);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the JSON string into object DTO
                ObjectMapper objectMapper = new ObjectMapper();
                res = objectMapper.readValue(response.toString(), RecruitmentDTO.class);

            } else {
                System.out.println("HTTP Request Failed with Response Code: " + responseCode);
            }
            connection.disconnect();
            return res;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}

package com.dansmultipro.recruitmentapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse <T>{

    private Boolean success;

    private String message;

    private T data;
}

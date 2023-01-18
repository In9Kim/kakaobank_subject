package com.example.kakaobank_subject.service;

import com.example.kakaobank_subject.dto.Credit_Start;

import java.util.Map;

public interface Kakaobank_Credit_Service {
    Map<String,Object> get_Credit_Limit(Credit_Start dto);
    void set_Credit_History(Map<String,Object> Credit_map);
}


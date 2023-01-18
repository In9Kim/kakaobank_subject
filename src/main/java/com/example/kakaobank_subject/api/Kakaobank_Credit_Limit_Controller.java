package com.example.kakaobank_subject.api;

import com.example.kakaobank_subject.dto.Credit_Start;
import com.example.kakaobank_subject.service.Kakaobank_Credit_Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class Kakaobank_Credit_Limit_Controller {

    @Autowired // DI
    private Kakaobank_Credit_Service kakaobank_credit_service;

    //POST
    @PostMapping("/api/Rate_Search")
    public ResponseEntity<Map<String,Object>> show(@RequestBody Credit_Start dto){
        Map<String ,Object> return_val = new HashMap<>();
        return_val = kakaobank_credit_service.get_Credit_Limit(dto);

        if(((HashMap)return_val.get("Loan Limit value")).get("error") != null) {
            log.info("map_return:" + ((HashMap) return_val.get("Loan Limit value")).get("error"));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(return_val);
        }
        else{
            kakaobank_credit_service.set_Credit_History(return_val);
            return ResponseEntity.status(HttpStatus.OK).body(return_val);
        }
    }
}

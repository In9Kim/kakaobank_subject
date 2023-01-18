package com.example.kakaobank_subject.service;

import com.example.kakaobank_subject.dto.Credit_Start;
import com.example.kakaobank_subject.mapper.CreditHistoryMapper;
import com.example.kakaobank_subject.mapper.CreditLimitMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

@Slf4j
@Service
public class Kakaobank_Credit_Limit_Service implements Kakaobank_Credit_Service {

    @Autowired
    private CreditLimitMapper creditLimitMapper;

    @Autowired
    private CreditHistoryMapper creditHistoryMapper;

    @Override
    public Map<String,Object> get_Credit_Limit(Credit_Start dto) {
        LinkedHashMap<String,Object> setter_val = new LinkedHashMap<>();
        LinkedHashMap<String,Object> return_val = new LinkedHashMap<>();

        String Final_Rate_code = null;
        double Final_Credit_Limit = 0.0;
        
        //1.신용등급에 따른 가산금리 및 대출한도 계산
        if (dto.getCredit() >= 1 && dto.getCredit() <= 4){
            Final_Rate_code = "3001";
            Final_Credit_Limit = dto.getSalary() * 0.9;
        }
        else if (dto.getCredit() >= 5 && dto.getCredit() <= 7){
            Final_Rate_code = "3002";
            Final_Credit_Limit = dto.getSalary() * 0.7;
        }
        else if (dto.getCredit() >= 8 && dto.getCredit() <= 9) {
            Final_Rate_code = "3003";
            Final_Credit_Limit = dto.getSalary() * 0.4;
        }
        else {
            Final_Rate_code = "0000";
        }

        //2.대출을 제공하지않는 신용등급의 경우, 에러로 분류
        if(dto.getCredit() > 9){
            setter_val.put("error","400");
            setter_val.put("message","내부 심사 기준의 부적합하여, 대출 실행이 불가능합니다.");
        }
        else{
            setter_val.put("error",null);
            setter_val.put("message","대출 한도 조회가 완료 되었습니다.");

            setter_val.put("customer_pk",dto.getCustomer_pk());
            setter_val.put("credit",dto.getCredit());
            setter_val.put("credit_Limit",(int)Final_Credit_Limit);
            setter_val.put("credit_Rate",creditLimitMapper.getLimit(Final_Rate_code));
        }

        return_val.put("Loan Limit value",setter_val);

        return return_val;
    }

    @Override
    @Transactional
    public void set_Credit_History(Map<String,Object> Credit_map) {
        String Customer_pk = (String) ((HashMap)Credit_map.get("Loan Limit value")).get("customer_pk");

        int Customer_pk_cnt = 0;

        Customer_pk_cnt = creditHistoryMapper.getHistory(Customer_pk);

        log.info("Customer_pk_cnt:"+Customer_pk_cnt);

        //update
        if (Customer_pk_cnt > 0){
            creditHistoryMapper.setHistory_U((HashMap)Credit_map.get("Loan Limit value"));
        }
        //insert
        creditHistoryMapper.setHistory_I((HashMap)Credit_map.get("Loan Limit value"));
    }
}

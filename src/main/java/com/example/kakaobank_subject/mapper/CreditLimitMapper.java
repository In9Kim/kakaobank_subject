package com.example.kakaobank_subject.mapper;

import com.example.kakaobank_subject.dto.Credit_Start;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface CreditLimitMapper {
    /*
    여러 개의 파라미터 전송시 HashMap를 생성해서 데이터를 담고 전송한다.
    Map<String,String> map = new HashMap<String,String>();
    map.put("name",name);
    map.put("phone",phone);
    */
    public int getLimit(String VS_IN_KAKAO);
}

package com.example.kakaobank_subject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface CreditHistoryMapper {
    public int getHistory(String VS_CUSTOMER_PK);

    public void setHistory_U(Map<String,Object> History_Data);

    public void setHistory_I(Map<String,Object> History_Data);

}

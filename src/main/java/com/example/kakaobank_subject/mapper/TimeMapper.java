package com.example.kakaobank_subject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {

    @Select("select sysdate from dual")
    public String getTime();
    //XML 방식
    public String getTime2();
}
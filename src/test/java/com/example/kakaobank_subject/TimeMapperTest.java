package com.example.kakaobank_subject;

import com.example.kakaobank_subject.mapper.TimeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TimeMapperTest {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {
        log.info("timeMapper class name: " + timeMapper.getClass().getName());
        log.info("timeMapper time: " + timeMapper.getTime());
    }

    //XML 방식
    @Test
    public void testGetTime2() {
        log.info("getTime2");
        log.info("getTime2: " + timeMapper.getTime2());
    }
}
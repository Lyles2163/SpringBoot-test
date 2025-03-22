package com.itheima.tliasweb;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class LogTest {
    private  static  final Logger log = LoggerFactory.getLogger(LogTest.class);
  @Test
    public  void testLog(){
        log.info(() -> "info日志");
        int sum =0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }

    }
}

package com.kiseki.daemon.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class TimeUtilsTest {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void testTime() {
        // 数据库新增一个type用于判断是使用时间还是使用周来计算日期，数据库再增加四个字段，年、月、日、周
        // 判空数据库输入
        // 把时、分、秒置为0（也可以不需要）
/*        LocalDateTime localDatetime = LocalDateTime.now();
        System.out.println("原日期：" + DATETIME_FORMATTER.format(localDatetime));
        LocalDateTime minusDateTime = localDatetime.minus(Period.of(1, 0, 0));
        System.out.println("按日期计算：" + DATETIME_FORMATTER.format(minusDateTime));
        localDatetime = LocalDateTime.now();
        minusDateTime = localDatetime.minusWeeks(2L);
        System.out.println("按周计算：" + DATETIME_FORMATTER.format(minusDateTime));

        String str = "Mac";
        String[] fileds = str.split("\\.");
        System.out.println(fileds);*/

        String leftPadStr = "abcd";

        String result = StringUtils.leftPad(leftPadStr, 6, "*");

        System.out.println(result);

    }
}

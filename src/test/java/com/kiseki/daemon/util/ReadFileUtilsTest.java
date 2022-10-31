package com.kiseki.daemon.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.file.Files;

@SpringBootTest
public class ReadFileUtilsTest {

    @Test
    public void testSimpleRead() {
        String filePath = "E:\\Document\\Download\\z-Doc\\test-data.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("找不到该文件！");
        }
        try {
            InputStream inputStream = Files.newInputStream(file.toPath());
            String resultStr = ReadFileUtils.simpleRead(inputStream);
            System.out.println(resultStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

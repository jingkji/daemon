package com.kiseki.daemon.util;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;

public class ReadFileUtils {

    /**
     * 读取 InputStream 输入流，然后解析里面的文本
     * 使用范围：文本文件（*.txt、*.doc、*.docx ...）
     * @param inputStream 输入流
     * @return 文件的文本内容
     * @throws IOException IO异常捕获
     */
    public static String simpleRead(InputStream inputStream) throws IOException {

        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    /**
     * 从 Classpath 读取文件 - 根据文件绝对路径读取文件（ src/main/resources ）
     * @param fileName 绝对路径文件名 - 需要带 “/”
     * @return 输入流，使用完需要手动关闭
     */
    public static InputStream getClasspathFile(String fileName) {
        checkStringBlank(fileName);
        return ReadFileUtils.class.getResourceAsStream(fileName);
    }

    /**
     * 从 Classpath 读取文件 - 根据文件绝对路径读取文件（ src/main/resources ）
     * @param fileName 相对路径文件名 - 不需要带 “/”
     * @return 文件，使用完需要手动关闭
     */
    public File getClasspathFileByClassLoader(String fileName) {
        checkStringBlank(fileName);
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    public static InputStream getFileInputStream(String filePath) throws IOException {
        checkStringBlank(filePath);
        File file = new File(filePath);
        checkFileExist(file);
        return Files.newInputStream(file.toPath());
    }

    private static void checkStringBlank(String str) {
        if (StringUtils.isBlank(str)) {
            throw new RuntimeException("空字符串！");
        }
    }

    private static void checkFileExist(File file) {
        if (!file.exists()) {
            throw new RuntimeException("找不到该文件！");
        }
    }
}

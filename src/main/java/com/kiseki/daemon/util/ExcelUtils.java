package com.kiseki.daemon.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.kiseki.daemon.dto.easyexcel.DemoDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 工具类
 * 使用 Alibaba 的开源项目 “EasyExcel” 对 Excel 的读写
 */
public class ExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    public static void simpleRead() {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        /**
         * 注意从 jar 包读取或者从resource读取都是一样的读取方式，需要学习一下读取文件的三种方式
         */
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取100条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, DemoDataDTO.class, new PageReadListener<DemoDataDTO>(dataList -> {
            for (DemoDataDTO demoData : dataList) {
                logger.info("读取到一条数据{}", ObjectMapperUtils.writeValueAsString(demoData));
            }
        })).sheet().doRead();
    }
}

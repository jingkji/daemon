package com.kiseki.daemon.dto.easyexcel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * EasyExcel 数据演示 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DemoDataDTO {

    /**
     * id
     */
    private String id;

    /**
     * 昵称
     */
    private String userName;

    /**
     * 密码（加密）
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;
}

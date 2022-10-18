package com.kiseki.daemon.result;

/**
 * 系统调用状态枚举值
 */
public enum ResultEnum implements IResult {
     // 数据操作错误定义
     SUCCESS(200, "成功"),

     FORBIDDEN(301,"你没得权限"),
     NO_AUTH(302,"未登录"),
     VALIDATE_FAILED(401, "参数校验失败"),
     COMMON_FAILED(403, "接口调用失败"),
     NOT_FOUND(404, "未找到该资源!"),
     INTERNAL_SERVER_ERROR(500, "服务器异常请联系管理员"),
     ;

     /**
      * 状态码
      */
     private final Integer code;

     /**
      * 状态信息
      */
     private final String message;

     ResultEnum(Integer code, String message) {
      this.code = code;
      this.message = message;
     }

     public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
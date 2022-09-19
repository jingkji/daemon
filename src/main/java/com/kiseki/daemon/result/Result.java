package com.kiseki.daemon.result;

public class Result {
 //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //数据
    private Object data;
    public Result() {

    }
    //自定义返回结果的构造方法
    public Result(Boolean success, Integer code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //自定义异常返回的结果
    public static Result defineError(BusinessException de){
     Result result = new Result();
        result.setSuccess(false);
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }
    //其他异常处理方法返回的结果
    public static Result otherError(ResultEnum resultEnum){
     Result result = new Result();
        result.setMsg(resultEnum.getErrorMsg());
        result.setCode(resultEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }
 public Boolean getSuccess() {
  return success;
 }
 public void setSuccess(Boolean success) {
  this.success = success;
 }
 public Integer getCode() {
  return code;
 }
 public void setCode(Integer code) {
  this.code = code;
 }
 public String getMsg() {
  return msg;
 }
 public void setMsg(String msg) {
  this.msg = msg;
 }
 public Object getData() {
  return data;
 }
 public void setData(Object data) {
  this.data = data;
 }
    
}
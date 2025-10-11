package com.wuwu.schedule.common;

public class Result <T>{
    private Integer code;
    private String message;
    private T date;


    public Result() {
    }

    protected static <T> Result<T> build (T date) {
        Result<T> result   = new Result<T>();
        if (date!=null)
            result.setDate(date);
        return result;
    }
    public static <T> Result<T> build (T body,Integer code,String message) {
        Result<T> result   = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static <T> Result<T> build (T body,ResultCodeEnum resultCodeEnum) {
        Result<T> result  = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMsg());
        return result;
    }

    public static <T> Result<T> ok (T date) {
        Result<T> result   = build(date);
        return build(date,ResultCodeEnum.SUCCESS);
    }
    public Result <T> message (String msg) {
        this.setMessage(msg);
        return this;
    }
    public Result <T> code (Integer code) {
        this.setCode(code);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
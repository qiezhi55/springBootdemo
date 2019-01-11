package com.example.demo.interceptor;

/**
 * Created by lj on 2017/6/2.
 */
public class ResultCode {

    private String code;

    private String message;

    public ResultCode(String code, String message) {

        this.code = code;
        this.message = message;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

}
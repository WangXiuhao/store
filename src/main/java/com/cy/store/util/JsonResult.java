package com.cy.store.util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {
//    状态码
    private Integer state;
//    描述信息
    private String message;
//    数据
    private E data;

//    构造方法，根据三个属性在不同环境下进行构造


    public JsonResult() {
    }
//    状态码
    public JsonResult(Integer state) {
        this.state = state;
    }
//  状态码和数据
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
//    异常
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

//    get和set

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}

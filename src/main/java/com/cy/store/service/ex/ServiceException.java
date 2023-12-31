package com.cy.store.service.ex;
/*  业务层异常的基类*/
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);//有信息
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);//有信息和异常的对象
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

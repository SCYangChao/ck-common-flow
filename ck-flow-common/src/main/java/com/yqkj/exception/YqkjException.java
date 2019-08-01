package com.yqkj.exception;

import lombok.Data;

/**
 *
  * class_name: YqkjException
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午11:18
  *
 **/
@Data
public class YqkjException extends java.lang.RuntimeException{

    public static    String SYS_EXCEPTION_CODE = "500";

    public  static  String BIZ_EXCEPTION_CODE = "500";

    private String msg;

    private String code;



    public YqkjException(String code , String msg ) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public YqkjException(String code , String message, Throwable cause) {
        super(message, cause);
        this.msg = message;
        this.code = code;
    }

}

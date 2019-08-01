package com.yqkj.exception;

import lombok.Data;

/**
 *
  * class_name: ParamException
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午11:36
  *
 **/
@Data
public class ParamException extends  YqkjException {
    public ParamException(String msg ) {
        super(SYS_EXCEPTION_CODE, msg);
    }
}

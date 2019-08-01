package com.yqkj.exception;

/**
 *
  * class_name: BizException
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午11:02
  *
 **/
public class BizException extends  YqkjException {
    public BizException(String msg) {
        super(BIZ_EXCEPTION_CODE, msg );
    }

    public BizException(String code, String msg) {
        super(code, msg );
    }
}

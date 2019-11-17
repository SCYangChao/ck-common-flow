package com.yqkj.exception;

import com.yqkj.flow.util.ResponseToole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
  * class_name: AdviceExceptionHandle
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午10:59
  *
 **/
@ControllerAdvice
@Slf4j
public class AdviceExceptionHandle {
    /**
     * 參數異常處理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({ParamException.class})
    public Object handleParamException(ParamException e) {
        return  new Object();
    }
    /**
     * 業務異常處理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({BizException.class})
    public Object handleBizException(BizException e) {
        return  new Object();
    }


    @ResponseBody
    @ExceptionHandler({Throwable.class})
    public Object handleThrowable(Throwable e) {

        log.info("handleThrowable:{}" ,e);
        if (e instanceof  ParamException){
            return  this.handleParamException((ParamException)e);
        }else if (e instanceof  BizException){
            return  this.handleBizException((BizException)e);
        }
        return  ResponseToole.error(500 ,"后台处理异常");
    }

}

package com.yqkj.flow.util;

import com.yqkj.client.dto.R;

/**
 *
  * class_name: ResponseToole
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午10:02
  *
 **/
public class ResponseToole {
    /**
     * 构建返回信息
     * @param t
     * @param <T>
     * @return
     */
    public  static <T> R<T> success(T t) {
        R<T> response = new R<>();
        return response.success(t);
    }

    /**
     * 构建失败返回信息
     * @param <T>
     * @return
     */
    public  static <T> R<T> error(Integer code ,String msg) {
        R<T> response = new R<>();
        return response.error(code, msg);
    }
}

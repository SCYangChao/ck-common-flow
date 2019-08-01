package com.yqkj.client.dto.request.cmd;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 *
  * class_name: DelopyRequest
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午10:05
  *
 **/
@Data
public class StartRequest implements Serializable {
    /**
     * 流程ＩＤ名称
     */
    private String flowKey;;

    private Map<String,Object> variable;

}

package com.yqkj.client.dto.request.deploy;

import lombok.Data;

import java.io.Serializable;

/**
 *
  * class_name: DelopyRequest
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午10:05
  *
 **/
@Data
public class DelopyRequest implements Serializable {
    /**
     * 系统编码
     */
    private String sysCode;
    /**
     * 流程发布名称
     */
    private String name;
    /**
     * 流程定义
     */
    private String xml;
    /**
     * 流程功能描述
     */
    private String describe;

}

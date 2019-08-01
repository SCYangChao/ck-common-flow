package com.yqkj.client.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
  * class_name: RequestContext
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:53
  *
 **/
@ApiModel
@Data
public class PageRequestContext implements Serializable {

    @ApiModelProperty("页码")
    private Integer pageNo=1;

    @ApiModelProperty("条数")
    private Integer pageSize=10;
    
}

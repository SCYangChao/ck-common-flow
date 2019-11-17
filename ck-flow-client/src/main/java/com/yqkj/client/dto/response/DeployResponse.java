package com.yqkj.client.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
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
@ApiModel
@AllArgsConstructor
public class DeployResponse implements Serializable {

   @ApiModelProperty("发布状态")
   private Boolean delpySuccess;

    @ApiModelProperty("发布提示消息")
   private String delployMsg;

    @ApiModelProperty("详情")
    private List<Map<String , Object>> dataList;

}

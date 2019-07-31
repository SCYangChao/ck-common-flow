package com.yqkj.flow.core.entity.dto;


import com.yqkj.flow.core.constants.FlowEnum;
import lombok.Data;
import org.flowable.engine.repository.Deployment;

/**
 *
  * class_name: DeployFlowContext
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
@Data
public class DeployFlowContext extends  FlowContext {

    private FlowEnum.DeployTypeEnum deployTypeEnum;

    /**
     * 流程发布名称
     */
    private String name;
    /**
     * 流程发布出错信息
     */
    private String errorMsg="未知错误";

    /**
     * 发布流程是否成功
     */
    private Boolean deploySuccess = Boolean.FALSE;
    /**
     * 流程设计器
     */
    private String xmlStr;

    /**
     * 流程发布返回
     */
    private Deployment deploymentResult;



    public DeployFlowContext(FlowEnum.DeployTypeEnum deployTypeEnum, String xmlStr) {
        this.deployTypeEnum = deployTypeEnum;
        this.xmlStr = xmlStr;
    }
}

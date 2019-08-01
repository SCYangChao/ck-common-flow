package com.yqkj.flow.entity.dto.cmd;


import com.yqkj.flow.constants.FlowEnum;
import com.yqkj.flow.entity.dto.FlowContext;
import lombok.Data;
import org.flowable.engine.impl.persistence.entity.ProcessDefinitionEntity;

import java.util.List;

/**
 *
  * class_name: CommandFlowContext
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
@Data
public class CommandFlowContext extends  FlowContext {

    private FlowEnum.DeployTypeEnum deployTypeEnum;

    /**
     * 流程发布名称
     */
    private String name;
    /**
     * 流程发布出错信息
     */
    private String errorMsg="流程发布成功";

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
    private List<ProcessDefinitionEntity> deploymentResult;



    public CommandFlowContext(FlowEnum.DeployTypeEnum deployTypeEnum, String xmlStr) {
        this.deployTypeEnum = deployTypeEnum;
        this.xmlStr = xmlStr;
    }
}

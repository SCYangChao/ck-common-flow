package com.yqkj.flow.core.cmd;


import com.yqkj.flow.autoload.IProcessEngineContext;
import com.yqkj.flow.constants.FlowEnum;
import com.yqkj.flow.core.util.DeployUtil;
import com.yqkj.flow.entity.dto.DeployFlowContext;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import lombok.extern.log4j.Log4j2;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

/**
 *
  * class_name: AbstractDeployService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
@Log4j2
public abstract class AbstractCommandService implements ICommandService {

    @Autowired
    private IProcessEngineContext iProcessEngine;

    /**
     * @param commandFlowContext
     * @return
     */
    @Override
    public Boolean cmd(CommandFlowContext commandFlowContext) {

        if (log.isDebugEnabled()) {

            log.debug("发布流程，名称：{},入参：{}" , commandFlowContext.getName(),commandFlowContext);

        }

        Boolean validate = this.validate(commandFlowContext);

        if (!validate) {

            log.info("流程验证失败 , 名称：{}",commandFlowContext.getName());

            return Boolean.FALSE;

        }


        if (log.isDebugEnabled()) {

            log.info("流程发布 , 名称：{}",commandFlowContext.getName());

        }

        Boolean excute = this.cmd(commandFlowContext);

        if (log.isDebugEnabled()) {

            log.info("流程发布结果 {}",excute);

        }

        if (!excute) {

            log.info("流程发布失败 {}",commandFlowContext.getName());

            return Boolean.FALSE;

        }

        log.info("流程发布成功 {}",commandFlowContext.getName());

        return Boolean.TRUE;
    }

    /**
     * 　验证
     * @return
     */
    public Boolean validate(CommandFlowContext commandFlowContext) {
        return  Boolean.TRUE;
    }
    /**
     * 执行流程
     * @param commandFlowContext
     * @return
     */
    public  abstract  Boolean excute(CommandFlowContext commandFlowContext);

}

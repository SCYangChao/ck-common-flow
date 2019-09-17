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
public abstract class AbstractCommandService<R> implements ICommandService {

    @Autowired
    protected IProcessEngineContext iProcessEngine;

    public final String RESULT_FLAG = "RESULT_FLAG";

    /**
     * @param commandFlowContext
     * @return
     */
    @Override
    public Boolean cmd(CommandFlowContext commandFlowContext) {

        if (log.isDebugEnabled()) {

            log.debug("执行流程：{},开始" ,commandFlowContext);

        }

        Boolean validate = this.validate(commandFlowContext);

        if (!validate) {

            log.info("执行验证流程失败 ,{}",commandFlowContext);

            return Boolean.FALSE;

        }


        if (log.isDebugEnabled()) {

            log.info("执行流程开始 , 命令为：{}",commandFlowContext.getCmdEnum());

        }

        Boolean excute = this.excute(commandFlowContext);

        if (log.isDebugEnabled()) {

            log.info("流程执行结果 {}",excute);

        }

        if (!excute) {

            log.info("流程执行失败 {}",commandFlowContext);

            return Boolean.FALSE;

        }

        log.info("流程执行成功 {}",commandFlowContext.getResult());

        return Boolean.TRUE;
    }

    /**
     * 　验证
     * @return
     */
    public Boolean validate(CommandFlowContext<R> commandFlowContext) {
        return  Boolean.TRUE;
    }
    /**
     * 执行流程
     * @param commandFlowContext
     * @return
     */
    public  abstract  Boolean excute(CommandFlowContext<R> commandFlowContext);

}

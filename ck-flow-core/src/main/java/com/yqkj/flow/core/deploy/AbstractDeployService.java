package com.yqkj.flow.core.deploy;


import com.yqkj.flow.entity.dto.DeployFlowContext;
import com.yqkj.flow.autoload.IProcessEngineContext;
import com.yqkj.flow.constants.FlowEnum;
import com.yqkj.flow.core.util.DeployUtil;
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
public abstract class AbstractDeployService implements IDeployService {

    @Autowired
    private IProcessEngineContext iProcessEngine;

    /**
     * @param flowContext
     * @return
     */
    @Override
    public Boolean deploy(DeployFlowContext flowContext) {

        if (log.isDebugEnabled()) {

            log.debug("发布流程，名称：{},入参：{}" , flowContext.getName(),flowContext);

        }

        Boolean validate = this.validate(flowContext);

        if (!validate) {

            log.info("流程验证失败 , 名称：{}",flowContext.getName());

            return Boolean.FALSE;

        }


        if (log.isDebugEnabled()) {

            log.info("流程发布 , 名称：{}",flowContext.getName());

        }

        Boolean excute = this.excute(flowContext);

        if (log.isDebugEnabled()) {

            log.info("流程发布结果 {}",excute);

        }

        if (!excute) {

            log.info("流程发布失败 {}",flowContext.getName());

            return Boolean.FALSE;

        }

        log.info("流程发布成功 {}",flowContext.getName());

        return Boolean.TRUE;
    }

    /**
     * 　验证流程设计其
     * @return
     */
    public Boolean validate(DeployFlowContext deployFlowContext) {

        if (!Objects.isNull(deployFlowContext.getDeployTypeEnum()) && FlowEnum.DeployTypeEnum.DEPLOY_STR == deployFlowContext.getDeployTypeEnum()) {
            try {
                XMLInputFactory xif = XMLInputFactory.newInstance();
                InputStreamReader in = new InputStreamReader(new ByteArrayInputStream(deployFlowContext.getXmlStr().getBytes()), "UTF-8");
                XMLStreamReader xtr = xif.createXMLStreamReader(in);
                BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);
                List<ValidationError> validationErrors = iProcessEngine.getRepositoryService().validateProcess(bpmnModel);

                if (!validationErrors.isEmpty()) {

                    deployFlowContext.setDeploySuccess(Boolean.FALSE);

                    deployFlowContext.setErrorMsg(DeployUtil.convertValidationErrorMsg(validationErrors));

                }

                return  Boolean.TRUE;

            }catch (Exception e){

                log.error("validate error:{}" , e);

            }
        }

        return Boolean.FALSE;
    }

    /**
     * 发布流程实现类
     * @param deployFlowContext
     * @return
     */
    public  abstract  Boolean excute(DeployFlowContext deployFlowContext);

}

package com.yqkj.flow.core.deploy;


import com.yqkj.flow.core.constants.FlowConstants;
import com.yqkj.flow.core.constants.FlowEnum;
import com.yqkj.flow.core.entity.dto.DeployFlowContext;
import com.yqkj.flow.core.autoload.IProcessEngineContext;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
  * class_name: StringDeployService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
@Service("deployService"+ FlowConstants.DEPLOY_STR)
public class StringDeployService extends AbstractDeployServiceService {

    @Autowired
    private IProcessEngineContext iProcessEngine;

    @Override
    Boolean excute(DeployFlowContext deployFlowContext) {

        Deployment deploy = iProcessEngine.getRepositoryService().createDeployment().
                addBytes(deployFlowContext.getName(),
                        deployFlowContext.getXmlStr().getBytes()).deploy();

        deployFlowContext.setDeploymentResult(deploy);

        return Boolean.TRUE;
    }
}

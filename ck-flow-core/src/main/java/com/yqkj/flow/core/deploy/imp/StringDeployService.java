package com.yqkj.flow.core.deploy.imp;


import com.yqkj.flow.autoload.IProcessEngineContext;
import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.deploy.AbstractDeployServiceService;
import com.yqkj.flow.entity.dto.DeployFlowContext;
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
@Service(FlowConstants.DEPLOY_PRE+ FlowConstants.DEPLOY_STR)
public class StringDeployService extends AbstractDeployServiceService {

    @Autowired
    private IProcessEngineContext iProcessEngine;

    @Override
    public  Boolean excute(DeployFlowContext deployFlowContext){

        Deployment deploy = iProcessEngine.getRepositoryService().createDeployment().
                addString(deployFlowContext.getName(),
                        deployFlowContext.getXmlStr()).deploy();

        deployFlowContext.setDeploymentResult(deploy);

        return Boolean.TRUE;
    }


}

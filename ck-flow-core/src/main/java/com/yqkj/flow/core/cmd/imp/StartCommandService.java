package com.yqkj.flow.core.cmd.imp;


import com.yqkj.flow.autoload.IProcessEngineContext;
import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.cmd.AbstractCommandService;
import com.yqkj.flow.entity.dto.DeployFlowContext;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import org.flowable.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.flowable.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
  * class_name: StartCommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
@Service(FlowConstants.DEPLOY_PRE+ "CommandFlowContext")
public class StartCommandService extends AbstractCommandService {

    @Autowired
    private IProcessEngineContext iProcessEngine;

    @Override
    public  Boolean excute(CommandFlowContext deployFlowContext){

        Deployment deploy = iProcessEngine.getRepositoryService().createDeployment().
                addString(deployFlowContext.getName(),
                        deployFlowContext.getXmlStr()).deploy();

        if (deploy instanceof DeploymentEntityImpl) {
            DeploymentEntityImpl deployEx = (DeploymentEntityImpl) deploy;
            List<ProcessDefinitionEntity> deployedArtifacts = deployEx.getDeployedArtifacts(ProcessDefinitionEntity.class);
            deployFlowContext.setDeploymentResult(deployedArtifacts);
        }

        return Boolean.TRUE;
    }


}

package com.yqkj.flow.core.deploy.imp;


import com.yqkj.flow.autoload.IProcessEngineContext;
import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.deploy.AbstractDeployService;
import com.yqkj.flow.entity.dto.DeployFlowContext;
import com.yqkj.flow.util.collection.CollectionUtil;
import org.flowable.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.flowable.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
  * class_name: StartCommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
@Service(FlowConstants.DEPLOY_PRE+ FlowConstants.DEPLOY_STR)
public class StringDeployService extends AbstractDeployService {

    @Autowired
    private IProcessEngineContext iProcessEngine;

    @Override
    public  Boolean excute(DeployFlowContext deployFlowContext){

        Deployment deploy = iProcessEngine.getRepositoryService().createDeployment().
                addString(deployFlowContext.getName(),
                        deployFlowContext.getXmlStr()).deploy();

        if (deploy instanceof DeploymentEntityImpl) {
            DeploymentEntityImpl deployEx = (DeploymentEntityImpl) deploy;
            List<ProcessDefinitionEntity> deployedArtifacts = deployEx.getDeployedArtifacts(ProcessDefinitionEntity.class);

            if(CollectionUtil.isNotNull(deployedArtifacts)) {

                List<Map<String , Object>> reuslt = new ArrayList<>();
                deployedArtifacts.forEach(deployedArtifact->{

                    Map<String , Object > map = new HashMap<>();

                    map.put("name" , deployedArtifact.getName());
                    map.put("processDefinitionKey" , deployedArtifact.getKey());

                    reuslt.add(map);

                });
                deployFlowContext.setResult(reuslt);
            }
        }

        return Boolean.TRUE;
    }


}

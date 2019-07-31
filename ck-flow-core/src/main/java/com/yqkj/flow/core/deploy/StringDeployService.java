package com.yqkj.flow.core.deploy;


import com.yqkj.flow.core.entity.dto.DeployFlowContext;
import com.yqkj.flow.core.autoload.IProcessEngineContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
  * class_name: StringDeployService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
public class StringDeployService extends AbstractDeployServiceService {

    @Autowired
    private IProcessEngineContext iProcessEngine;

    @Override
    Boolean excute(DeployFlowContext deployFlowContext) {
        return null;
    }
}

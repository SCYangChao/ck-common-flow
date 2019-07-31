package com.yqkj.flow.core.deploy;

import com.yqkj.flow.core.entity.dto.DeployFlowContext;

/**
 *
  * class_name: IDeployServiceService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
public interface IDeployServiceService {
    /**
     *
     * @param flowContext
     * @return
     */
    Boolean deploy(DeployFlowContext flowContext);
    /**
     *　验证流程设计其
     * @return
     */
    Boolean validate(DeployFlowContext deployFlowContext);
}

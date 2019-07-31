package com.yqkj.flow.core.deploy;

import com.yqkj.flow.core.entity.dto.DeployFlowContext;
import org.springframework.stereotype.Service;

/**
 *
  * class_name: IDeployServiceService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
@Service("defaultDeployServiceService")
public class DefaultDeployServiceService implements IDeployServiceService  {
    /**
     * @param flowContext
     * @return
     */
    @Override
    public Boolean deploy(DeployFlowContext flowContext) {
        return null;
    }
}

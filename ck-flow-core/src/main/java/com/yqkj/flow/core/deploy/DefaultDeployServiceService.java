package com.yqkj.flow.core.deploy;

import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.entity.dto.DeployFlowContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
  * class_name: IDeployServiceService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
@Service(value = "defaultDeployServiceService")
@Log4j2
public class DefaultDeployServiceService implements IDeployServiceService ,ApplicationContextAware {

    /**
     * 处理发布ServiceService
     */
    private Map<String , IDeployServiceService> deployServiceService = new HashMap<>(10);

    /**
     * @param flowContext
     * @return
     */
    @Override
    public Boolean deploy(DeployFlowContext flowContext) {

        if (log.isDebugEnabled()) {

            log.info("流程发布开始{},");

        }

        String serviceKey = FlowConstants.DEPLOY_PRE + flowContext.getDeployTypeEnum();
        IDeployServiceService iDeployServiceService = deployServiceService.get(serviceKey);

        if (Objects.isNull(iDeployServiceService)) {

            log.error("iDeployServiceService bean null,service name:{}", serviceKey);

            flowContext.setDeploySuccess(Boolean.FALSE);

            flowContext.setErrorMsg("流程发布策略出错，流程引擎内部错误");

            return  Boolean.FALSE;

        }

        Boolean deploy = iDeployServiceService.deploy(flowContext);

        if (log.isDebugEnabled()) {

            log.error("flow excute {} result:{}", serviceKey,deploy);

        }

        if (!deploy) {

            flowContext.setDeploySuccess(Boolean.FALSE);
            flowContext.setErrorMsg("流程发布失败");

        }

        return Boolean.TRUE;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Map<String, AbstractDeployServiceService> beansOfType = applicationContext.getBeansOfType(AbstractDeployServiceService.class);

        if (!Objects.isNull(beansOfType) && !beansOfType.isEmpty()) {

            deployServiceService.putAll(beansOfType);

        }

    }
}

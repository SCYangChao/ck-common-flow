package com.yqkj.flow.autoload;


import org.flowable.engine.*;

/**
 *  流程引擎
  * class_name: IProcessEngineContext
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午5:24
  *
 **/
public interface IProcessEngineContext {
    /**
     * 获取流程引擎执行服务
     *
     * @return
     */
    ProcessEngine getProcessEngine();

    /**
     * 获取流程引擎管理
     *
     * @return
     */
    RepositoryService getRepositoryService();

    /**
     * 流程运行时信息
     * @return
     */
    RuntimeService getRuntimeService();

    /**
     * 流程表单
     * @return
     */
    FormService getFormService();

    /**
     * 任务管理
     * @return
     */
    TaskService getTaskService();

    /**
     * 流程历史数据
     * @return
     */
    HistoryService getHistoryService();

    /**
     * 流程认证
     * @return
     */
    IdentityService getIdentityService();

    /**
     * 流程管理
     * @return
     */
    ManagementService getManagementService();

    /**
     *
     * @return
     */
    DynamicBpmnService getDynamicBpmnService();
}

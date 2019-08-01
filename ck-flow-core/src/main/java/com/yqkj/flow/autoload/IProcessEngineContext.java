package com.yqkj.flow.autoload;


import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;

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
}

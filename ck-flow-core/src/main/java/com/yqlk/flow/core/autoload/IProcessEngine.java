package com.yqlk.flow.core.autoload;


import org.flowable.engine.ProcessEngine;

/**
 *  流程引擎
  * class_name: IProcessEngine
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午5:24
  *
 **/
public interface IProcessEngine {
    /**
     * 获取流程引擎执行服务
     * @return
     */
    ProcessEngine getProcessEngine();
}

package com.yqkj.flow.constants;

/**
 *
  * class_name: FlowConstants
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:46
  *
 **/
public interface FlowConstants {
    /**
     *
     */
    String CMD_VERSION_1_0 = "流程命令-V1.0";
    /**
     * 发布
     */
    String DEPLOY_PRE = "deployService";
    /**
     * 流程命令前缀
     */
    String COMMAND_PRE = "commandService";
    /**
     * 流程开始
     */
    String FLOW_START = "start";
    /**
     * 任务查询
     */
    String FLOW_QUERY_TASK = "query_task";
    /**
     * 任务下一步
     */
    String FLOW_COMPILE = "compile";

    /**
     * 任务结束
     */
    String FLOW_END_TASK = "end_task";

    /**
     * 字符串方式发布发布
     */
    String DEPLOY_STR="DEPLOY_STR";
    /**
     * 流程图
     */
    String FLOW_BPMN = "bpmn";

}

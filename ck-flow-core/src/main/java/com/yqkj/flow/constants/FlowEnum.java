package com.yqkj.flow.constants;


/**
 * 枚举
  * class_name: FlowEnum
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:46
  *
 **/
public interface FlowEnum {

    /**
     * 流程执行命令查询
     */
    enum  FlowCmdEnum implements FlowEnum {
        START(FlowConstants.FLOW_START , "流程开始"),NEXT("next" , "流程下一步执行"),END("end","终止流程"),FINISH("finish","流程结束");

        private String vlue;

        private String msg;

        FlowCmdEnum(String vlue , String msg) {
            this.vlue=vlue;
            this.msg=msg;
        }

        public String getVlue() {
            return vlue;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 发布流程设计类型
     */
    enum  DeployTypeEnum implements  FlowEnum {

        DEPLOY_STR,DEPLOY_STREAM;

    }

}

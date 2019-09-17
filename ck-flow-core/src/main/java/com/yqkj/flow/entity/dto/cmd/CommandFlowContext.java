package com.yqkj.flow.entity.dto.cmd;


import com.yqkj.flow.constants.FlowEnum;
import com.yqkj.flow.entity.dto.FlowContext;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.impl.persistence.entity.ProcessDefinitionEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
  * class_name: CommandFlowContext
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
@Data
public class CommandFlowContext<R> extends  FlowContext {

    private FlowEnum.FlowCmdEnum cmdEnum;

    /**
     * 流程名称关键字
     */
    private String flowKey;

    /**
     *流程ＴａｓｋＩＤ
     */
    private String taskId;
    /**
     * 流程数据
     */
    private Map<String,Object> variable;

    private String msg;

    private Boolean success = Boolean.TRUE;
    /**
     * 返回值
     */
    private Map<String , R> result = new HashMap<>(3);

    public  void addResult(String key , R v) {

        if (StringUtils.isNotBlank(key)) {

            result.put(key, v);

        }

    }
}

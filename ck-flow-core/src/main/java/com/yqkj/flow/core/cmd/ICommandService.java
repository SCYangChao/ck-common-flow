package com.yqkj.flow.core.cmd;

import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;

/**
 *
  * class_name: ICommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:30
  *
 **/
public interface ICommandService {
    /**
     *
     * @param flowContext
     * @return
     */
    Boolean cmd(CommandFlowContext flowContext);

}

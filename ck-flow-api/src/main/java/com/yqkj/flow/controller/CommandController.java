package com.yqkj.flow.controller;

import com.yqkj.client.dto.R;
import com.yqkj.client.dto.request.cmd.StartRequest;
import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.constants.FlowEnum;
import com.yqkj.flow.core.cmd.ICommandService;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import com.yqkj.flow.entity.dto.file.UploadFileResponse;
import com.yqkj.flow.util.ResponseToole;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
  * class_name: CommonController
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午11:33
  *
 **/
@RestController
@RequestMapping("/flow/v1.0/command")
public class CommandController {

    @Autowired
    @Qualifier("commandService")
    private ICommandService iCommandService;

    
    /**
     *
      * describe: 流程开始
      * @author: yangchao.cool@gmail.com
      * creat_date: 下午5:52
      *
     **/
    @PostMapping(value = "/start")
    @ApiOperation(value = "开始" , tags = FlowConstants.CMD_VERSION_1_0)
    public R<Map<String , Object>> start(@RequestBody  StartRequest startRequest) {
        CommandFlowContext result= new CommandFlowContext();
        result.setFlowKey(startRequest.getFlowKey());
        result.setVariable(startRequest.getVariable());
        result.setCmdEnum(FlowEnum.FlowCmdEnum.START);
        iCommandService.cmd(result);
        return ResponseToole.success(result.getResult());
    }
    /**
     *
     * describe: 流程开始
     * @author: yangchao.cool@gmail.com
     * creat_date: 下午5:52
     *
     **/
    @PostMapping(value = "/queryTask")
    @ApiOperation(value = "任务查询" , tags = FlowConstants.CMD_VERSION_1_0)
    public R<Map<String , Object>> queryTask(@RequestBody  StartRequest startRequest) {
        CommandFlowContext result= new CommandFlowContext();
        result.setCmdEnum(FlowEnum.FlowCmdEnum.QUERY_TASK);
        iCommandService.cmd(result);
        return ResponseToole.success(result.getResult());
    }
}

package com.yqkj.flow.controller;


import com.yqkj.client.dto.R;
import com.yqkj.client.dto.request.deploy.DelopyRequest;
import com.yqkj.client.dto.response.DeployResponse;
import com.yqkj.flow.constants.FlowEnum;
import com.yqkj.flow.core.deploy.IDeployService;
import com.yqkj.flow.entity.dto.DeployFlowContext;
import com.yqkj.flow.util.ResponseToole;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
  * class_name: DeployController
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午11:28
  *
 **/
@RestController
@RequestMapping("/flow/v1.0/deploy")
public class DeployController {

    @Autowired
    @Qualifier(value = "defaultDeployService")
    private IDeployService deployServiceService;

    @PostMapping(value = "/deployFile",consumes = "multipartFile/*",headers = "content-type=multipart/form-data")
    @ApiOperation(value = "流程发布－单个文件上传" , tags = "流程设计发布-V1.0")
    public R<DeployResponse>  upload(@ApiParam(value = "上传的文件", required = true) MultipartFile file, HttpServletRequest request) throws IOException {
        DeployFlowContext deployFlowContext = new DeployFlowContext(FlowEnum.DeployTypeEnum.DEPLOY_STR,
                new String(file.getBytes()));
        deployFlowContext.setName(file.getOriginalFilename());
        Boolean deploy = deployServiceService.deploy(deployFlowContext);
        return  ResponseToole.success(new DeployResponse(deploy,deployFlowContext.getErrorMsg()));
    }
    /**
     *
      * describe: 流程设计发布到系统
      * @author: yangchao.cool@gmail.com
      * creat_date: 上午10:26
      *
     **/
    @ApiOperation(value = "流程设计发布(字符串)", tags = "流程设计发布-V1.0")
    @RequestMapping(value = "/deployStr" , method =RequestMethod.POST)
    public R<DeployResponse>  deployStr(@RequestBody DelopyRequest delpyRequest) {
        DeployFlowContext deployFlowContext = new DeployFlowContext(FlowEnum.DeployTypeEnum.DEPLOY_STR,
                delpyRequest.getXml());
        Boolean deploy = deployServiceService.deploy(deployFlowContext);
        return  ResponseToole.success(new DeployResponse(deploy,deployFlowContext.getErrorMsg()));
    }


}

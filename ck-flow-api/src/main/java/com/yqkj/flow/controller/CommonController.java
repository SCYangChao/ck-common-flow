package com.yqkj.flow.controller;

import com.yqkj.client.dto.R;
import com.yqkj.flow.entity.dto.file.UploadFileResponse;
import com.yqkj.flow.util.ResponseToole;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 *
  * class_name: CommonController
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午11:33
  *
 **/
@RestController
@RequestMapping("/flow/v1.0/common")
public class CommonController {


    @PostMapping(value = "/upload",consumes = "multipartFile/*",headers = "content-type=multipart/form-data")
    @ApiOperation(value = "文件上传" , tags = "文件上传-V1.0")
    public R<UploadFileResponse> upload(@ApiParam(value = "上传的文件", required = true) MultipartFile file, HttpServletRequest request) {
        UploadFileResponse result= new UploadFileResponse();
        return ResponseToole.success(result);
    }

}

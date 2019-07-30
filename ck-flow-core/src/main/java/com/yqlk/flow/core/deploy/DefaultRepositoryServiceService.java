package com.yqlk.flow.core.deploy;


import com.yqlk.flow.core.autoload.IProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.zip.ZipInputStream;

/**
 *
  * class_name: DefaultRepositoryServiceService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
public class DefaultRepositoryServiceService implements IRepositoryServiceService {

    @Autowired
    private IProcessEngine iProcessEngine;

    @Override
    public  Boolean deployZipInputStream(String name, ZipInputStream zipInputStream){
        return Boolean.FALSE;
    }

    @Override
    public  Boolean deployStr(String name,String bpmXml){
        this.iProcessEngine.getProcessEngine().getRepositoryService().
                createDeployment().addBytes(name, bpmXml.getBytes()).deploy();
        return Boolean.FALSE;
    }

}

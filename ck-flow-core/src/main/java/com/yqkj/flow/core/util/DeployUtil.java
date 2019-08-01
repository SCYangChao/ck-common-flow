package com.yqkj.flow.core.util;

import com.yqkj.flow.collection.CollectionUtil;
import org.flowable.validation.ValidationError;

import java.util.List;

/**
 *
  * class_name: DeployUtil
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午9:57
  *
 **/
public class DeployUtil {

    
    /**
     *
      * class_name: DeployUtil
      * describe: 流程验证错误信息整合
      * @author: yangchao.cool@gmail.com
      * creat_date: 上午10:10
      *
     **/
    public static   String convertValidationErrorMsg(List<ValidationError> validationErrors) {
        StringBuilder sb = new StringBuilder();
        if (CollectionUtil.isNotNull(validationErrors)) {

            validationErrors.forEach(o ->{
                sb.append(o.getProblem()).append(",");
            });

        }

        return sb.toString();
    }

}

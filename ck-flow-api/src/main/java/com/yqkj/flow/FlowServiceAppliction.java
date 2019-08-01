package com.yqkj.flow;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
  * class_name: FlowServiceAppliction
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午4:47
  *
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.yqkj.flow","com.yqkj.exception"})
public class FlowServiceAppliction {

    public  static  void main(String[] arg) {
        SpringApplication.run(FlowServiceAppliction.class);

    }

}

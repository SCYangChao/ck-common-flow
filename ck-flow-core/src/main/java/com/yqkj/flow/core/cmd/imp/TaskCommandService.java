package com.yqkj.flow.core.cmd.imp;


import com.yqkj.flow.constants.FlowConstants;
import com.yqkj.flow.core.cmd.AbstractCommandService;
import com.yqkj.flow.entity.dto.cmd.CommandFlowContext;
import org.apache.commons.io.FileUtils;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Process;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.image.impl.DefaultProcessDiagramGenerator;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
  * class_name: StartCommandService
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:14
  *
 **/
@Service(FlowConstants.COMMAND_PRE+FlowConstants.FLOW_TASK)
public class TaskCommandService extends AbstractCommandService<Object> {

    @Override
    public  Boolean excute(CommandFlowContext<Object> deployFlowContext){
        BpmnModel bpmnModel = this.iProcessEngine.getRepositoryService().getBpmnModel(deployFlowContext.getFlowKey());
        DefaultProcessDiagramGenerator defaultProcessDiagramGenerator = new     DefaultProcessDiagramGenerator();

        List<Process> processes = bpmnModel.getProcesses();
        processes.forEach(process -> {
            Map<String, FlowElement> flowElementMap = process.getFlowElementMap();
            flowElementMap.forEach((k,v)->{
                System.out.println("k:{},v:{}"+k+v);
            });
        });
        //设置需要标注高亮的节点
        List<String> highLightedActivitis = new ArrayList<String>();
        /**
         * 获得活动的节点
         */

        List<HistoricActivityInstance> highLightedActivitList =  this.iProcessEngine.getHistoryService().createHistoricActivityInstanceQuery().processInstanceId(deployFlowContext.getTaskId()).orderByHistoricActivityInstanceStartTime().asc().list();

        List<String> flows = new ArrayList<>();

        for(HistoricActivityInstance tempActivity : highLightedActivitList){
            String activityId = tempActivity.getActivityId();

            highLightedActivitis.add(activityId);
            flows.add(tempActivity.getId());
        }



        InputStream inputStream = defaultProcessDiagramGenerator.generateDiagram(bpmnModel, "jpg", highLightedActivitis,flows,"宋体" , "宋体","宋体",null,1D,false);

        try {
            FileUtils.writeByteArrayToFile(new File("D:/p/" + System.currentTimeMillis() + ".jpg") , readInputStream(inputStream));
        }catch (Exception e){
            e.printStackTrace();
        }

        deployFlowContext.addResult(this.RESULT_FLAG, Boolean.TRUE);
        return Boolean.TRUE;
    }

    public  byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }



}

package com.yqkj.flow.autoload;

import com.yqkj.flow.config.MysqlProcessEngineConfiguration;
import com.yqkj.flow.core.umps.FlowIdmIdentityService;
import com.yqkj.flow.core.umps.group.FlowGroupQuery;
import com.yqkj.flow.core.umps.user.FlowUserQuery;
import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.idm.api.IdmIdentityService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 *
  * class_name: MysqlProcessEngine
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午5:28
  *
 **/
@Component
@ConditionalOnBean(MysqlProcessEngineConfiguration.class)
public class MysqlProcessEngine implements IProcessEngineContext,InitializingBean {

    @Autowired
    private MysqlProcessEngineConfiguration mysqlProcessEngineConfiguration;


    private FlowIdmIdentityService  idmIdentityService;

    private RepositoryService repositoryService;

    private ProcessEngine processEngine;

    @Autowired
    private FlowUserQuery flowUserQuery;

    @Autowired
    private FlowGroupQuery flowGroupQuery;
    /**
     * 获取流程引擎执行服务
     *
     * @return
     */
    @Override
    public ProcessEngine getProcessEngine() {
        return this.processEngine;
    }

    @Override
    public RepositoryService getRepositoryService() {
        return this.repositoryService;
    }
    /**
     * 流程运行时信息
     *
     * @return
     */
    @Override
    public RuntimeService getRuntimeService() {
        return processEngine.getRuntimeService();
    }

    /**
     * 流程表单
     *
     * @return
     */
    @Override
    public FormService getFormService() {
        return processEngine.getFormService();
    }

    /**
     * 任务管理
     *
     * @return
     */
    @Override
    public TaskService getTaskService() {
        return processEngine.getTaskService();
    }

    /**
     * 流程历史数据
     *
     * @return
     */
    @Override
    public HistoryService getHistoryService() {
        return processEngine.getHistoryService();
    }

    /**
     * 流程认证
     *
     * @return
     */
    @Override
    public IdentityService getIdentityService() {
        return idmIdentityService;
    }

    /**
     * 流程管理
     *
     * @return
     */
    @Override
    public ManagementService getManagementService() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public DynamicBpmnService getDynamicBpmnService() {
        return processEngine.getDynamicBpmnService();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl(mysqlProcessEngineConfiguration.getJdbcUrl())
                .setJdbcUsername(mysqlProcessEngineConfiguration.getUserName())
                .setJdbcPassword(mysqlProcessEngineConfiguration.getPassword())
                .setJdbcDriver(mysqlProcessEngineConfiguration.getJdbcDriver())
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        this.idmIdentityService = new FlowIdmIdentityService((ProcessEngineConfigurationImpl)cfg);
        idmIdentityService.setGroupQuery(flowGroupQuery);
        idmIdentityService.setUserQuery(flowUserQuery);

        this.processEngine= cfg.buildProcessEngine();
        this.repositoryService=this.processEngine.getRepositoryService();

    }
}

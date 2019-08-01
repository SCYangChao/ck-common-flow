package com.yqkj.flow.autoload;

import com.yqkj.flow.config.MysqlProcessEngineConfiguration;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
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


    private RepositoryService repositoryService;

    private ProcessEngine processEngine;
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

    @Override
    public void afterPropertiesSet() throws Exception {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl(mysqlProcessEngineConfiguration.getJdbcUrl())
                .setJdbcUsername(mysqlProcessEngineConfiguration.getUserName())
                .setJdbcPassword(mysqlProcessEngineConfiguration.getPassword())
                .setJdbcDriver(mysqlProcessEngineConfiguration.getJdbcDriver())
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);
        this.processEngine= cfg.buildProcessEngine();
        this.repositoryService=this.processEngine.getRepositoryService();
    }
}

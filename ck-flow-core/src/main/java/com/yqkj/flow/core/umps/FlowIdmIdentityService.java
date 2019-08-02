package com.yqkj.flow.core.umps;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.flowable.engine.impl.IdentityServiceImpl;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.api.UserQuery;

@Log4j2
@Setter
public class FlowIdmIdentityService extends IdentityServiceImpl {
    /**
     * 用户查询
     */
    private UserQuery userQuery;
    /**
     *用户组
     */
    private GroupQuery groupQuery;

    public FlowIdmIdentityService(ProcessEngineConfigurationImpl processEngineConfiguration) {
        super(processEngineConfiguration);
    }

    @Override
    public UserQuery createUserQuery() {
        return super.createUserQuery();
    }

    @Override
    public GroupQuery createGroupQuery() {
        return super.createGroupQuery();
    }


}

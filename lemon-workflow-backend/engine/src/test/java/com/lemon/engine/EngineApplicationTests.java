package com.lemon.engine;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.HistoryService;
import org.flowable.engine.IdentityService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootTest
class EngineApplicationTests {

    @Resource
    private IdentityService identityService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private RepositoryService repositoryService;
    @Resource
    private HistoryService historyService;

    @Test
    void contextLoads() {

    }

    /**
     * 停止所有流程实例
     */
    @Test
    void stopAllIns() {
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        for(ProcessInstance processInstance : list) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      /*Delete an existing runtime process instance.
            Parameters:
            processInstanceId - id of process instance to delete, cannot be null.
                    deleteReason - reason for deleting, can be null.*/
            runtimeService.deleteProcessInstance(processInstance.getId(), "demoDeleteReason");
        }
    }

    /**
     * 删除所有已完成的流程实例 释放task附加属性和文件
     */
    @Test
    void deleteAllHistoricProcessIns() {
        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().list();
        for(HistoricProcessInstance processInstance : list) {
            if(processInstance.getEndTime()!=null){
                String processId = processInstance.getId();
                List<HistoricTaskInstance> taskList = historyService.createHistoricTaskInstanceQuery().processInstanceId(processId).list();
                //判断当前process的部署中的流程定义是否还存在
                ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                                                        .processDefinitionId(processInstance
                                                        .getProcessDefinitionId())
                                                        .singleResult();
                for (HistoricTaskInstance task : taskList){
                    String taskId = task.getId();
                    historyService.deleteHistoricTaskInstance(taskId);
//                    technologyServiceService.deleteCustomAttributes(taskId);
//                    fileTransferExecutor.deleteDirectory("result/"+taskId);
                    // 如果当前process的部署Deployment不存在且没有其他使用相同合同文档和需求文档的task 则删除task中的合同和需求文档
                    HistoricTaskInstance sameKeyTask =  historyService.createHistoricTaskInstanceQuery().taskDefinitionKey(task.getTaskDefinitionKey()).singleResult();
                    if (sameKeyTask == null && processDefinition == null){
//                        fileTransferExecutor.deleteDirectory("service/"+task.getTaskDefinitionKey());
                    }
                }
                historyService.deleteHistoricProcessInstance(processId);
            }
        }
    }

    /**
     * 删除所有部署
     */
    @Test
    void deleteAllDeployFile() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition:  list) {
            repositoryService.deleteDeployment(processDefinition.getId());
        }
    }

    /**
     * 用于初始化用户组和用户
     */
    @Test
    void addAllUser() {
        addUserAndGroup("admin", "test", "Administrator");
    }
    private void addUserAndGroup(String userName, String userPass, String groupName) {
        String userId = UUID.randomUUID().toString();
        User user = identityService.newUser(userId);
        user.setFirstName(userName);
        user.setPassword(userPass);
        identityService.saveUser(user);

        String groupId = UUID.randomUUID().toString();
        Group group = identityService.newGroup(groupId);
        group.setName(groupName);
        identityService.saveGroup(group);

        identityService.createMembership(user.getId(), group.getId());

    }



    /**
     * 在用户组下添加用户
     * @param userName
     * @param userPass
     * @param groupName
     */
    private void addUserInGroup(String userName, String userPass, String groupName) {
        String userId = UUID.randomUUID().toString();
        User user = identityService.newUser(userId);
        user.setFirstName(userName);
        user.setPassword(userPass);
        identityService.saveUser(user);

        Group group = identityService.createGroupQuery().groupName(groupName).singleResult();

        identityService.createMembership(user.getId(), group.getId());
    }

}

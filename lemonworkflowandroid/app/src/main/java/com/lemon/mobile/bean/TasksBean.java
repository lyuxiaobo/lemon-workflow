package com.lemon.mobile.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lyubo
 * @date 2021/8/9
 * Description:
 */
public class TasksBean {

    /**
     * data : [{"id":"0ce326cc-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/0ce326cc-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:46.705+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"0ce326c8-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/0ce326c8-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"0ce2ffb7-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/0ce2ffb7-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"0dc01954-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/0dc01954-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:48.153+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"0dbfcb30-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/0dbfcb30-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"0dbfcb2f-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/0dbfcb2f-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"0e5fdbcc-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/0e5fdbcc-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:49.200+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"0e5fb4b8-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/0e5fb4b8-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"0e5f8da7-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/0e5f8da7-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"0ee9cc54-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/0ee9cc54-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:50.104+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"0ee9a540-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/0ee9a540-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"0ee9a53f-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/0ee9a53f-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"0fa3a67c-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/0fa3a67c-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:51.322+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"0fa37f68-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/0fa37f68-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"0fa37f67-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/0fa37f67-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"116ec994-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/116ec994-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:54.330+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"116ea280-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/116ea280-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"116e7b6f-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/116e7b6f-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"11f29f9c-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/11f29f9c-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:55.195+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"11f29f98-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/11f29f98-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"11f27887-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/11f27887-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"12b3a5b4-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/12b3a5b4-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:56.460+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"12b35790-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/12b35790-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"12b3578f-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/12b3578f-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"1349a42c-f8ee-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/1349a42c-f8ee-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:44:57.443+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"13497d18-f8ee-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/13497d18-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceId":"13497d17-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/13497d17-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]},{"id":"d024c444-f8ed-11eb-a2e6-184f32c7c4a7","url":"http://192.168.1.108:8081/process-api/runtime/tasks/d024c444-f8ed-11eb-a2e6-184f32c7c4a7","owner":null,"assignee":"admin","delegationState":null,"name":"测试的用户任务","description":null,"createTime":"2021-08-09T16:43:04.761+08:00","dueDate":null,"priority":50,"suspended":false,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null,"formKey":null,"parentTaskId":null,"parentTaskUrl":null,"executionId":"d01e82b0-f8ed-11eb-a2e6-184f32c7c4a7","executionUrl":"http://192.168.1.108:8081/process-api/runtime/executions/d01e82b0-f8ed-11eb-a2e6-184f32c7c4a7","processInstanceId":"d01e5b9f-f8ed-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.108:8081/process-api/runtime/process-instances/d01e5b9f-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","variables":[]}]
     * total : 12
     * start : 0
     * sort : id
     * order : asc
     * size : 10
     */

    private int total;
    private int start;
    private String sort;
    private String order;
    private int size;
    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 0ce326cc-f8ee-11eb-a2e6-184f32c7c4a7
         * url : http://192.168.1.108:8081/process-api/runtime/tasks/0ce326cc-f8ee-11eb-a2e6-184f32c7c4a7
         * owner : null
         * assignee : admin
         * delegationState : null
         * name : 测试的用户任务
         * description : null
         * createTime : 2021-08-09T16:44:46.705+08:00
         * dueDate : null
         * priority : 50
         * suspended : false
         * claimTime : null
         * taskDefinitionKey : Activity_0oiyca2
         * scopeDefinitionId : null
         * scopeId : null
         * scopeType : null
         * tenantId :
         * category : null
         * formKey : null
         * parentTaskId : null
         * parentTaskUrl : null
         * executionId : 0ce326c8-f8ee-11eb-a2e6-184f32c7c4a7
         * executionUrl : http://192.168.1.108:8081/process-api/runtime/executions/0ce326c8-f8ee-11eb-a2e6-184f32c7c4a7
         * processInstanceId : 0ce2ffb7-f8ee-11eb-a2e6-184f32c7c4a7
         * processInstanceUrl : http://192.168.1.108:8081/process-api/runtime/process-instances/0ce2ffb7-f8ee-11eb-a2e6-184f32c7c4a7
         * processDefinitionId : cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7
         * processDefinitionUrl : http://192.168.1.108:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7
         * variables : []
         */

        private String id;
        private String url;
        private Object owner;
        private String assignee;
        private Object delegationState;
        private String name;
        private Object description;
        private String createTime;
        private Object dueDate;
        private int priority;
        private boolean suspended;
        private Object claimTime;
        private String taskDefinitionKey;
        private Object scopeDefinitionId;
        private Object scopeId;
        private Object scopeType;
        private String tenantId;
        private Object category;
        private Object formKey;
        private Object parentTaskId;
        private Object parentTaskUrl;
        private String executionId;
        private String executionUrl;
        private String processInstanceId;
        private String processInstanceUrl;
        private String processDefinitionId;
        private String processDefinitionUrl;
        private List<?> variables;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getOwner() {
            return owner;
        }

        public void setOwner(Object owner) {
            this.owner = owner;
        }

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

        public Object getDelegationState() {
            return delegationState;
        }

        public void setDelegationState(Object delegationState) {
            this.delegationState = delegationState;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getDueDate() {
            return dueDate;
        }

        public void setDueDate(Object dueDate) {
            this.dueDate = dueDate;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public boolean isSuspended() {
            return suspended;
        }

        public void setSuspended(boolean suspended) {
            this.suspended = suspended;
        }

        public Object getClaimTime() {
            return claimTime;
        }

        public void setClaimTime(Object claimTime) {
            this.claimTime = claimTime;
        }

        public String getTaskDefinitionKey() {
            return taskDefinitionKey;
        }

        public void setTaskDefinitionKey(String taskDefinitionKey) {
            this.taskDefinitionKey = taskDefinitionKey;
        }

        public Object getScopeDefinitionId() {
            return scopeDefinitionId;
        }

        public void setScopeDefinitionId(Object scopeDefinitionId) {
            this.scopeDefinitionId = scopeDefinitionId;
        }

        public Object getScopeId() {
            return scopeId;
        }

        public void setScopeId(Object scopeId) {
            this.scopeId = scopeId;
        }

        public Object getScopeType() {
            return scopeType;
        }

        public void setScopeType(Object scopeType) {
            this.scopeType = scopeType;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public Object getCategory() {
            return category;
        }

        public void setCategory(Object category) {
            this.category = category;
        }

        public Object getFormKey() {
            return formKey;
        }

        public void setFormKey(Object formKey) {
            this.formKey = formKey;
        }

        public Object getParentTaskId() {
            return parentTaskId;
        }

        public void setParentTaskId(Object parentTaskId) {
            this.parentTaskId = parentTaskId;
        }

        public Object getParentTaskUrl() {
            return parentTaskUrl;
        }

        public void setParentTaskUrl(Object parentTaskUrl) {
            this.parentTaskUrl = parentTaskUrl;
        }

        public String getExecutionId() {
            return executionId;
        }

        public void setExecutionId(String executionId) {
            this.executionId = executionId;
        }

        public String getExecutionUrl() {
            return executionUrl;
        }

        public void setExecutionUrl(String executionUrl) {
            this.executionUrl = executionUrl;
        }

        public String getProcessInstanceId() {
            return processInstanceId;
        }

        public void setProcessInstanceId(String processInstanceId) {
            this.processInstanceId = processInstanceId;
        }

        public String getProcessInstanceUrl() {
            return processInstanceUrl;
        }

        public void setProcessInstanceUrl(String processInstanceUrl) {
            this.processInstanceUrl = processInstanceUrl;
        }

        public String getProcessDefinitionId() {
            return processDefinitionId;
        }

        public void setProcessDefinitionId(String processDefinitionId) {
            this.processDefinitionId = processDefinitionId;
        }

        public String getProcessDefinitionUrl() {
            return processDefinitionUrl;
        }

        public void setProcessDefinitionUrl(String processDefinitionUrl) {
            this.processDefinitionUrl = processDefinitionUrl;
        }

        public List<?> getVariables() {
            return variables;
        }

        public void setVariables(List<?> variables) {
            this.variables = variables;
        }
    }
}

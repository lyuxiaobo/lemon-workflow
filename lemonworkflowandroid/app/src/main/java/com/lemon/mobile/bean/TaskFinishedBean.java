package com.lemon.mobile.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lyubo
 * @date 2021/8/9
 * Description:
 */
public class TaskFinishedBean {

    /**
     * data : [{"id":"0ce326cc-f8ee-11eb-a2e6-184f32c7c4a7","processDefinitionId":"cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processDefinitionUrl":"http://192.168.1.12:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7","processInstanceId":"0ce2ffb7-f8ee-11eb-a2e6-184f32c7c4a7","processInstanceUrl":"http://192.168.1.12:8081/process-api/history/historic-process-instances/0ce2ffb7-f8ee-11eb-a2e6-184f32c7c4a7","executionId":"0ce326c8-f8ee-11eb-a2e6-184f32c7c4a7","name":"测试的用户任务","description":null,"deleteReason":null,"owner":null,"assignee":"admin","startTime":"2021-08-09T16:44:46.705+08:00","endTime":"2021-08-09T20:21:07.777+08:00","durationInMillis":12981072,"workTimeInMillis":null,"claimTime":null,"taskDefinitionKey":"Activity_0oiyca2","formKey":null,"priority":50,"dueDate":null,"parentTaskId":null,"url":"http://192.168.1.12:8081/process-api/history/historic-task-instances/0ce326cc-f8ee-11eb-a2e6-184f32c7c4a7","variables":[],"scopeDefinitionId":null,"scopeId":null,"scopeType":null,"tenantId":"","category":null}]
     * total : 1
     * start : 0
     * sort : taskInstanceId
     * order : asc
     * size : 1
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
         * processDefinitionId : cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7
         * processDefinitionUrl : http://192.168.1.12:8081/process-api/repository/process-definitions/cc5126fe-f8ed-11eb-a2e6-184f32c7c4a7
         * processInstanceId : 0ce2ffb7-f8ee-11eb-a2e6-184f32c7c4a7
         * processInstanceUrl : http://192.168.1.12:8081/process-api/history/historic-process-instances/0ce2ffb7-f8ee-11eb-a2e6-184f32c7c4a7
         * executionId : 0ce326c8-f8ee-11eb-a2e6-184f32c7c4a7
         * name : 测试的用户任务
         * description : null
         * deleteReason : null
         * owner : null
         * assignee : admin
         * startTime : 2021-08-09T16:44:46.705+08:00
         * endTime : 2021-08-09T20:21:07.777+08:00
         * durationInMillis : 12981072
         * workTimeInMillis : null
         * claimTime : null
         * taskDefinitionKey : Activity_0oiyca2
         * formKey : null
         * priority : 50
         * dueDate : null
         * parentTaskId : null
         * url : http://192.168.1.12:8081/process-api/history/historic-task-instances/0ce326cc-f8ee-11eb-a2e6-184f32c7c4a7
         * variables : []
         * scopeDefinitionId : null
         * scopeId : null
         * scopeType : null
         * tenantId :
         * category : null
         */

        private String id;
        private String processDefinitionId;
        private String processDefinitionUrl;
        private String processInstanceId;
        private String processInstanceUrl;
        private String executionId;
        private String name;
        private Object description;
        private Object deleteReason;
        private Object owner;
        private String assignee;
        private String startTime;
        private String endTime;
        private int durationInMillis;
        private Object workTimeInMillis;
        private Object claimTime;
        private String taskDefinitionKey;
        private Object formKey;
        private int priority;
        private Object dueDate;
        private Object parentTaskId;
        private String url;
        private Object scopeDefinitionId;
        private Object scopeId;
        private Object scopeType;
        private String tenantId;
        private Object category;
        private List<?> variables;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getExecutionId() {
            return executionId;
        }

        public void setExecutionId(String executionId) {
            this.executionId = executionId;
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

        public Object getDeleteReason() {
            return deleteReason;
        }

        public void setDeleteReason(Object deleteReason) {
            this.deleteReason = deleteReason;
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

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getDurationInMillis() {
            return durationInMillis;
        }

        public void setDurationInMillis(int durationInMillis) {
            this.durationInMillis = durationInMillis;
        }

        public Object getWorkTimeInMillis() {
            return workTimeInMillis;
        }

        public void setWorkTimeInMillis(Object workTimeInMillis) {
            this.workTimeInMillis = workTimeInMillis;
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

        public Object getFormKey() {
            return formKey;
        }

        public void setFormKey(Object formKey) {
            this.formKey = formKey;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Object getDueDate() {
            return dueDate;
        }

        public void setDueDate(Object dueDate) {
            this.dueDate = dueDate;
        }

        public Object getParentTaskId() {
            return parentTaskId;
        }

        public void setParentTaskId(Object parentTaskId) {
            this.parentTaskId = parentTaskId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public List<?> getVariables() {
            return variables;
        }

        public void setVariables(List<?> variables) {
            this.variables = variables;
        }
    }
}

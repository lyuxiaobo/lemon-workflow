import request from '../utils/request';
// 示例
export const fetchData = query => {
    return request({
        url: 'http://localhost:8080/table.json',
        method: 'get',
        params: query
    });
};


//登录
export const requestLogin = param => {
    return request({
        url: '/login' + param,
        method: 'post'
    });
};

// /////////////////////////////////////////////
// 系统管理
// 用户管理
export const getAllUsers = (size, start) => {
    return request({
        url: `/process-api/identity/users?&size=${size}&start=${start}`,
        method: 'get'
    });
};
// Add a user
export const addUser = (params) => {
    return request({
        url: `/process-api/identity/users`,
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        data: params
    });
};
// 获取单个用户信息
export const getOneUser = (userId) => {
    return request({
        url: `/process-api/identity/users/${userId}`,
        method: 'get'
    });
};
// 根据用户名去查询某个用户
export const searchOneUser = (username) => {
    return request({
        url: `/process-api/identity/users?firstName=${username}`,
        method: 'get'
    });
};
//删除单个用户
export const deleteOneUser = (userId) => {
    return request({
        url: `/process-api/identity/users/${userId}`,
        method: 'delete'
    });
};

// 用户组管理
export const addGroup = (params) => {
    return request({
        url: `/process-api/identity/groups`,
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        data: params
    });
};
export const getAllGroups = (size, start) => {
    return request({
        url: `/process-api/identity/groups?&size=${size}&start=${start}`,
        method: 'get'
    });
};
export const searchOneGroup = (groupId) => {
    return request({
        url: `/process-api/identity/group/${groupId}`,
        method: 'get'
    });
};
export const deleteOneGroup = (groupId) => {
    return request({
        url: `/process-api/identity/groups/${groupId}`,
        method: 'delete'
    });
};
export const updateGroup = (groupId, params) => {
    return request({
        url: `/process-api/identity/groups/${groupId}`,
        method: 'put',
        headers: {
            'Content-Type': 'application/json'
        },
        data: params
    });
};
// Add a member to a group
export const addMemberToGroup = (groupId, params) => {
    return request({
        url: `/process-api/identity/groups/${groupId}/members`,
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        data: params
    });
};

// //////////////////////////////////////////////////
// 我的办公
// 代办任务
export const getTasks = (size, start, assignee) => {
    return request({
        url: `/process-api/runtime/tasks?assignee=${assignee}&size=${size}&start=${start}`,
        method: 'get'
    });
};
export const completeTask = (taskId, taskRequestBody) => {
    return request({
        url: `/process-api/runtime/tasks/${taskId}`,
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        data: taskRequestBody
    });
};

// 已完成任务，根据历史任务中的durationInMillis来判断（或者结束时间）
export const getHistoryTasks = (size, start, assignee) => {
    return request({
        url: `/process-api/history/historic-task-instances?assignee=${assignee}&size=${size}&start=${start}&finished=true`,
        method: 'get'
    });
};


// //////////////////////////////////////////////////
// 工作流管理
// 模型
export const getAllModels = (size, start) => {
    return request({
        url: `/process-api/repository/models?&size=${size}&start=${start}`,
        method: 'get'
    });
};
export const deleteModel = (modelId) => {
    return request({
        url: `/process-api/repository/models/${modelId}`,
        method: 'delete'
    });
};
export const addModel = (params) => {
    return request({
        url: `/process-api/repository/models`,
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        data: params
    });
};
// 模型部署
export const createDeployment = (file) => {
    const forms = new FormData();
    forms.append('file', file);
    return request({
        url: '/process-api/repository/deployments',
        method: 'post',
        data: forms,
        headers: { 'Content-Type': 'multipart/form-data' }
    });
};
// 保存流程文件(Set the editor source for a model)
export const setTheEditorSource = (modelId, file) => {
    const forms = new FormData();
    forms.append('file', file);
    return request({
        url: `/process-api/repository/models/${modelId}/source`,
        method: 'put',
        data: forms,
        headers: { 'Content-Type': 'multipart/form-data' }
    });
};
// 获取流程文件
export const getTheEditorSource = (modelId) => {
    return request({
        url: `/process-api/repository/models/${modelId}/source`,
        method: 'get',
    });
};


// 部署相关的接口
export const getAllDeployments = (size, start) => {
    return request({
        url: `/process-api/repository/deployments?&size=${size}&start=${start}`,
        method: 'get'
    });
};
// 删除一条部署
export const deleteOneDeployment = (deploymentId) => {
    return request({
        url: `/process-api/repository/deployments/${deploymentId}`,
        method: 'delete'
    });
};


//获取流程定义
export const getAllDefs = (size, start) => {
    return request({
        url: `/process-api/repository/process-definitions?&size=${size}&start=${start}`,
        method: 'get'
    });
};
export const searchDefs = (size, start, name) => {
    return request({
        url: `/process-api/repository/process-definitions?&size=${size}&start=${start}&nameLike=${name}`,
        method: 'get'
    });
};
// Start a process instance
export const startInstance = (params) => {
    return request({
        url: `/process-api/runtime/process-instances`,
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        data: params
    });
};



// 获取全部流程实例
export const getAllProIns = (size, start) => {
    return request({
        url: `/process-api/runtime/process-instances?&size=${size}&start=${start}`,
        method: 'get'
    });
};
// 删除一个流程实例
export const deleteProIns = param => {
    return request({
        url: `/process-api/runtime/process-instances/${param}`,
        method: 'delete'
    });
};

import axios from 'axios';
// 导入 NProgress 包对应的JS
import NProgress from 'nprogress'

const service = axios.create({
    //process.env.NODE_ENV === 'development' 来判断是否开发环境

    baseURL: 'http://localhost:8081',
    timeout: 5000
});

service.interceptors.request.use(
    config => {
        NProgress.start()
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

service.interceptors.response.use(
    response => {
        NProgress.done()
        // 204：Delete a deployment - Response codes
        if (response.status === 200 || response.status === 204 || response.status === 201) {
            return response.data;
        } else {
            Promise.reject();
        }
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

export default service;

import axios from 'axios';
// 这里把IP单独导入是为了可以在vue文件也可以引入
import baseURL from './ip'

const noTransitionRequest = axios.create({
    //process.env.NODE_ENV === 'development' 来判断是否开发环境
    baseURL: baseURL,
    // baseURL: 'http://10.5.83.149:8083',
    timeout: 5000
});

noTransitionRequest.interceptors.request.use(
    config => {
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

noTransitionRequest.interceptors.response.use(
    response => {
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

export default noTransitionRequest;

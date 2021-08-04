import axios from 'axios';
import NProgress from 'nprogress'

/**
 * 请求服务库的Axios实例
 * @author lyubo
 * @type {AxiosInstance}
 */
const serviceLibrary = axios.create({
    baseURL: 'http://10.61.4.20:8099',
    timeout: 5000
});

serviceLibrary.interceptors.request.use(
    config => {
        NProgress.start()
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

serviceLibrary.interceptors.response.use(
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

export default serviceLibrary;

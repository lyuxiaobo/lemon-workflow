import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from 'element-ui';
import VueI18n from 'vue-i18n';
import VueEditor from 'vue2-editor'

import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
// import './assets/css/theme-bule/index.css';
import './assets/css/icon.css';
import './components/common/directives';
import 'babel-polyfill';

import { vuePlugin } from '@/highlight';
import 'highlight.js/styles/atom-one-dark-reasonable.css';
Vue.use(vuePlugin);

import MyPD from '../package/index.js';
Vue.use(MyPD);


import '../package/theme/index.scss';

import 'bpmn-js/dist/assets/diagram-js.css';
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn.css';
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn-codes.css';

// 导入 NProgress 包的CSS
import 'nprogress/nprogress.css';


import 'element-ui/lib/theme-chalk/index.css'


Vue.use(VueI18n)

Vue.use(VueEditor)

Vue.config.lang = 'zh-CN'

Vue.config.productionTip = false;

Vue.use(ElementUI, {
    size: 'small'
});


import FormMaking from './index'
Vue.use(FormMaking)

//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title} | lemon-workflow`;
    const role = localStorage.getItem('ms_username');
    if (!role && to.path !== '/login') {
        next('/login');
    } else if (to.meta.permission) {
        // 如果是管理员权限则可进入，这里只是简单的模拟管理员权限而已
        role === 'admin' ? next() : next('/403');
    } else if (role && to.path === '/') {
        next('/dashboard');
    } else {
        next();
    }
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');

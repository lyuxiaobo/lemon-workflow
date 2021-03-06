import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: '登录' }
        },
        {
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: { title: '自述文件' },
            children: [

                {
                    path: '/dashboard',
                    component: () => import( '../components/page/Dashboard'),
                    meta: { title: '首页' }
                },
                {
                    path: '/system/user-mgr',
                    component: () => import( '../components/system/UserMgr'),
                    meta: { title: '用户管理' }
                },
                {
                    path: '/system/group-mgr',
                    component: () => import( '../components/system/GroupMgr'),
                    meta: { title: '用户组管理' }
                },
                {
                    path: '/office/done',
                    component: () => import( '../components/office/TasksDone'),
                    meta: { title: '已办任务' }
                },
                {
                    path: '/office/todo',
                    component: () => import( '../components/office/TasksTodo'),
                    meta: { title: '待办任务' }
                },
                {
                    path: '/workflow/models',
                    component: () => import( '../components/workflow/Process'),
                    meta: { title: '模型' }
                },
                {
                    path: '/workflow/design',
                    component: () => import( '../components/workflow/ProcessModelDesign'),
                    meta: { title: '模型设计' }
                },
                {
                    path: '/workflow/deployment',
                    component: () => import( '../components/workflow/Deployment'),
                    meta: { title: '部署' }
                },
                {
                    path: '/workflow/def',
                    component: () => import( '../components/workflow/Definition'),
                    meta: { title: '定义' }
                },
                {
                    path: '/workflow/ins',
                    component: () => import( '../components/workflow/Instance'),
                    meta: { title: '实例' }
                },

                {
                    path: '/form/overview',
                    component: () => import( '../components/workflow/Forms'),
                    meta: { title: '表单' }
                },
                {
                    path: '/form/design',
                    component: () => import( '../components/workflow/FormDesigner'),
                    meta: { title: '表单设计' }
                },
                {
                    path: '/demo/table',
                    name: 'basetable',
                    meta: {
                        title: '表格'
                    },
                    component: () => import ('../components/page/BaseTable')
                }, {
                    path: '/charts',
                    name: 'basecharts',
                    meta: {
                        title: '图表'
                    },
                    component: () => import (
                        /* webpackChunkName: "charts" */
                        '../components/page/BaseCharts.vue')
                }, {
                    path: '/demo/form',
                    name: 'baseform',
                    meta: {
                        title: '表单'
                    },
                    component: () => import (
                        /* webpackChunkName: "form" */
                        '../components/page/BaseForm.vue')
                }, {
                    path: '/demo/tabs',
                    name: 'tabs',
                    meta: {
                        title: 'tab标签'
                    },
                    component: () => import (
                        /* webpackChunkName: "tabs" */
                        '../components/page/Tabs.vue')
                }, {
                    path: '/donate',
                    name: 'donate',
                    meta: {
                        title: '鼓励作者'
                    },
                    component: () => import (
                        /* webpackChunkName: "donate" */
                        '../components/page/Donate.vue')
                },
                {
                    // 富文本编辑器组件
                    path: '/demo/editor',
                    component: () => import(/* webpackChunkName: "editor" */ '../components/page/VueEditor.vue'),
                    meta: { title: '富文本编辑器' }
                },
                {
                    // markdown组件
                    path: '/demo/markdown',
                    component: () => import(/* webpackChunkName: "markdown" */ '../components/page/Markdown.vue'),
                    meta: { title: 'markdown编辑器' }
                },
                {
                    // 拖拽列表组件
                    path: '/demo/drag',
                    component: () => import(/* webpackChunkName: "drag" */ '../components/page/DragList.vue'),
                    meta: { title: '拖拽列表' }
                },
                {
                    // 拖拽Dialog组件
                    path: '/demo/dialog',
                    component: () => import(/* webpackChunkName: "dragdialog" */ '../components/page/DragDialog.vue'),
                    meta: { title: '拖拽弹框' }
                },
                {
                    path: '/demo/permission',
                    name: 'permission',
                    meta: {
                        title: '权限管理',
                        permission: true
                    },
                    component: () => import (
                        /* webpackChunkName: "permission" */
                        '../components/page/Permission.vue')
                },
                {
                    path: '/Upload',
                    name: 'upload',
                    meta: {
                        title: '上传插件'
                    },
                    component: () => import (
                        /* webpackChunkName: "Upload" */
                        '../components/page/Upload.vue')
                }, {
                    path: '/demo/icon',
                    name: 'icon',
                    meta: {
                        title: '自定义图标'
                    },
                    component: () => import (
                        /* webpackChunkName: "icon" */
                        '../components/page/Icon.vue')
                },
                // 其他界面
                {
                    path: '/tabs',
                    component: () => import(/* webpackChunkName: "tabs" */ '../components/page/Tabs.vue'),
                    meta: { title: '消息' }
                },
                {
                    path: '/demo/404',
                    component: () => import(/* webpackChunkName: "404" */ '../components/page/404.vue'),
                    meta: { title: '404' }
                },
                {
                    path: '/403',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/403.vue'),
                    meta: { title: '403' }
                }
            ]
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
});

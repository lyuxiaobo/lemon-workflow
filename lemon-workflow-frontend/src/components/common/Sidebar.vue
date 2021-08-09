<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            active-text-color="#409EFF"
            router
        >
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu
                                v-if="subItem.subs"
                                :index="subItem.index"
                                :key="subItem.index"
                            >
                                <template slot="title">{{ subItem.title }}</template>
                                <el-menu-item
                                    v-for="(threeItem,i) in subItem.subs"
                                    :key="i"
                                    :index="threeItem.index"
                                >{{ threeItem.title }}
                                </el-menu-item>
                            </el-submenu>
                            <el-menu-item
                                v-else
                                :index="subItem.index"
                                :key="subItem.index"
                            >{{ subItem.title }}
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from '../common/bus';

export default {
    data() {
        return {
            collapse: false,
            items: [
                {
                    'icon': 'el-icon-s-home',
                    'index': '/dashboard',
                    'title': '首页'
                },
                {
                    'icon': 'el-icon-s-management',
                    'index': 'system',
                    'title': '系统管理',
                    'subs': [
                        {
                            'index': '/system/user-mgr',
                            'title': '用户管理'
                        },
                        {
                            'index': '/system/group-mgr',
                            'title': '用户组管理'
                        }
                    ]
                },
                {
                    'icon': 'el-icon-data-line',
                    'index': 'office',
                    'title': '我的办公',
                    'subs': [
                        {
                            'index': '/office/done',
                            'title': '已办任务'
                        },
                        {
                            'index': '/office/todo',
                            'title': '待办任务'
                        }
                    ]
                },
                {
                    'icon': 'el-icon-s-open',
                    'index': 'workflow',
                    'title': '工作流管理',
                    'subs': [
                        {
                            'index': '/workflow/models',
                            'title': '模型'
                        },
                        {
                            'index': '/workflow/deployment',
                            'title': '部署'
                        },
                        {
                            'index': '/workflow/def',
                            'title': '定义'
                        },
                        {
                            'index': '/workflow/ins',
                            'title': '实例'
                        }
                    ]
                },
                {
                    'icon': 'el-icon-lx-cascades',
                    'index': 'demo',
                    'title': '模板实例',
                    'subs': [
                        {
                            index: '/demo/table',
                            title: '基础表格'
                        },
                        {
                            index: '/demo/tabs',
                            title: 'tab选项卡'
                        },
                        {
                            index: '/demo/form',
                            title: '基本表单'
                        },
                        {
                            index: '/demo/editor',
                            title: '富文本编辑器'
                        },
                        {
                            index: '/demo/markdown',
                            title: 'markdown编辑器'
                        },

                        {
                            icon: 'el-icon-lx-emoji',
                            index: '/demo/icon',
                            title: '自定义图标'
                        },
                        {
                            index: '/demo/drag',
                            title: '拖拽列表'
                        },
                        {
                            index: '/demo/dialog',
                            title: '拖拽弹框'
                        },
                        {
                            icon: 'el-icon-lx-global',
                            index: '/demo/i18n',
                            title: '国际化功能'
                        },
                        {
                            icon: 'el-icon-lx-warn',
                            index: '7',
                            title: '错误处理',
                            subs: [
                                {
                                    index: '/demo/permission',
                                    title: '权限测试'
                                },
                                {
                                    index: '/demo/404',
                                    title: '404页面'
                                }
                            ]
                        }
                    ]
                }
            ]
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path;
        }
    },
    created: function() {
        // 通过 Event Bus 进行组件间通信，来折叠侧边栏
        bus.$on('collapse', msg => {
            this.collapse = msg;
            bus.$emit('collapse-content', msg);
        });
    },
    mounted() {

    },
    methods: {}
};
</script>

<style scoped>

.sidebar {

    display: block;
    position: absolute;
    left: 0;
    top: 63px;
    bottom: 0;
    overflow-y: scroll;
}

.sidebar::-webkit-scrollbar {
    width: 0;
}

.sidebar-el-menu:not(.el-menu--collapse) {
    width: 200px;
}

.sidebar > ul {
    height: 100%;
}
</style>

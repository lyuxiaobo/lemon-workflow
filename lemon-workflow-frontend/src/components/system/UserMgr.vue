<template>
    <div>
        <div class="container">
            <div class="handle-box">
                <el-input prefix-icon="el-icon-search" v-model="queryConditions.username" placeholder="用户名称"
                          class="handle-input mr10" clearable></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button type="primary" icon="el-icon-add" @click="handleAdd">添加用户</el-button>
            </div>
            <el-table
                :data="tableData"
                border
                stripe
                class="table"
                max-height="610"
                ref="multipleTable"
                header-cell-class-name="table -header"
            >
                <el-table-column prop="id" label="用户ID" align="center" sortable></el-table-column>
                <el-table-column prop="firstName" label="用户名称" align="center" sortable></el-table-column>
                <el-table-column prop="email" label="邮箱" align="center" sortable></el-table-column>
                <el-table-column label="操作" width="450" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-info"
                            @click="getDetailInfo(scope.row.id)"
                        >详情
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #F56C6C"
                            icon="el-icon-delete"
                            @click="deleteUser(scope.row.id)"
                        >删除用户
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    layout="total, sizes, prev, pager, next"
                    :current-page="pageInfo.pageIndex"
                    :page-sizes="[5, 10, 20]"
                    :page-size="pageInfo.pageSize"
                    :total="pageInfo.total"
                    @current-change="handlePageChange"
                    @size-change="handleSizeChange"
                ></el-pagination>
            </div>

            <!-- 弹出框 -->
            <el-dialog title="添加用户" :visible.sync="addDataVisible" width="30%">
                <el-form :model="userForm" :rules="rules" label-position="top" ref="userForm">
                    <el-form-item
                        label="用户名称"
                        prop="firstName"
                    >
                        <el-input v-model="userForm.firstName"></el-input>
                    </el-form-item>
                    <el-form-item
                        label="邮箱"
                        prop="email"
                    >
                        <el-input v-model="userForm.email"></el-input>
                    </el-form-item>
                    <el-form-item
                        label="密码"
                        prop="password"
                    >
                        <el-input v-model="userForm.password"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="addData()">保存表单</el-button>
                </span>
            </el-dialog>

            <!-- 详情弹出框 -->
            <el-dialog title="用户信息" :visible.sync="detailDataVisible" width="30%">
                <el-form ref="detailDataForm" :model="userDetailData" label-width="100px">
                    <el-form-item label="用户ID:">
                        <span>{{ userDetailData.id }}</span>
                    </el-form-item>
                    <el-form-item label="用户名:">
                        <span>{{ userDetailData.firstName }}</span>
                    </el-form-item>
                    <el-form-item label="url:">
                        <span>{{ userDetailData.url }}</span>
                    </el-form-item>
                    <el-form-item label="email:">
                        <span>{{ userDetailData.email }}</span>
                    </el-form-item>
                </el-form>
            </el-dialog>
        </div>
    </div>
</template>

<script>


import { addUser, deleteOneUser, getAllUsers, getOneUser, searchOneUser } from '@/api';
import bus from '@/components/common/bus';

export default {
    name: 'UserMgr',
    components: {},
    data() {
        return {
            //保存分页信息
            pageInfo: {
                pageIndex: 1,
                pageSize: 10,
                total: 0,
                start: 0
            },
            //保存表格上方保存多选栏和输入栏设置的查询条件
            queryConditions: {
                username: ''
            },
            //表格显示的数据
            tableData: [],
            addDataVisible: false,
            detailDataVisible: false,
            userDetailData: {},
            userForm: {
                id: '',
                firstName: '',
                email: '',
                password: ''
            },
            // 表单的校验规则
            rules: {
                firstName: [
                    { required: true, message: '请输入用户名称', trigger: 'blur' }
                ],
                email: [
                    { required: true, message: '请输入Email', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入用户密码', trigger: 'blur' }
                ]
            }
        };
    },
    created() {
        this.getData();
    },
    mounted() {
        bus.$on('getProDefData', this.getData);
    },
    methods: {
        // 获取数据
        getData() {
            getAllUsers(this.pageInfo.pageSize, this.pageInfo.start).then(res => {
                this.tableData = res.data;
                this.pageInfo.total = res.total;
            });
        },
        // 搜索
        handleSearch() {
            if (this.queryConditions.username === "") {
                this.getData()
            }else {
                searchOneUser(this.queryConditions.username).then(res => {
                    this.tableData = res.data;
                    this.pageInfo.total = res.total;
                })
            }
        },
        handleAdd() {
            this.addDataVisible = true;
            this.$nextTick(() => {
                this.$refs['userForm'].resetFields();
            });
        },
        // 分页导航 - 不同页面的点击事件
        handlePageChange(val) {
            this.$set(this.pageInfo, 'pageIndex', val);
            this.$set(this.pageInfo, 'start', this.pageInfo.pageSize * (val - 1));
            this.getData();
        },
        // 每页数量设置
        handleSizeChange(val) {
            this.$set(this.pageInfo, 'pageSize', val);
            this.$set(this.pageInfo, 'pageIndex', 1);
            this.getData();
        },
        // 保存表单
        addData() {
            this.$refs['userForm'].validate((valid) => {
                if (valid) {
                    this.userForm.id = this.guid();
                    addUser(this.userForm).then(res => {
                        this.$message.success('添加成功');
                        this.getData();
                        this.addDataVisible = false;
                    });
                }
            });
        },
        getDetailInfo(userId) {
            getOneUser(userId).then(res => {
                this.detailDataVisible = true;
                this.userDetailData = res;
            });
        },
        deleteUser(userId) {
            deleteOneUser(userId).then(res => {
                this.$message.success('已删除');
                this.getData();
            });
        },
        guid() {
            return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                var r = Math.random() * 16 | 0,
                    v = c == 'x' ? r : (r & 0x3 | 0x8);
                return v.toString(16);
            });
        }
    }
};
</script>

<style scoped>

.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}

.table {
    width: 100%;
    font-size: 14px;
}

.mr10 {
    margin-right: 10px;
}

</style>

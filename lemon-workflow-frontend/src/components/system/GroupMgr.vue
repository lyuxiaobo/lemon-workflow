<template>
    <div>
        <div class="container">
            <div class="handle-box">
                <el-input prefix-icon="el-icon-search" v-model="queryConditions.username" placeholder="用户组名称"
                          class="handle-input mr10" clearable></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button type="primary" icon="el-icon-add" @click="handleAdd">添加用户组</el-button>
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
                <el-table-column prop="id" label="用户组ID" align="center" sortable></el-table-column>
                <el-table-column prop="name" label="名称" align="center" sortable></el-table-column>
                <el-table-column prop="type" label="类型" align="center" sortable></el-table-column>
                <el-table-column label="操作" width="450" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="editGroup(scope.row)"
                        >编辑
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #F56C6C"
                            icon="el-icon-delete"
                            @click="deleteGroup(scope.row.id)"
                        >删除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    layout="total, sizes, prev, pager, next, jumper"
                    :current-page="pageInfo.pageIndex"
                    :page-sizes="[5, 10, 20]"
                    :page-size="pageInfo.pageSize"
                    :total="pageInfo.total"
                    @current-change="handlePageChange"
                    @size-change="handleSizeChange"
                ></el-pagination>
            </div>

            <!-- 添加弹出框 -->
            <el-dialog title="添加用户组" :visible.sync="addDataVisible" width="30%">
                <el-form :model="groupForm" :rules="rules" label-position="top" ref="groupForm">
                    <el-form-item
                        label="用户组名称"
                        prop="name"
                    >
                        <el-input v-model="groupForm.name" tabindex="1"></el-input>
                    </el-form-item>
                    <el-form-item
                        label="类型"
                        prop="type"
                    >
                        <el-input v-model="groupForm.type"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="addData()">保存表单</el-button>
                </span>
            </el-dialog>
            <!-- 修改弹出框 -->
            <el-dialog title="修改用户组" :visible.sync="editDataVisible" width="30%">
                <el-form :model="editGroupForm" :rules="rules" label-position="top" >
                    <el-form-item
                        label="用户组名称"
                        prop="name"
                    >
                        <el-input v-model="editGroupForm.name"></el-input>
                    </el-form-item>
                    <el-form-item
                        label="类型"
                        prop="type"
                    >
                        <el-input v-model="editGroupForm.type"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="editData()">修改表单</el-button>
                </span>
            </el-dialog>

        </div>
    </div>
</template>

<script>


import { addGroup, deleteOneGroup, getAllGroups, updateGroup } from '@/api';
import bus from '@/components/common/bus';

export default {
    name: 'GroupMgr',
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
            editDataVisible: false,
            groupForm: {
                id: '',
                name: '',
                type: ''
            },
            editGroupForm: {

            },
            // 表单的校验规则
            rules: {
                name: [
                    { required: true, message: '请输入用户名', trigger: 'blur' }
                ],
                type: [
                    { required: true, message: '请输入类型', trigger: 'blur' }
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
            getAllGroups(this.pageInfo.pageSize, this.pageInfo.start).then(res => {
                this.tableData = res.data;
                this.pageInfo.total = res.total;
            });
        },
        // 搜索
        handleSearch() {
            if (this.queryConditions.username === '') {
                this.getData();
            } else {

            }
        },
        handleAdd() {
            this.addDataVisible = true;
            this.$nextTick(() => {
                this.$refs['groupForm'].resetFields();
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
            this.$refs['groupForm'].validate((valid) => {
                if (valid) {
                    this.groupForm.id = this.generateUUID();
                    addGroup(this.groupForm).then(res => {
                        this.$message.success('添加成功');
                        this.getData();
                        this.addDataVisible = false;
                    });
                }
            });
        },
        editGroup(row) {
            this.editDataVisible = true;
            this.editGroupForm = row;
        },
        editData() {
            updateGroup(this.editGroupForm.id, this.editGroupForm).then(res => {
                this.$message.success('修改成功');
                this.getData();
            });
            this.editDataVisible = false;
        },
        deleteGroup(id) {
            deleteOneGroup(id).then(res => {
                this.$message.success('已删除');
                this.getData();
            });
        },
        // 生成uuid随机数
        generateUUID() {
            return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                const r = Math.random() * 16 | 0,
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

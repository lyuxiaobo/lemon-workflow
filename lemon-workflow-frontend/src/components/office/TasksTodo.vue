<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 待办任务
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-select v-model="queryConditions.status" placeholder="按条件筛选" class="handle-select mr10">
                    <el-option v-for="(value,key,index) in statusCodeTextDic" :key="index" :label="value"
                               :value="key"></el-option>
                </el-select>
                <el-input v-model="query.name" placeholder="名称" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                header-cell-class-name="table-header"
            >
                <!--                <el-table-column type="selection" width="55" align="center"></el-table-column>-->
                <el-table-column prop="processDefinitionId" label="流程定义" align="center" sortable></el-table-column>
                <el-table-column prop="processInstanceId" label="流程实例" align="center" sortable></el-table-column>
                <el-table-column prop="name" label="任务名称" align="center" sortable></el-table-column>
                <el-table-column prop="createTime" label="开始时间" align="center" sortable
                                 :formatter="formatDate"></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-info"
                            @click="showDetailInfo(scope.row)"
                        >详情
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-circle-check"
                            @click="completeTask(scope.row)"
                        >通过
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-s-promotion"
                            @click="delegateTask(scope.row)"
                        >委托
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    layout="total, sizes, prev, pager, next, jumper"
                    :current-page="query.pageIndex"
                    :page-sizes="[5, 10, 20]"
                    :page-size="query.pageSize"
                    :total="pageTotal"
                    @current-change="handlePageChange"
                    @size-change="handleSizeChange"
                ></el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
import { completeTask, getTasks } from '@/api';
import { formatDate } from '@/utils/formatDate';

/**
 * 已完成任务列表
 */
export default {
    name: 'TasksToDo',
    data() {
        return {
            query: {
                name: '',
                pageIndex: 1,
                pageSize: 10,
                start: 0
            },
            //保存表格上方保存多选栏和输入栏设置的查询条件
            queryConditions: {
                name: ''
            },
            statusCodeTextDic: { '1': '任务名称' },
            formEditVisible: false,
            tableData: [],
            editForm: {},
            pageTotal: 0,
            taskRequestBody: {
                action: 'complete'
            }
        };
    },
    created() {
        this.getData();
    },
    methods: {
        // 获取数据
        getData() {
            getTasks(this.query.pageSize, this.query.start, localStorage.getItem('ms_username')).then(res => {
                this.tableData = res.data;
                this.pageTotal = res.total;
            }).catch(error => {
                console.log(error);
            });
        },
        // 触发搜索按钮
        handleSearch() {
            this.getData();
        },
        showDetailInfo(row) {
            this.$message.info(`正在开发`);
        },
        completeTask(row) {
            completeTask(row.id, this.taskRequestBody).then(res => {
                this.$message.success(`已完成任务`);
                this.getData();
            }).catch(error => {
                console.log(error);
            });
        },
        delegateTask(row) {
            this.$message.info(`正在开发`);
        },

        // 分页导航
        handlePageChange(val) {
            this.$set(this.query, 'pageIndex', val);
            this.$set(this.query, 'start', this.query.pageSize * (val - 1));
            this.getData();
        },
        // 每页数量设置
        handleSizeChange(val) {
            this.$set(this.query, 'pageSize', val);
            this.$set(this.query, 'pageIndex', 1);
            this.getData();
        },
        formatDate(row, column, cellValue, index) {
            return formatDate(cellValue)
        }
    },
    mounted() {
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

.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>

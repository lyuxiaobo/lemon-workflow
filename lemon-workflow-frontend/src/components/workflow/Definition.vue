<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 定义
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-input v-model="queryConditions.name" placeholder="定义名称" class="handle-input mr10"
                          clearable></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                header-cell-class-name="table-header"
            >
                <el-table-column prop="id" label="ID" align="center" sortable></el-table-column>
                <el-table-column prop="name" label="名称" align="center" sortable></el-table-column>
                <el-table-column prop="version" width="200" label="版本" align="center" sortable
                                 :formatter="formatVersionField"></el-table-column>
                <el-table-column prop="key" label="Key" align="center" sortable></el-table-column>
                <el-table-column prop="tenantId" label="租户" align="center" sortable></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-view"
                            @click="showDef(scope.row)"
                        >预览
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-video-pause"
                            @click="suspendDef(scope.row)"
                        >挂起
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-video-play"
                            @click="activateDef(scope.row)"
                        >激活
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-s-promotion"
                            @click="startInstance(scope.row)"
                        >发起
                        </el-button>
                    </template>
                </el-table-column>

            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    layout="total, sizes, prev, pager, next"
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
import { getAllDefs, searchDefs, startInstance } from '../../api/index';

/**
 * 部署列表
 */
export default {
    name: 'ProcessDef',
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
            tableData: [],
            pageTotal: 0,
            defRequestBody: {
                processDefinitionId: ''
            }
        };
    },
    created() {
        this.getData();
    },
    methods: {
        // 获取数据
        getData() {
            getAllDefs(this.query.pageSize, this.query.start).then(res => {
                this.tableData = res.data;
                this.pageTotal = res.total || 10;
            }).catch(error => {
                console.log(error);
            });
        },
        //格式化字段
        formatSuspendedField(row, column, cellValue, index) {
            return cellValue ? '是' : '否';
        },
        formatVersionField(row, column, cellValue, index) {
            return 'v' + cellValue;
        },
        // 触发搜索按钮
        handleSearch() {
            if (this.queryConditions.name === '') {
                this.getData();
            } else {
                searchDefs(this.query.pageSize, this.query.start, this.query.name).then(res => {
                    this.tableData = res.data;
                    this.pageTotal = res.total || 10;
                }).catch(error => {
                    console.log(error);
                });
            }

        },

        // 多选操作
        handleSelectionChange(val) {
            this.multipleSelection = val;
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
        showDef(row) {
            console.log('showDef');
            this.$message.info(`正在开发`);

        },
        suspendDef(row) {
            this.$message.info(`正在开发`);

        },
        activateDef(row) {
            console.log('activeDef');
            this.$message.info(`正在开发`);
        },
        startInstance(row) {
            this.defRequestBody.processDefinitionId = row.id;
            startInstance(this.defRequestBody).then(res => {
                this.$message.success(`发起成功`);
            }).catch(error => {
                console.log(error);
            });
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

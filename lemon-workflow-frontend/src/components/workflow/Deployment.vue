<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 部署
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">

            <el-table
                :data="tableData"
                border
                class="table"
                header-cell-class-name="table-header"
            >
                <!--                <el-table-column type="selection" width="55" align="center"></el-table-column>-->
                <el-table-column prop="id" label="ID" align="center" width="300"></el-table-column>
                <el-table-column prop="name" label="名称" align="center" sortable></el-table-column>
                <el-table-column prop="deploymentTime" label="部署时间" align="center" sortable
                                 :formatter="formatDate"></el-table-column>
                <el-table-column prop="category" label="分类" align="center" sortable></el-table-column>
                <el-table-column prop="tenantId" label="租户" align="center" sortable></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            style="color: #F56C6C"
                            icon="el-icon-delete"
                            @click="deleteDeployment(scope.row.id)"
                        >删除
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
        <el-dialog title="详情页" :visible.sync="detailDataVisible" width="35%">
            <el-form :model="detailDeploymentInfo" label-position="top" ref="detailForm">
                <el-form-item
                    label="部署ID"
                >
                    <el-input v-model="detailDeploymentInfo.id"></el-input>
                </el-form-item>

            </el-form>
        </el-dialog>

    </div>
</template>

<script>
import { deleteOneDeployment, getAllDeployments } from '@/api';
import { formatDate } from '@/utils/formatDate';

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
            detailDeploymentInfo: {},
            detailDataVisible: false,

            tableData: [],
            pageTotal: 0
        };
    },
    created() {
        this.getData();
    },
    methods: {
        // 获取数据
        getData() {
            getAllDeployments(this.query.pageSize, this.query.start).then(res => {
                this.tableData = res.data;
                this.pageTotal = res.total;
            }).catch(error => {
                console.log(error);
            });
        },
        // 删除。如果此部署bpmn文件有正在运行的实例，则删除报错。待修复
        deleteDeployment(deploymentId) {
            deleteOneDeployment(deploymentId).then(res => {
                this.$message.error('已删除');
                this.getData();
            }).catch(error => {
                console.log(error);
            });
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

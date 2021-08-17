<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 表单模型管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-input prefix-icon="el-icon-search" v-model="queryConditions.username" placeholder="表单名称"
                          class="handle-input mr10" clearable></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button type="primary" icon="el-icon-add" @click="handleAdd">添加表单</el-button>
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                header-cell-class-name="table-header"
            >
                <!--                <el-table-column type="selection" width="55" align="center"></el-table-column>-->
                <el-table-column prop="name" label="表单名称" align="center" width="300"></el-table-column>
                <el-table-column prop="category" label="目录" align="center" sortable></el-table-column>
                <el-table-column prop="version" label="版本" align="center" sortable></el-table-column>
                <el-table-column prop="createTime" label="创建时间" align="center" sortable
                                 :formatter="formatDate"></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-edit"
                            @click="editModel(scope.row)"
                        >编辑
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #67C23A"
                            icon="el-icon-s-promotion"
                            @click="deployModel(scope.row)"
                        >部署
                        </el-button>
                        <el-button
                            type="text"
                            style="color: #F56C6C"
                            icon="el-icon-delete"
                            @click="deleteModel(scope.row.id)"
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

            <el-dialog title="添加表单" :visible.sync="formVisible" width="35%">
                <el-form :model="modelRequestBody" :rules="rules" label-position="top" ref="modelForm">
                    <el-form-item
                        label="表单名称"
                        prop="name"
                    >
                        <el-input v-model="modelRequestBody.name"></el-input>
                    </el-form-item>
                    <el-form-item
                        label="模型类别"
                        prop="category"

                    >
                        <el-input v-model="modelRequestBody.category" disabled></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="addModel">保存表单</el-button>
                </span>
            </el-dialog>
        </div>

    </div>
</template>

<script>
import { addModel, createDeployment, deleteModel, getAllModels, getTheEditorSource } from '@/api';
import { formatDate } from '@/utils/formatDate';

/**
 * 表单模型列表
 */
export default {
    name: 'FormModels',
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
            formVisible: false,
            tableData: [],
            pageTotal: 0,
            modelRequestBody: {
                name: 'Model name',
                key: 'Model key',
                category: 'form',
                version: 1,
                metaInfo: 'Model metainfo',
                tenantId: 'tenant'
            },
// 表单的校验规则
            rules: {
                name: [
                    { required: true, message: '请输入表单名称', trigger: 'blur' }
                ],
                category: [
                    { required: true, message: '请输入类别', trigger: 'blur' }
                ]
            }
        };
    },
    created() {
        this.getData();
    },
    methods: {
        handleAdd() {
            this.formVisible = true;
            this.$nextTick(() => {
                this.$refs['modelForm'].resetFields();
            });
        },
        handleSearch() {

        },
        // 获取数据
        getData() {
            getAllModels(this.query.pageSize, this.query.start, "form").then(res => {
                this.tableData = res.data;
                this.pageTotal = res.total;
            }).catch(error => {
                console.log(error);
            });
        },
        // 删除
        deleteModel(modelId) {
            deleteModel(modelId).then(res => {
                this.$message.error('已删除');
                this.getData();
            }).catch(error => {
                console.log(error);
            });
        },
        // Deployment
        deployModel(row) {
            // 1. getTheEditorSource
            getTheEditorSource(row.id).then(res => {
                console.log(res.toString());
                let str = res.toString().replace(/isExpanded="\w+"/g, '');
                console.log(str);
                let xmlFile = new File([str], `${row.name}.bpmn`);
                // 2. Create a new deployment
                createDeployment(xmlFile).then(res => {
                    this.$message.success('部署成功');
                }).catch(error => {
                    console.log(error);
                });
            });

        },
        editModel(row) {
            this.$router.push({
                path: '/form/design',
                query: {
                    modelId: row.id,
                    modelName: row.name,
                    isHaveSource: row.sourceUrl === null ? false : true
                }
            });

        },
        addModel() {
            this.$refs['modelForm'].validate((valid) => {
                if (valid) {
                    addModel(this.modelRequestBody).then(res => {
                        this.$message.success(`添加成功`);
                        this.getData();
                        this.formVisible = false;
                    }).catch(error => {
                        console.log(error);
                    });
                }
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

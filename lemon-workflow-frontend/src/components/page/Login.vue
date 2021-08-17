<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">lemon-workflow 业务流程管理平台</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="name">
                    <el-input v-model="param.name" placeholder="用户名" tabindex="1">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="密码"
                        style="font-family: Stencil"
                        v-model="param.password"
                        tabindex="2"
                        @keyup.enter.native="submitForm()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>

                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                </div>
                <p class="login-tips">Tips : 测试账户为admin/test</p>
            </el-form>
        </div>
    </div>
</template>

<script>

import { requestLogin } from '../../api/index';

export default {
    data: function() {
        return {
            param: {
                name: 'admin',
                password: 'test'
            },
            rules: {
                name: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
            }
        };
    },
    methods: {
        submitForm() {
            this.$refs.login.validate(async (valid) => {
                if (valid) {
                    requestLogin('?name=' + this.param.name + '&password=' + this.param.password).then(res => {
                        if (res.code == 200) {
                            this.$message.success('登录成功');
                            localStorage.setItem('ms_username', this.param.name);
                            this.$router.push('/dashboard');
                        } else {
                            this.$message({
                                message: res.msg,
                                type: 'error'
                            });
                        }
                    });
                } else {
                    this.$message.error('请输入账号和密码');
                    console.log('error submit!!');
                    return false;
                }
            });
        }
    }
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-color: #11a1fd;
    background-image: url(../../assets/img/login-bg.png);
    background-size: 100%;
}

.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #333333;
    border-bottom: 1px solid #ddd;
}

.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: white;
    overflow: hidden;
}

.ms-content {
    padding: 30px 30px;
}

.login-btn {
    text-align: center;
}

.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}

.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #333333;
}
</style>

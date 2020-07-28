<template>
<!--    登录-->
    <div class="background_box">
        <div class="login_box">
            <el-container>
                <el-header>
                    <div>
                        <img src="../assets/logo_login.png" class="logo_img"/>
                    </div>
                </el-header>
                <el-main>
                    <div>
                        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" hide-required-asterisk="false" class="demo-ruleForm">
                            <el-form-item label="账号:" prop="userId">
                                <el-input type="text" v-model="ruleForm.userId"></el-input>
                            </el-form-item>
<!--                            <el-form-item label="昵称:" prop="userName">-->
<!--                                <el-input type="text" v-model="ruleForm.userName"></el-input>-->
<!--                            </el-form-item>-->
                            <el-form-item label="密码:" prop="userPassword">
                                <el-input type="password" v-model="ruleForm.userPassword"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                                <el-button @click="resetForm('ruleForm')">重置</el-button>
                            </el-form-item>
                        </el-form>
                    </div>
                    <div class="link_box">
                        <el-link type="primary" class="im_register" href="/register">立即注册</el-link>
                        <el-link type="info" class="forget_pass">忘记密码？</el-link>
                    </div>
                    <div class="rember_box">
                        <p>未注册手机验证后自动登录，注册即代表同意<el-link type="primary">《知道协议》</el-link><el-link type="primary">《隐私保护指引》</el-link></p>
                    </div>
                    <div class="about">
                        <p>——————————————————————————</p>
                        <p>工作室：神仙工作室</p>
                        <p>电话：6666-66666666</p>
                    </div>
                </el-main>
            </el-container>
        </div>
    </div>
</template>

<script>
    import router from "../router";
    import HomePage from "./HomePage";

    export default {
        name: "",
        data() {
            return {
                ruleForm: {
                    userId: '',
                    userName: '',
                    userPassword:''
                },
                rules: {
                    userId: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    userPassword: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post('http://localhost:8089/zhidao/user/login',this.ruleForm).then(res =>{
                            let result = res.data;
                            if(result == 'succ'){
                                //存储登录的用户id
                                this.$root.the_userId = this.ruleForm.userId;
                                //登录成功跳转到主页
                                this.$router.push('/home');
                            }
                            else{
                                alert('账号或密码错误！');
                            }
                        })
                        .catch(error => {
                            console.log(error);
                        })
                        // //登录成功跳转到主页
                        // this.$router.push('/home');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>
    .el-header{
        background-color: #ffffff;
        color: #333;
        /*text-align: center;*/
        /*line-height: 60px;*/
    }
    .el-footer{
        background-color: #c3cad1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        /*text-align: center;*/
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        /*text-align: center;*/
        /*line-height: 160px;*/
        height: 400px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .background_box{
        background-size: 100% 100%;
        background-image: url("../assets/background.png");
        height: 100%;
        width: 100%;
        position: fixed;
    }
    .login_box{
        height: 400px;
        width: 400px;
        background-color: bisque;
        margin: 0 auto;
        margin-top: 50px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    }
    .demo-ruleForm{
        max-width: 300px;
        max-height: 200px;
        margin-top: 20px;
    }
    .forget_pass{
        width: 100px;
        height: 20px;
        margin-left: 50px;
    }
    .im_register{
        width: 100px;
        height: 20px;
        margin-right: 50px;
    }
    .link_box{
        /*background-color: #625bff;*/
    }
    .rember_box{
        margin: 0 auto;
        width: 250px;
        height: 50px;
        font-size: 14px;
        margin-top: 20px;
        color:#909399;
        /*background-color: #2c3e50;*/
    }
    .other_login{
        margin-top: 20px;
        background-color: #daecff;
        height: 40px;
        text-align: center;
        line-height: 20px;
    }
    .span_text{
        color: #606266;
        font-size: 16px;
        /*margin-bottom: 20px;*/
        margin-right: 50px;
    }
    .span_qq{
        /*margin-top: 5px;*/
        color: #606266;
        font-size: 16px;
        margin-right: 20px;
    }
    .span_weixin{
        color: #606266;
        font-size: 16px;
        /*margin-right: 10px;*/
    }
    .icon{
        padding-top: 10px;
        margin-right: 5px;
        width: 20px;
        height: 20px;
    }
    .about{
        color: #C0C4CC;
        margin-top: 10px;
        font-size: 12px;
        line-height: 14px;
        /*background-color: #2c3e50;*/
        height: 40px;
    }
    .logo_img{
        height: 70px;
        /*margin-right: 50px;*/
    }
</style>
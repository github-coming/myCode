<template>
<!--    注册-->
    <div class="background_box">
        <div class="register_box">
            <el-container>
                <el-header>
                    <div>
                        <img src="../assets/logo_login.png" class="logo_img"/>
                    </div>
                </el-header>
                <el-main>
                    <div class="form_box" >
                        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" hide-required-asterisk="false" class="demo-ruleForm">
                            <el-form-item label="昵称:" prop="userName">
                                <el-input type="text" v-model="ruleForm.userName"></el-input>
                            </el-form-item>
                            <el-form-item label="账号:" prop="userId">
                                <el-input type="text" v-model="ruleForm.userId"></el-input>
                            </el-form-item>
                            <el-form-item label="密码:" prop="userPassword">
                                <el-input type="password" v-model="ruleForm.userPassword" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="确认密码:" prop="checkPass">
                                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                                <el-button @click="resetForm('ruleForm')">重置</el-button>
                            </el-form-item>
                        </el-form>
                    </div>
                    <div class="rember_box">
                        <p>未注册手机验证后自动登录，注册即代表同意<el-link type="primary">《知乎协议》</el-link><el-link type="primary">《隐私保护指引》</el-link></p>
                    </div>
                    <div class="about">
                        <p>——————————————————————————————————————————————</p>
                        <p>工作室：神仙工作室</p>
                        <p>电话：6666-66666666</p>
                    </div>
                </el-main>
            </el-container>
        </div>
    </div>
</template>

<script>
    export default {
        name: "",
        data() {
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.userPassword) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    userId:'',
                    userName:'',
                    userPassword: '',
                    checkPass: '',
                },
                rules: {
                    userId: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],
                    userPassword: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post('http://localhost:8089/zhidao/user/register',this.ruleForm).then(res =>{
                            // console.log(res);
                            // console.log(this.ruleForm.userId);
                            // console.log(this.ruleForm.userName);
                            // console.log(this.ruleForm.userPassword);
                            let result = res.data;
                            console.log(result);
                            if(result == 'repeat'){
                                alert('账号重复');
                            }
                            if(result == 'succ'){
                                alert('注册成功');
                                //注册成功，跳转到登录界面
                                this.$router.push('/');
                            }
                            if(result == 'fal'){
                                alert('注册失败');
                            }
                        })
                            .catch(error => {
                                console.log(error);
                            })
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
    .el-header, .el-footer {
        background-color: #ffffff;
        /*color: #333;*/
        /*text-align: center;*/
        /*line-height: 60px;*/
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        /*line-height: 160px;*/
        height: 500px;
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
    .register_box{
        width: 600px;
        height: 500px;
        background-color: #B3C0D1;
        margin: 0 auto;
        margin-top: 20px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    }
    .form_box{
        margin-left: 50px;
        margin-top: 20px;
        width: 400px;
        height: 250px;
        /*background-color: #ffb5b7;*/
    }
    .demo-ruleForm{
        max-width: 500px;
    }
    .rember_box{
        margin: 0 auto;
        width: 250px;
        height: 50px;
        font-size: 14px;
        margin-top: 70px;
        color:#909399;
        /*background-color: #2c3e50;*/
    }
    .about{
        color: #C0C4CC;
        margin-top: 20px;
        font-size: 12px;
        line-height: 14px;
        /*background-color: #2c3e50;*/
        height: 40px;
    }
    .logo_img{
        height: 70px;
        /*margin-right: 90px;*/
    }
</style>
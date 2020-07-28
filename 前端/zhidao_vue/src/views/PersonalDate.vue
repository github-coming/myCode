<template>
<!--    修改密码 -->
    <div class="date-body">
        <router-link to="/PersonalSpace">
            <div class="aaa">
                <i class="el-icon-back"></i>
            </div>
        </router-link>
        <div class="date-content">
            <el-form ref="form" :model="form" :rules="formRules"  label-width="80px">
                <el-form-item label="账号:" prop="userId">
                    <el-input type="text" v-model="ruleForm.userId"></el-input>
                </el-form-item>
                <el-form-item label="昵称:" prop="userName">
                    <el-input type="text" v-model="ruleForm.userName"></el-input>
                </el-form-item>
                <el-form-item label="密码:" prop="userPassword">
                    <el-input type="password" v-model="ruleForm.userPassword" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="确认密码:" prop="checkPass">
                    <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit" >保存修改</el-button>
                </el-form-item>
            </el-form>
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
            onSubmit() {
                this.$axios.post('http://localhost:8089/zhidao/user/updateuser',this.ruleForm).then(res =>{
                    // console.log(res);
                    // console.log(this.ruleForm.userId);
                    // console.log(this.ruleForm.userName);
                    // console.log(this.ruleForm.userPassword);
                    let result = res.data;
                    console.log(result);
                    if(result == 'succ'){
                        alert('修改成功');
                        //修改成功跳转到个人页面
                        this.$router.push('/personalSpace');
                    }
                    else{
                        alert('修改失败');
                    }
                })
                .catch(error => {
                    console.log(error);
                })
            },
        }
    }
</script>

<style scoped>
    .date-body{
        width: 50%;
        height: 400px;
        background: #e5e9f2;
        margin: auto;
        margin-top: 100px;
    }
    .date-content{
        width: 50%;
        margin: auto;
        margin-top: 10px;
    }
    .aaa{
        margin-left: 30px;
    }
    .el-icon-back{
        font-size: 30px;
        /*font-weight: 20px;*/
        margin-top: 10px;
    }
    .el-form-item{
        text-align: center;
    }

</style>
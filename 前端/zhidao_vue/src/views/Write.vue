<template>
<!--    我要发布-->
    <div>
        <el-container>
            <el-header>
                <Header></Header>
            </el-header>
            <el-container>
                <el-main>
                    <div class="write_box">
                        <el-form ref="editForm" status-icon :model="editForm" :rules="rules" label-width="80px">
                            <el-form-item label="标题" prop="title">
                                <el-input v-model="editForm.questionTitle"></el-input>
                            </el-form-item>
                            <el-form-item label="内容" prop="content">
                                <mavon-editor v-model="editForm.questionContent"/>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm()">发布</el-button>
                                <el-button @click="Rt_home()">取消</el-button>
                            </el-form-item>
                        </el-form>
                    </div>
                </el-main>
                <el-aside width="400px">
                    <PageAside></PageAside>
                </el-aside>
            </el-container>
            <ReturnTop></ReturnTop>
        </el-container>
    </div>
</template>

<script>
    import PageAside from "../components/PageAside";
    import Header from "../components/Header";
    import ReturnTop from "../components/ReturnTop";

    export default {
        name: "",
        components:{PageAside,Header,ReturnTop},
        data() {
            return {
                editForm: {
                    userId: this.$root.the_userId,
                    questionTitle: '',
                    questionContent: ''
                },

            }
        },
        methods: {
            submitForm() {
                this.$refs.editForm.validate((valid) => {
                    if (valid) {
                        this.$axios.post('http://localhost:8089/zhidao/question/insertquestion',this.editForm).then(res =>{
                            let result = res.data;
                            console.log(result);
                            if (result == 'succ'){
                                alert('发表成功');
                                //回到主页
                                this.$router.push('/home');
                            }
                            else{
                                alert('发表失败');
                            }
                        })
                        .catch(error => {
                            console.log(error);
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                })
            },
            Rt_home(){
                //点击取消时，默认回到主页
                this.$router.push('/home');
            }
        }

    }
</script>

<style scoped>
    .el-header, .el-footer {
        /*background-color: #ffffff;*/
        /*background-color: #000eff;*/
        color: #333;
        text-align: center;
        /*line-height: 60px;*/
    }

    .el-aside {
        /*background-color: #D3DCE6;*/
        color: #333;
        text-align: center;
        /*line-height: 200px;*/
        /*height: 1000px;*/
    }

    .el-main {
        /*background-color: #E9EEF3;*/
        color: #333;
        text-align: center;
        /*height: 1000px;*/
        /*height: 100%;*/
        /*line-height: 160px;*/
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

    .write_box{
        width: 730px;
        height: 700px;
        margin-left: 50px;
        margin-top: 10px;
        /*background-color: #2c3e50;*/
    }
</style>
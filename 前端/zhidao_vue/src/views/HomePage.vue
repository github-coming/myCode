<template>
<!--    主页-->
    <div>
        <div class="home_box" >
            <el-container>
                <el-header>
                    <Header></Header>
                </el-header>
                <el-container>
                    <el-main>
                        <div class="article_list" v-for="item in questionForm.question_list">
                            <el-card class="box-card_main" shadow="hover">
                                <div slot="header" class="clearfesix">
                                    <span>{{item.questionTitle}}</span>
                                    <el-button style="float: right; padding: 3px 0;color: #909399" type="text" v-on:click="check(item.questionId)">查看</el-button>
                                </div>
                                <div class="text item">
                                    <div>
                                        {{item.questionContent}}
                                    </div>
                                </div>
                            </el-card>
                        </div>
                    </el-main>
                    <el-aside width="400px">
                        <div class="personal_list">
                            <PageAside></PageAside>
                        </div>
                    </el-aside>
                </el-container>
                <ReturnTop></ReturnTop>
            </el-container>
        </div>

    </div>
</template>

<script>
    import Header from "../components/Header";
    import ReturnTop from "../components/ReturnTop";
    import PageAside from "../components/PageAside";
    export default {
        name: "",
        components: {Header,ReturnTop,PageAside},
        data() {
            return {
                tabPosition: 'left',
                count:1,
                userForm:{
                    userId:''
                },
                questionForm:{
                    question_list:[
                        {
                            questionId:'',
                            questionTitle:'标题',
                            questionContent:'内容'
                        }
                    ],
                },
                msg:null
            };
        },
        created() {
            this.userForm.userId = this.$root.the_userId;
            //页面生成时就访问后端数据
            this.$axios.post('http://localhost:8089/zhidao/question/getquestion',this.userForm).then(res =>{
                this.questionForm.question_list = res.data;
                console.log(this.questionForm.question_list);
            })
                .catch(error => {
                    console.log(error);
                })
        },
        methods:{
            check:function(theQ){
                //保存要查看的问题的id
                this.$root.the_questionId = theQ;
                console.log(this.$root.the_questionId);
                //跳转到详情页面
                this.$router.push('/test');
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
    .el-menu-demo{
        /*background-color: #B3C0D1;*/
    }

    .home_box{
        /*width: 500px;*/
        /*height: 1000px;*/
        /*background-color: #333333;*/
    }
    .article_list{
        height: 270px;
        width: 730px;
        margin-left: 50px;
        /*background-color: #333333;*/
    }
    .personal_list{
        margin-top: 20px;
        /*height: 950px;*/
        width: 300px;
        /*background-color: #333333;*/
    }
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card_main {
        width: 730px;
    }
</style>
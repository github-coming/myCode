<template>
<!--    我的收藏-->
    <div>
        <el-container>
            <el-header>
                <Header></Header>
            </el-header>
            <el-container>
                <el-main>
                    <div style="width: 730px;height: 80px; margin-left: 50px">
                        <el-card shadow="always">
                            我的收藏夹
                        </el-card>
                    </div>
                    <div v-for="item in collectForm.question_list">
                        <el-card class="box-card_main" shadow="hover">
                            <div slot="header" class="clearfix">
                                <span>{{item.questionTitle}}</span>
                                <el-button style="float: right; padding: 3px 0;color: #909399" type="text" v-on:click="check(item.questionId)">查看</el-button>
                            </div>
                            <div class="text item">
                                <div>
                                    {{item.questionContent}}
                                </div>
                            </div>
                        </el-card>
                        <div style="height: 20px"></div>
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
        data(){
            return{
                sendIdForm: {
                    userId:''
                },
                collectForm: {
                    question_list:[
                        {
                            questionId:'',
                            questionTitle:'标题',
                            questionContent:'内容'
                        }
                    ],
                }
            };
        },
        created() {
            //获取该用户id
            this.sendIdForm.userId = this.$root.the_userId;
            console.log(this.sendIdForm.userId);
            //页面生成时就访问后端数据
            this.$axios.post('http://localhost:8089/zhidao/collection/getcollection',this.sendIdForm).then(res =>{
                this.collectForm.question_list = res.data;
                console.log(this.collectForm.question_list);
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
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }
    .box-card_main{
        width: 730px;
        margin-left: 50px;
    }
</style>
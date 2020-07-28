<template>
<!--    我的提问-->
    <div style="margin-top: 10px;margin-left: 30px">
        <div style="width: 100px;height:50px;margin-right: 300px;">
            <span style="line-height: 25px">我的提问</span>
            <hr style="width: 500px;border-width: 1px"/>
        </div>
        <div v-for="item in questionForm.question_list">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span>{{item.questionTitle}}</span>
                    <el-button style="float: right; padding: 3px 0" type="text" v-on:click="check(item.questionId)">查看</el-button>
                </div>
                <div>
                    {{item.questionContent}}
                </div>
            </el-card>
        </div>
    </div>
</template>

<script>
    export default {
        name: "",
        data() {
            return {
                count:'10',
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
            };
        },
        created() {
            this.userForm.userId = this.$root.the_userId;
            //页面生成时就访问后端数据
            this.$axios.post('http://localhost:8089/zhidao/question/getquestionbyid',this.userForm).then(res =>{
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
    .box-card{
        width: 500px;
        /*margin-top: 10px;*/
    }
</style>
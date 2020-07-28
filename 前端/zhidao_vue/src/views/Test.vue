<template>
<!--    文章详情-->
    <div>
        <el-container>
            <el-header>
                <Header></Header>
            </el-header>
            <el-main>
                <div >
                    <el-card class="box-card" >
                        <div slot="header" class="clearfix">
<!--                            <span>{{item.questionTitle}}</span>-->
                            {{questionForm.question_list.questionTitle}}
                        </div>
                        <div>
                            <span style="float: left; margin-bottom: 10px;margin-left: 10px">{{questionForm.question_list.userName}}</span>
                            <span style="float: left; margin-bottom: 10px;margin-left: 20px">{{questionForm.question_list.questionTime}}</span>
                            <br/><br/>
                            {{questionForm.question_list.questionContent}}
                            <hr/>
                            <el-button style="float: right; margin-bottom: 10px;" type="text" v-on:click="thisCollect()">
                                <img src="../assets/收藏.png" style="width: 20px;height: 20px"/>
                            </el-button>
                            <el-button style="float: right; margin-bottom: 10px;margin-right: 20px" type="text" v-on:click="thisComment()">
                                <img src="../assets/评论.png" style="width: 20px;height: 20px"/>
                            </el-button>
                            <el-button type="primary" size="mini" style="float: left;" round v-on:click="fans_Author()">关注作者</el-button>
                        </div>
                    </el-card>
                </div>
<!--                评论区-->
                <div style="margin-top: 50px;width: 800px;margin-left: 150px;">
                    <div class="block">
                        <el-timeline >
                            <el-timeline-item v-bind:timestamp="item.commentTime" placement="top" v-for="item in allcommentForm.allcomment_list">
                                <el-card>
                                    <h4>{{item.userName}}</h4>
                                    <p>{{item.commentContent}}</p>
                                </el-card>
                            </el-timeline-item>
                        </el-timeline>
                    </div>
                    <el-drawer title="我是标题" :with-header="false" :visible.sync="drawer"  :direction="direction" size="400px">
                        <el-form ref="form" :model="form"  class="comment_box">
                            <el-form-item>
                                <el-input type="textarea" v-model="form.desc"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="onSubmit">发送</el-button>
                            </el-form-item>
                        </el-form>
                    </el-drawer>
                </div>
            </el-main>
        </el-container>
    </div>
</template>

<script>
    import Header from "../components/Header";
    export default {
        name: "",
        components:{Header},
        data(){
            return{
                drawer: false,
                direction: 'btt',
                form:{
                    desc:''
                },
                //发送问题id
                sendIdForm:{
                    questionId:'',
                },
                //接收问题相关信息
                questionForm:{
                    question_list:[
                        {
                            questionContent:'asdfs',
                            questionId:'',
                            questionTime:'发表时间',
                            questionTitle:'标题',
                            userId:'',
                            userName:'用户昵称'
                        }
                    ],
                },
                collectForm:{
                    userId:'',
                    questionId:'',
                },
                //发送评论
                commentForm:{
                    commentContent:'',
                    userId:'',
                    questionId:'',
                },
                form: {
                    desc: ''
                },
                //接收所有评论
                allcommentForm:{
                    allcomment_list:[
                        {
                            commentId:'',
                            commentContent:'评论内容',
                            commentTime:'评论时间',
                            questionId:'',
                            userId:'',
                            userName:'评论用户昵称',
                        }
                    ]
                },
                //关注
                fansForm:{
                    userId:'',
                    idolId:''
                }
            };
        },
        created() {
            //页面生成时就访问数据
            //获取问题id
            this.sendIdForm.questionId = this.$root.the_questionId;
            console.log(this.sendIdForm.questionId);
            // console.log(this.questionForm.question_list);
            console.log('a');
            //发送id给后端
            this.$axios.post('http://localhost:8089/zhidao/question/getonequestion',this.sendIdForm).then(res =>{
                //接手后端传来的问题相关信息
                this.questionForm.question_list = res.data;
                console.log(this.questionForm.question_list);
                console.log('a');
            })
                .catch(error => {
                    console.log(error);
                })
            this.$axios.post('http://localhost:8089/zhidao/comment/getcomment',this.sendIdForm).then(res =>{
                //接收后端传来的评论相关信息
                this.allcommentForm.allcomment_list = res.data;
                console.log(this.allcommentForm.allcomment_list);
                console.log('a');
            })
                .catch(error => {
                    console.log(error);
                })
        },
        methods:{
            thisCollect(){
                this.collectForm.userId = this.$root.the_userId;
                this.collectForm.questionId = this.$root.the_questionId;
                console.log(this.collectForm.userId);
                console.log(this.collectForm.questionId);
                this.$axios.post('http://localhost:8089/zhidao/collection/insertcollection',this.collectForm).then(res =>{
                    let result = res.data;
                    console.log(result);
                    if (result == 'succ'){
                        alert('收藏成功');
                    }
                    if (result == 'repeat'){
                        alert('已经收藏，不需要再收藏了');
                    }
                    if (result == 'fal'){
                        alert('收藏失败');
                    }
                })
                    .catch(error => {
                        console.log(error);
                    })
            },
            thisComment(){
                this.drawer = true;
                console.log(this.drawer);
            },
            onSubmit() {
                this.commentForm.userId = this.$root.the_userId;
                this.commentForm.questionId = this.$root.the_questionId;
                this.commentForm.commentContent = this.form.desc;
                console.log(this.commentForm.userId);
                console.log(this.commentForm.questionId);
                this.$axios.post('http://localhost:8089/zhidao/comment/insertcomment',this.commentForm).then(res =>{
                    let result = res.data;
                    console.log(result);
                    if (result == 'succ'){
                        alert('评论成功');
                    }
                    else{
                        alert('评论失败');
                    }
                })
                    .catch(error => {
                        console.log(error);
                    })
            },
            fans_Author(){
                this.fansForm.userId = this.$root.the_userId;
                this.fansForm.idolId = this.questionForm.question_list.userId;
                this.$axios.post('http://localhost:8089/zhidao/fans/insertfans',this.fansForm).then(res =>{
                    let result = res.data;
                    console.log(result);
                    if (result == 'succ'){
                        alert('关注成功');
                    }
                    if (result == 'repeat'){
                        alert('已经关注，不需要再关注了');
                    }
                    if (result == 'no'){
                        alert('不能关注自己哦');
                    }
                    if (result == 'fal'){
                        alert('关注失败');
                    }
                })
                    .catch(error => {
                        console.log(error);
                    })
            }
        }
    }
</script>

<style scoped>
    .box-card{
        width: 1000px;
        margin: 0 auto;
    }
    .comment_box{
        margin: 0 auto;
        margin-top: 70px;
        height: 200px;
        width: 400px;
    }
</style>
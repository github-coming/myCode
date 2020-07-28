<template>
<!--    个人主页-->
    <div>
        <el-container>
            <el-header>
                <Header></Header>
            </el-header>
            <el-main>
                <div class="Personal_container">
                    <div class="Personal_one">
                        <el-card class="box-card">
                            <span>{{this.$root.the_userId}}的个人主页</span>
                        </el-card>
                    </div>
                    <div class="Personal_two">
                        <!--我的模块-->
                        <div class="Personal_myMouble">
                            <el-menu  class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
                                <el-menu-item index="1" >提问</el-menu-item>
                                <el-submenu index="2" >
                                    <template slot="title" >更多</template>
                                    <el-menu-item index="2-1">收藏</el-menu-item>
                                </el-submenu>
                            </el-menu>

                        </div>
                        <!--模块详情-->
                        <div >
                            <router-view ></router-view >
                        </div>
                    </div>
                    <div class="Personal_three">
                        <div class="fans" id="idol">
                            <el-button @click="chageText01()"  style="width:150px;height: 50px;margin-left: 50px;margin-top: 20px">
                                我的关注
                            </el-button>
                            <el-button @click="chageText02()"  style="width:150px;height: 50px;margin-left: 50px;margin-top: 50px  ">
                                我的粉丝
                            </el-button>
                            <el-drawer title="我是标题" :with-header="false" :visible.sync="drawer"  :direction="direction" size="400px">
                                <span>{{gz_fs}}</span>
                                <div v-for="item in getForm.gz_list" v-show="isShow_gz" >
                                    <el-card class="box-card_user">
                                        {{item.userName}}
                                    </el-card>
                                </div>
                                <div v-for="item in getForm.fs_list" v-show="isShow_fs">
                                    <el-card class="box-card_user">
                                        {{item.userName}}
                                    </el-card>
                                </div>
                            </el-drawer>
                        </div>
                        <div class="Personal_editDate">
                            <router-link to="/PersonalDate">
                                <el-row>
                                    <el-button class="btn-editDate" type="primary">修改密码</el-button>
                                </el-row>
                            </router-link>
                        </div>
                    </div>
                </div>
            </el-main>
        </el-container>
        <ReturnTop></ReturnTop>
    </div>
</template>

<script>
    import Header from "../components/Header";
    import ReturnTop from "../components/ReturnTop";
    export default {
        name: "",
        components:{Header,ReturnTop},
        data() {
            var list;
            return {
                activeIndex: '1',
                activeIndex2: '1',
                drawer: false,
                direction:'rtl',
                gz_fs:'',
                isShow_gz:false,
                isShow_fs:false,
                //发送该用户id
                sendIdForm:{
                    userId:''
                },
                getForm:{
                    gz_list:{
                        userId:'',
                        userName:'关注'
                    },
                    // fs_list:{
                    //     userId:'',
                    //     userName:'粉丝'
                    // },
                },
            };
        },
        methods: {
            chageText01(){
                this.drawer = true;
                this.isShow_gz = true;
                this.isShow_fs = false;
                this.gz_fs = '我的关注';
                this.sendIdForm.userId = this.$root.the_userId;
                console.log(this.getForm.gz_list);
                console.log(this.sendIdForm.userId);
                this.$axios.post('http://localhost:8089/zhidao/fans/getgzuser',this.sendIdForm).then(res =>{
                    //接收后端传来的问题相关信息
                    this.getForm.gz_list = res.data;
                    console.log(this.getForm.gz_list);
                })
                    .catch(error => {
                        console.log(error);
                    })
            },
            chageText02(){
                this.drawer = true;
                this.isShow_gz = false;
                this.isShow_fs = true;
                this.gz_fs = '我的粉丝';
                this.sendIdForm.userId = this.$root.the_userId;
                this.$axios.post('http://localhost:8089/zhidao/fans/getfsuser',this.sendIdForm).then(res =>{
                    //接收后端传来的问题相关信息
                    this.getForm.fs_list = res.data;
                    console.log(this.getForm.fs_list);
                })
                    .catch(error => {
                        console.log(error);
                    })
            },
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
        }
    }
</script>

<style scoped>
    .Personal_container{

        height: 100%;
    }
    .Personal_one{
        width: 70%;
        height: 50px;
        background: azure;
        position: relative;
        margin: auto;
    }

    .Personal_editDate{
        width:12% ;
        height: 35px;
        position: absolute;
        right: 200px;
        bottom: 25px;

    }
    .Personal_two{
        width: 46%;
        height: 500px;
        position: relative;
        margin-top: 30px;
        margin-left: 15%;

        float: left;
    }
    .Personal_three{
        width: 23%;
        height: 350px;
        position: relative;
        margin-right: 15%;
        margin-top: 30px;
        border: 2px solid #fef0f0;
        float: right;
    }
    .Personal_myMouble{
        width: 100%;
        height: 63px;

    }

    .btn-editDate{
        width: 120px;
        height: 100%;
        margin-left: 30px;
    }

    .fans{
        width: 150px;
        height: 50px;
        float: left;
        text-align: center;
        line-height: 50px;
        vertical-align: center;
        margin-left: 15px;
        margin-top: 10px;

    }
    span{
        color: #409EFF;
    }
    button{
        outline:none;
    }
    .box-card_user{
        width: 300px;
        margin: 0 auto;
    }
</style>
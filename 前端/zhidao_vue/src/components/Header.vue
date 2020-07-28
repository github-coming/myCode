<template>
    <div>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="0">
                <img src="../assets/logo.png" style="height: 50px"/>
            </el-menu-item>
            <el-menu-item index="1" v-on:click="Rt_home()">首页</el-menu-item>
            <el-submenu index="2">
                <template slot="title">个人</template>
                <el-menu-item index="2-1" v-on:click="Rt_personal()">个人主页</el-menu-item>
                <el-menu-item index="2-2">设置</el-menu-item>
                <el-menu-item index="2-3">退出</el-menu-item>
            </el-submenu>
            <el-menu-item index="1" style="float: right;color: black" disabled>欢迎你！{{this.$root.the_userId}}</el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "",
        methods:{
            Rt_personal(){
                this.$router.push('/PersonalSpace');
            },
            Rt_home(){
                this.$router.push('/home');
            }
        }
    }
</script>

<style scoped>

</style>
<template>
    <div>
        <el-card class="box-card">
            <el-link target="_blank" v-on:click="rt_collect()">我的收藏夹</el-link>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "",

        methods:{
            rt_collect(){
                this.$router.push('/mycollect');
            }
        }
    }
</script>

<style scoped>

</style>
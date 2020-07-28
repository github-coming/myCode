<template>
    <div style="position:fixed; top:88px; right:70px;">
        <div>
            <el-card class="box-card_aside" shadow="hover">
                <div class="text item">
                    <el-button type="text" v-on:click="Rt_write()">
                        <img src="../assets/写文章.png" style="width: 20px;height: 20px"/>
                        <div style="color: #909399">我要发表</div>
                    </el-button>
                    <el-divider direction="vertical"></el-divider>
                    <el-button type="text" v-on:click="Rt_collect()">
                        <img src="../assets/收藏.png" style="width: 20px;height: 20px"/>
                        <div style="color: #909399">我的收藏</div>
                    </el-button>
                    <el-divider direction="vertical"></el-divider>
                    <el-button type="text">
                        <img src="../assets/关注.png" style="width: 20px;height: 20px"/>
                        <div style="color: #909399">我的关注</div>
                    </el-button>
                    <br>
                    <el-button type="text">
                        <img src="../assets/我的邀请.png" style="width: 20px;height: 20px"/>
                        <div style="color: #909399">我的邀请</div>
                    </el-button>
                    <el-divider direction="vertical"></el-divider>
                    <el-button type="text">
                        <img src="../assets/关于我们.png" style="width: 20px;height: 20px"/>
                        <div style="color: #909399">关于我们</div>
                    </el-button>
                    <el-divider direction="vertical"></el-divider>
                    <el-button type="text">
                        <img src="../assets/帮助中心.png" style="width: 20px;height: 20px"/>
                        <div style="color: #909399">帮助中心</div>
                    </el-button>
                </div>
            </el-card>
        </div>
        <div style="margin-top: 20px">
            <el-carousel height="300px" direction="vertical" :autoplay="false">
                <el-carousel-item v-for="item in 3" :key="item">
                    <h3 class="medium">这里是广告位{{ item }}</h3>
                </el-carousel-item>
            </el-carousel>
        </div>
    </div>
</template>

<script>
    export default {
        name: "",
        methods:{
            Rt_collect(){
                this.$router.push('/mycollect');
            },
            Rt_write(){
                this.$router.push('/write');
            }
        }
    }
</script>

<style scoped>
    .text {
        font-size: 12px;
    }

    .item {
        margin-bottom: 18px;
    }

    .box-card_aside {
        width: 350px;
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 200px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }
</style>
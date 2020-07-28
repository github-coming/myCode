<template>
    <div @scroll="handleScroll()">
        <button v-on:click="returnTop()" class="ret_top" v-if="isPlay">▲</button>
    </div>
</template>

<script>
    export default {
        name: "",
        data() {
            return {
                isPlay:false
            };
        },
        created() {
            window.addEventListener('scroll', this.handleScroll);
        },
        methods:{
            returnTop(){
                document.body.scrollTop = document.documentElement.scrollTop = 0;
                this.isPlay = false;
            },
            handleScroll(){
                this.isPlay = true;
            }
        }
    }
</script>

<style scoped>
    .ret_top{
        width: 40px;
        height: 40px;
        position: fixed;
        right: 10px;
        bottom: 20px;
        border-radius: 20px;
        border-width: 0px;
        background-color: #0080ff;
        color: white;
    }
    .ret_top:hover{
        border-width: 1px;
        border-color: #0080ff;
        background-color: white;
        color: #0080ff;
    }
</style>
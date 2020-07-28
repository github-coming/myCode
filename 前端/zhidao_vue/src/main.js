import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
Vue.use(Element)

import axios from 'axios'
Vue.prototype.$axios = axios

import mavoEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
//use
Vue.use(mavoEditor)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  data:function () {
    return{
      the_userId:'aaa',
      the_questionId:'111',
    }
  },
  render: h => h(App),
}).$mount('#app')

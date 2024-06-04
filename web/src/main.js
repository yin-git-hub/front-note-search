import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueMarkdown from 'vue-markdown'
import axios  from "axios";

Vue.config.productionTip = false
Vue.use(ElementUI).use(VueMarkdown)
new Vue({
  render: h => h(App),
}).$mount('#app')

axios.defaults.baseURL = "http://localhost:7000/notes-front";
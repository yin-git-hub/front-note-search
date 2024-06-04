<template>
  <div id="app">
    <el-input @change="change" v-model="input" placeholder="请输入内容"></el-input>
    <vue-markdown :source="markdown"></vue-markdown>
    <el-card   class="box-card">
      <div slot="header" class="clearfix">
        <span>卡片名称</span>
        <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'列表内容 ' + o }}
      </div>
    </el-card>
  </div>
</template>

<script>
import VueMarkdown from 'vue-markdown';
import {ref} from "vue";
import  axios from "axios";

const input = ref();
const result = ref({
  id:"",
});
export default {
  name: 'App',
  methods: {
    change() {

      axios.get('/getContext/'+input.value).then(resp=>{
        console.log(resp)
      })
    }
  },
  data() {
    return {
      markdown: '# Hello, Vue Markdown!',
      input: input,
      result: result,
    }
  },
  components: {
    VueMarkdown
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 480px;
}
</style>

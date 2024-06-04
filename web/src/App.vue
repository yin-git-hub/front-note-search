<template>
  <div id="app">
    <el-input @change="change" v-model="input" placeholder="请输入内容"></el-input>
    <vue-markdown :source="input"></vue-markdown>

    <div  v-for="item in result"  v-html="item.highlightFields.context[0]">

  </div>

  </div>
</template>

<script>
import VueMarkdown from 'vue-markdown';
import {ref} from "vue";
import  axios from "axios";

const input = ref();
const result = ref([]);
export default {
  name: 'App',
  methods: {
    change() {

      axios.get('/getContext/'+input.value).then(resp=>{
        console.log(resp.data)
        result.value = resp.data
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

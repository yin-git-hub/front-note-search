<template>
  <div id="app">
    <el-input v-model="input" placeholder="请输入内容"></el-input>
    <span style="float: right">
    <el-button>搜索</el-button>

    </span>
    <vue-markdown :source="markdown"></vue-markdown>
  </div>
</template>

<script>
import VueMarkdown from 'vue-markdown';

export default {
  name: 'App',
  data() {
    return {
      markdown: '# Hello, Vue Markdown!'
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
</style>

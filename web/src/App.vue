<template>
  <div id="app">
    <el-input @change="change" v-model="input" placeholder="请输入内容"></el-input>
    <vue-markdown :source="markdown"></vue-markdown>
  </div>
</template>

<script>
import VueMarkdown from 'vue-markdown';
import {ref} from "vue";

const input = ref();
export default {
  name: 'App',
  methods: {
    change() {
      console.log(input.value)
    }
  },
  data() {
    return {
      markdown: '# Hello, Vue Markdown!',
      input: input
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

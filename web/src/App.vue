<template>
  <div id="app">
    <el-input @change="change" v-model="input" placeholder="请输入内容"></el-input>

    <div v-for="item in result" >
      <div style="color: skyblue;margin: 5px">
        {{item.location}}
      </div>
      <div style="border-style:double;margin-bottom: 30px ">

        <vue-markdown breaks="false" style="  max-width: 1200px;margin-left:15px; margin-bottom: 10px"
                      :source="item.context "></vue-markdown>
      </div>
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
#app{
  max-width: 1400px;
  margin: 0 auto;
  margin-top: 100px;
}
</style>

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// // 引入基础css
// import 'bytemd/dist/index.min.css';
// // 引入高亮css
// import "highlight.js/styles/vs.css"; 
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import Prism from 'prismjs';
import '@kangc/v-md-editor/lib/style/preview.css';
// 引入你所使用的主题 此处以 github 主题为例
import githubTheme from '@kangc/v-md-editor/lib/theme/github';
import '@kangc/v-md-editor/lib/theme/style/github.css';



VueMarkdownEditor.use(vuepressTheme, {
  Prism,
});
// highlightjs
import hljs from 'highlight.js';


VMdPreview.use(githubTheme, {
  Hljs: hljs,
});
const app = createApp(App);

app.use(store).use(router).use(VueMarkdownEditor).use(VMdPreview).mount('#app')


<template>

  <v-md-preview :text="markdown"></v-md-preview>
</template>

<script>
export default {
  data() {
    return {
      markdown: '### 标题\n' +
        '==dcdc==\n' +
        '<span style="color:blue">dddd</span>',
    };
  },
};
</script>
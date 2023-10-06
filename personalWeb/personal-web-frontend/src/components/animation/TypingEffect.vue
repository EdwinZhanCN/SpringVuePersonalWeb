<template>
  <p>{{ displayText }}</p>
</template>

<script>
export default {
  props: {
    text: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      displayText: '',
      index: 0
    }
  },
  methods: {
    typeEffect() {
      if (this.index < this.text.length) {
        this.displayText += this.text.charAt(this.index);
        this.index++;
        setTimeout(this.typeEffect, 100); // 调整这个值来改变打字速度
      }
    }
  },
  mounted() {
    this.typeEffect();
  }
}
</script>

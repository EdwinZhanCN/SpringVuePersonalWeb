<template>
  <div>
    <div class="top-blocker">
    </div>
    <div class="scroll-view">
      <p v-for="(lyric, index) in lyrics" :key="index"
         :class="{ 'active': index === activeIndex, 'blur': index < activeIndex, 'blur': index > activeIndex}"
         :style="{ '--i': index,
         '--active-index': activeIndex,
          top: (index + magicNumber) * 4.5 + 'em'}">
        {{ lyric }}
      </p>
    </div>
    <button @click="scrollLyrics" style="margin-top: 500px">click me</button>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'LyricScroller',
  setup() {
    const magicNumber = ref(0);
    const activeIndex = ref(0);
    const lyrics = ref([
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      "dsadsadbhjbashjdbhabdhsavdasgyugyuvgycvyggyb",
      //... repeat for other lines
    ]);

    const scrollLyrics = () => {
      magicNumber.value--;
      activeIndex.value++;
    };

    return {
      activeIndex,
      magicNumber,
      lyrics,
      scrollLyrics
    };
  }
}
</script>

<style scoped>

.blur{
  color: #181818;
  opacity: calc(0.6 - (var(--i) - var(--active-index)) * 0.1);
}

.scroll-view {
  z-index: 0;
  left: 100px;
  top: 200px;
  width: auto;
  max-width: 600px;
  position: relative;
  height: 32em;
  overflow: hidden;
}

p {
  font-family: Helvetica,serif;
  font-weight: bold;
  text-align: start;
  font-size: 40px;
  word-wrap: break-word;
  line-height: 40px;
  width: 80%;
  position: absolute;
  margin: 0;
  transition: all .7s ease-in-out;
}

p.active{
  color: #181818;
}


p.active ~ p {
  transition-delay: calc(var(--i) * 0.02s - var(--active-index) * 0.016s);
}

</style>

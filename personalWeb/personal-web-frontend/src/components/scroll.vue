<template>
  <div class="scroll-view">
    <vue3-seamless-scroll
        :list="images1"
        class="scroll"
        direction = "left"
        step = 0.6
    >
      <img v-show= "response" v-for="image in images1" :key="image" :src="image" alt="database-image"/>
    </vue3-seamless-scroll>
    <vue3-seamless-scroll
        :list="images2"
        class="scroll"
        direction = "left"
        step = 0.8
    >
      <img v-show= "response" v-for="image in images2" :key="image" :src="image" alt="database-image"/>
    </vue3-seamless-scroll>
    <vue3-seamless-scroll
        :list="images3"
        class="scroll"
        direction = "left"
        step = 0.7
    >
      <img v-show= "response" v-for="image in images3" :key="image" :src="image" alt="database-image"/>
    </vue3-seamless-scroll>
  </div>
</template>
<script>
import { defineComponent, ref } from "vue";
import { Vue3SeamlessScroll } from "vue3-seamless-scroll";
import {useStore} from "@/stores";
import {get} from "@/net";
import {ElMessage} from "element-plus";

export default defineComponent({
  name: "App",
  components: {
    Vue3SeamlessScroll
  },
  setup() {
    const response = ref(false)

    const images1 = ref([])
    const images2 = ref([])
    const images3 = ref([])
    const fetchImage = () =>{
      for (let i = 1; i <= 41; i++) {
        get(`api/image/${i}`, (data) => {
          if (data) {
            if (i > 13 && i <= 28) {
              images2.value.push('data:image/jpeg;base64,' + data);
            } else if (i > 28 && i <= 41) {
              images3.value.push('data:image/jpeg;base64,' + data);
            } else {
              images1.value.push('data:image/jpeg;base64,' + data);
            }
          }else{
            ElMessage.warning(`Failed to decode the image with id: ${i}`);
          }
        },()=>{
          console.log("can't find image: ${i}");
        });
      }
    }

    fetchImage();
    response.value = true;
    return { images1, images2, images3, response};
  },
});
</script>

<style>
.scroll {
  position: relative;
  display: block;
  width: 90%;
  height: 220px;
  margin: 0 auto;
  overflow: hidden;
  background: black;

}

.scroll img{
  width: 220px;
  height: 220px;
  justify-content: space-between;
  margin-left: 10px;
}

.scroll-view{
  border-radius: 10px;
  display: grid;
  grid-template-rows: 1fr 1fr 1fr;
  grid-gap: 10px;
  margin-top: 20px;
  margin-bottom: 20px;
  animation: trans 8s ease-in-out;
}

@keyframes trans {
  from{
    opacity: 0;
  }
  to{
    opacity: 1;
  }
}
</style>
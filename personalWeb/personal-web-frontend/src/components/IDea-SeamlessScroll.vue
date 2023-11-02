<script>
import {defineComponent, ref} from "vue";
import {get} from "@/net";
import {ElMessage} from "element-plus";
export default defineComponent({
  setup(){
    //check if the fetchImage have done
    const response = ref(false)

    //Three Image Columns
    const images1 = ref([])
    const images2 = ref([])
    const images3 = ref([])

    /*
      fetch the Image from the backend
      api/image/{id}
     */
    const fetchImage = () =>{
      //for ids in database
      for (let i = 1; i <= 41; i++) {
        get(`api/image/${i}`, (data) => {
          if (data) {
            //Spread into three part of images
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
  }
});
</script>

<template>
  <div class="scroll-view" v-show=response>
    <div class="scroll image-box" style="--t: 55s;">
      <div>
        <img v-for="image in images1" key="image" :src="image" alt="database-img">
      </div>
      <div>
        <img v-for="image in images1" key="image-copy" :src="image" alt="database-img">
      </div>
    </div>
    <div class="scroll image-box" style="--t: 50s;">
      <div>
        <img v-for="image in images2" key="image" :src="image" alt="database-img">
      </div>
      <div>
        <img v-for="image in images2" key="image-copy" :src="image" alt="database-img">
      </div>
    </div>
    <div class="scroll image-box" style="--t: 53s;">
      <div>
        <img v-for="image in images3" key="image" :src="image" alt="database-img">
      </div>
      <div>
        <img v-for="image in images3" key="image-copy" :src="image" alt="database-img">
      </div>
    </div>
  </div>
</template>

<style scoped>
*{
  margin:0;
  padding: 0;
}

.scroll-view{
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.scroll {
  width: 90vw;
  position: relative;
  display: flex;
  overflow: hidden;
  margin: 5px 0;
}

.scroll div {
  white-space: nowrap;
  animation: animate var(--t) linear infinite;
  animation-delay: calc(var(--t) / -1);
}

.scroll div:nth-child(2) {
  animation: animate2 var(--t) linear infinite;
  animation-delay: calc(var(--t) / -2);
}

@keyframes animate {
  0% {
    transform: translateX(100%);
  }
  100% {
    transform: translateX(-100%);
  }
}

@keyframes animate2 {
  0% {
    transform: translateX(0);
  }
  100% {
    transform: translateX(-200%);
  }
}


.image-box img {
  filter: grayscale(0);
  height: 220px;
  width: 220px;
  cursor: pointer;
  transition: .5s;
  margin: 0 5px;
}

</style>
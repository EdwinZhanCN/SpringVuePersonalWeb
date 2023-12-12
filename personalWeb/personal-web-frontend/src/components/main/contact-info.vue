<script>
import {ref} from "vue";

export default {
  name:"contact-info",
  setup(){
    const contactItems = ref([
      {name:'bilibili', url:"https://space.bilibili.com/383858425", imgUrl:"./icons/bilibili.ico"},
      {name: 'github', url: "https://github.com/EdwinZhanCN", imgUrl:"./icons/github.png"}
    ])
    function copy(){
      const spanElement = document.getElementById('email');
      const textToCopy = spanElement.innerText;
      const textarea = document.createElement('textarea');
      textarea.value = textToCopy;
      document.body.appendChild(textarea);
      textarea.select();
      document.execCommand('copy');
      document.body.removeChild(textarea);

    }

    return{contactItems, copy}
  }
}
</script>

<template>
  <section class="contact">
    <!-- ... contact section ... -->
    <h1 class="contact-title">
      Contact information
    </h1>
    <footer class = "contact-wrapper">
      <ul class="contact-list1">
        <li
            class = "contact-item"
            v-for = "item in contactItems"
            :key = "item.name"
        >
          <a class = "contact-link" :href=item.url target="_blank">
            <img :src=item.imgUrl alt="_item-image">
            <span>
              Bilibili Personal Space
            </span>
          </a>
        </li>
        <li class="contact-item">
          <a class = "contact-link" @click = copy()>
            <img src="./icons/mail-seen.ico">
              <span id = "email">
                ed_zhan@outlook.com
              </span>
          </a>
        </li>
      </ul>
    </footer>
  </section>
</template>

<style scoped>

a{
  padding: 0;
}

.contact{
  background: rgb(209,209,214);
}
.contact-title{
  margin:0 0 0 10px;
  color: #333333;
  margin-block-start: 0;
  margin-block-end: 0;
  font-weight: normal;
  font-size: 30px;
}

.contact-wrapper{
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 50px;
  margin:0 0 0 10px;
  width: auto;
}

.contact-list1{
  width: auto;
  padding-inline-start: 0;
  list-style: none;
}

.contact-link{
  width: 100%;
  color: #e6fef4;
  text-decoration: none;
  display: flex;
  cursor: pointer;
}
.contact-link span{
  user-select: none;
  padding-top: 4px;
  margin-block-start: 0;
  margin-block-end: 0;
  font-size: 20px;
  display: block;
  opacity: 0;
  width:auto;
  transform: translateX(-60px);
}

.contact-link:hover span{
  opacity: 1;
  user-select: none;
  transform: translateX(0px);
  transition: opacity .6s cubic-bezier(0.16, 1, 0.3, 1),transform .6s cubic-bezier(0.16, 1, 0.3, 1);
  margin-block-end: 0;
}
</style>
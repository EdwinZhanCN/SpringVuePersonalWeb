<script setup>

import {Delete} from "@element-plus/icons-vue";
</script>

<template>
  <div class="heading">
    <h1>
      Photo Gallery
    </h1>
  </div>
  <section class="gallery-section">
    <div class="gallery-section description" >
      <h2>
        Christmas Tree
      </h2>
      <div>
        <p>
          Visit Rockefeller center on Christmas eve. Dec 24, 2023.
          The biggest Christmas tree in Manhattan.
          <br>
          <br>
        </p>
        <p style="font-style: italic;">
          "The room was filled with the scent of the pine tree, decked out in its holiday colors of red and green.
          It stood proudly in the corner, its branches draped with strings of silver tinsel, twinkling lights,
          and colorful ornaments. At the very top, a shining star completed the spectacle,
          casting a soft, warm glow over the room."<br>
          <br>
          ------"The Gift of the Magi", O. Henry
        </p>
        <p style="color: grey">
          Shot on iPhone 13 mini, Rockefeller Center, Manhattan, NY, United States.
        </p>
      </div>
    </div>
    <div class="photo-container" style="border-left: solid #1c1e21 1px;">
      <img src = "../assets/Photo/IMG_7087.jpg" alt=""/>
    </div>
  </section>

  <section class="gallery-section">
    <div class="photo-container" style="border-right: solid #1c1e21 1px;">
      <img src = "../assets/Photo/IMG_7007.jpg" alt=""/>
    </div>
    <div class="gallery-section description">
      <h2>
        Brooklyn Bridge
      </h2>
      <div>
        <p>
          Visit Brooklyn Bridge. Dec 24, 2023
          <br>
          <br>
        </p>
        <p style="font-style: italic;">
          "The bridge was very much cutting edge in so many of its aspects,” Richman told CBS News’ Michelle Miller.
          He also described the experience of being on the bridge as energizing, saying,
          The energy that you get up here as you shout above the traffic going by and the bicycles going by and the
          pedestrians going by and this is one of … human kind’s great creations, and to be able to enjoy it and stand
          under the towers and under the cables and the suspenders, it’s just wonderful."<br>
          <br>
          ------CBS News, Nov 27th, 2021
        </p>
        <p style="color: grey">
          Shot on iPhone 13 mini, South Street Seaport, Manhattan, NY, United States.
        </p>
      </div>
    </div>
  </section>
  <section class="gallery-section">
    <div class="gallery-section description" >
      <h2>
        Chinatown
      </h2>
      <div>
        <p>
          Visit Chinatown on South Manhattan. Dec 24, 2023
          <br>
          <br>
        </p>
        <p style="font-style: italic">
          去煲煲好("Kings Kitchen")的路上，图中高楼为 "One Manhattan Square" 公寓楼。
        </p>
        <p style="color: grey">
          Shot on iPhone 13 mini, Chinatown, Manhattan, NY, United States.
        </p>
      </div>
    </div>
    <div class="photo-container" style="border-left: solid #1c1e21 1px;">
      <img src = "../assets/Photo/IMG_7003.jpg" alt=""/>
    </div>
  </section>

  <section class="gallery-section">
    <div class="photo-container" style="border-right: solid #1c1e21 1px;">
      <img src = "../assets/Photo/IMG_7066.jpg" alt=""/>
    </div>
    <div class="gallery-section description">
      <h2>
        Delmonico's（“纽约的武康大楼”）
      </h2>
      <div>
        <p>
          Visit Delmonico's in Christmas Eve. Dec 24, 2023
          <br>
          <br>
        </p>
        <p style="font-style: italic;">
          Delmonico's, a historic name in New York City's restaurant scene, has been an influential force in American
          dining culture. Established in 1830 by Italian-Swiss immigrants Giovanni and Pietro Del-Monico (later known
          as John and Peter Delmonico in America), it began as a French restaurant named Delmonico and Brother at 23
          and 25 William Street. Before evolving into a restaurant, the establishment operated as a Parisian-style café,
          offering confectionaries, coffee, and wine.
          <br>
          <br>
          ------ChatGPT-4, 2024
        </p>
        <p style="color: grey">
          Shot on iPhone 13 mini, Wall Street, Manhattan, NY, United States.
        </p>
      </div>
    </div>
  </section>
  <section class="gallery-section">
    <div class="gallery-section description" >
      <h2>
        Lijiang, Yunnan, China
      </h2>
      <div>
        <p>
          Tea Horse Road (茶马古道) on Lijiang (丽江), Yunnan. Aug 13,2022
          <br>
          <br>
        </p>
        <p style="font-style: italic">
          云南丽江，茶马古道旁的小溪。
        </p>
        <p style="color: grey">
          Shot on iPhone 13 mini, Tea Horse Road, Lijiang, Yunnan, China.
        </p>
      </div>
    </div>
    <div class="photo-container" style="border-left: solid #1c1e21 1px;">
      <img src = "../assets/Photo/IMG_4457.jpg" alt=""/>
    </div>
  </section>
</template>

<style scoped>
.heading{
  padding-left: 60px;
}
.gallery-section{
  height: 100%;
  margin: 30px;
  display: grid;
  grid-template-columns: 1fr 1fr;
}
.gallery-section .description{

  display: flex;
  flex-direction: column;
}

.gallery-section h2{
  margin: 0;
  font-family: "Times New Roman", sans-serif;
}

.gallery-section p{

  margin: 0;
  padding-top: 0.5rem;
  font-family: "Times New Roman", serif;
}

.photo-container {

  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  height: 100%; /* 容器需要有明确的高度 */
}


.photo-container img{
  max-height: 80vh;
  max-width: 90%;
  width: auto;
  height: auto;
}

</style>
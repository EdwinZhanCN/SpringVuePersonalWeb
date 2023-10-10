<script>
export default {
  name:"daily-wrapper"
}
</script>

<template>
  <div id="daily" class="daily-wrapper">
    <picture class="pic-wrapper">
    </picture>
    <div class= "main-wrapper">
      <section class = "main-content">
        <h3>
          What's happening?
        </h3>
        <ul>
          <li>
            <a>
            <span>
                A research project about
            </span>
            </a>
          </li>
        </ul>
      </section>
    </div>
  </div>
</template>

<style scoped>

a{
  padding: 0;
}

.daily-wrapper{
  height: auto;
  max-width: 100%;
  max-height: 100%;
  padding-top: 55px;
  grid-gap: 2rem;
  display: grid;
  grid-template-columns: repeat(12,minmax(0,1fr));
  margin:0 auto;
}

@media screen and (min-width: 1422px){
  .daily-wrapper{
    height: 510px;
    max-width: 1422px;
    padding-top: 55px;
    grid-gap: 2rem;
    display: grid;
    grid-template-columns: repeat(12,minmax(0,1fr));
    margin:0 auto;
  }
}


.daily-wrapper .main-wrapper{
  border-radius: 15px;
  display: block;
  grid-column: span 5;
  background-color:#ffffff;
}


.daily-wrapper .pic-wrapper{
  display: block;
  grid-column: span 7;
  height: 510px;
  background-size: cover;
  background-position: center;
  overflow: hidden;
  border-radius: 15px;
  background-image: url("https://www.apple.com.cn/newsroom/images/live-action/keynote-march-2019/Apples-keynote-event_Roger_Rosner-03252019_big.jpg.large_2x.jpg");
  background-color: #c85a64;
}
.daily-wrapper ul{
  margin-block-end: 0;
  margin-block-start: 0;
}
.daily-wrapper h3{
  margin-block-end: 0;
  margin-block-start: 0;
}
</style>
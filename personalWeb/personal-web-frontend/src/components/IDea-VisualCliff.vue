<script>
export default {
  name:"visual-cliff"
}
</script>

<template>
  <div class="introduction">
    <p>My favorite Photographer: LinksPhotograph</p>
    <div class = "link-container">
      <a class = "link-style" href="https://www.youtube.com/channel/UCz0ONCn6eRcDJGsUzupc3TA" >
        See films from @linksphotograph on YouTube"
        <div class = "svg-container">
          <svg  xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
            <path d="M438.6 278.6c12.5-12.5 12.5-32.8 0-45.3l-160-160c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L338.8
          224 32 224c-17.7 0-32 14.3-32 32s14.3 32 32 32l306.7 0L233.4 393.4c-12.5 12.5-12.5
          32.8 0 45.3s32.8 12.5 45.3 0l160-160z"/></svg>
        </div>
      </a>
    </div>
  </div>
  <div class="parallax p1"></div>
  <div class="content" style="background-color: #2c3e50;">
    <p>
    </p>
    <iframe width="100%" height="100%" src="https://www.youtube.com/embed/oAIBHmeuKyQ?si=b3rBX1_7e_uKnwTR"
            title="YouTube video player" frameborder="0" allow="accelerometer;
            autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen>
    </iframe>
    <p>
    </p>
  </div>
  <div class="parallax p2"></div>
  <div class="content" style="background-color: #6880a6">
    <p>
    </p>
    <iframe width="100%" height="100%" src="https://www.youtube.com/embed/rGmoljGmKPI?si=rmcX1zGGce6GaUHl"
              title="YouTube video player" frameborder="0" allow="accelerometer;
              autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture;
              web-share" allowfullscreen>
    </iframe>
    <p>
    </p>
  </div>
  <div class="parallax p3"></div>
  <div class="content" style="background-color: #bdc2d5">
    <p style="color: #c89263">
    </p>
    <iframe width="100%" height="100%" src="https://www.youtube.com/embed/4pIJluV19HY?si=hkNjTLGsKDUpQn-1"
              title="YouTube video player" frameborder="0" allow="accelerometer;
              autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen>
    </iframe>
    <p style="color: #c89263">
    </p>
  </div>
  <div class="parallax p4"></div>
</template>

<style scoped>
.parallax{
  width: 100%;
  height: 80vh;
  position: relative;
  overflow: hidden;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: top center;
  background-attachment: fixed;
  z-index: 0;
}

.p1{
  background-image: url("./image/DSC1689-1536x864.jpeg");
}

.p2{
  background-image: url("./image/DSC6601-1536x864.jpg");
}

.p3{
  background-image: url("./image/Travel-to-Western-Fukushima-1-1536x586.jpg");
}

.p4{
  background-image: url("./image/IMG_6224-1536x1024.jpg");
}
.introduction{
display: none;
}
@media screen and (min-width: 500px) {
  .introduction{
    display: grid;
    background: rgba(255, 255, 255, 0.2);
    -webkit-backdrop-filter: blur(8px);
    backdrop-filter: blur(8px);
    box-shadow:inset 0 0 6px rgba(255, 255, 255, 0.2);
    border-radius: 20px;
    z-index: 1000;
    top: 3vh;
    position: sticky;
    height: auto;
    width: auto;
    max-width: 559px;
    left: calc(50% - 280px);
    margin-bottom: 20px;
  }
}

.link-style{
  display: flex;
  flex-direction: row;
  width: auto;
  justify-content: center;
  height: auto;
  align-items: center;
  color: #293541;
  cursor: pointer;
  padding-bottom: 10px;
}

.svg-container{
  padding-left: 5px;
  width: 20px;
}

.link-style:hover .svg-container{
  animation: moveLeftRight 0.7s ease-in-out infinite alternate;
}

@keyframes moveLeftRight {
  0%{
    transform: translateX(+2px);
  }
  25% {
    transform: translateX(+5px);
  }
  100% {
    transform: translateX(-0px);
  }
}

.introduction p{
  margin-block-start: 0;
  margin-block-end: 0;
  padding: 10px 10px 0 10px;
  font-weight: bold;
  font-size: 28px;
  letter-spacing: 1px;
  text-align: center;
  color: #282828;
}

.content{
  width: 100%;
  height: 30vh;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 20px;
  text-align: center;

}

.content p{
  color: #edb98f;
  font-family: Futura, sans-serif;
  font-size: 25px;
  font-weight: bold;
  padding-top: 15%;
}

</style>
<template>
  <nav class="nav-list">
    <div class="list-item" v-for="(page, index) in pages" :key="index">
      {{ page.title }}
    </div>
    <div id = "block"></div>
  </nav>
</template>

<script>
export default {
  name: 'nav-list',
  data() {
    return {
      pages: [
        { title: 'iDea' },
        { title: 'Progress' },
        { title: 'self-intro' },
        { title: 'Blog' },
      ]
    }
  }
};
</script>

<style>

:root{
  --w: 60vw;
  --div_w: calc(var(--w)/4);
  --h: 44px;
  --r: 10px
}

.nav-list{
  z-index: 1;
  position: relative;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: space-between;
  width: var(--w);
  height: var(--h);
  border-radius: var(--r);
  background-color: rgb(199,199,204,.3);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}


.list-item{
  font-family: "Futura",sans-serif;
  width: var(--div_w);
  height: var(--h);
  cursor: pointer;
  text-align: center;
  border-radius: var(--r);
  display: inline-block;
  font-size: 18px;
  line-height: var(--h);
  text-decoration: none;
  user-select: none;
  z-index: 2;
}

.list-item:nth-child(2):hover ~ #block{
  left: var(--div_w);
}

.list-item:nth-child(3):hover ~ #block{
  left: calc(2 * var(--div_w));
}

.list-item:nth-child(4):hover ~ #block{

  left: calc(3 * var(--div_w));
}
.list-item:hover ~ #block{
  opacity: 1;
}

#block{
  opacity: 0;
  transition: .5s;
  width: var(--div_w);
  height: var(--h);
  border-radius: var(--r);
  background: rgb(174,174,178);
  position: absolute;
  left: 0;
  z-index: 0;
}
</style>


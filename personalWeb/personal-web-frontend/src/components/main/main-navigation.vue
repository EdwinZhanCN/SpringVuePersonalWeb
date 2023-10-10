<script>
import router from "@/router";
import {ref} from "vue"
export default {
  name:"main-navigation",
  setup() {
    const navItems = ref([
      { name: 'EdwinZhan', path: '/' },
      { name: 'iDea', path: '/idea' },
      { name: 'Self-intro', path: '/self-intro' },
      { name: 'Blog', path: '/blog' },
      { name: 'Progress', path: '/progress' },
    ]);

    const navigateTo = (path) => {
      router.push(path);
      console.log(`Navigating to: ${path}`);
    };

    return {
      navItems,
      navigateTo
    };
  }
};




</script>

<template>
  <nav id="navigation">
    <div class="nav-content">
      <ul class="nav-list">
        <li
            class="nav-item"
            v-for="item in navItems"
            :key="item.name"
            @click="navigateTo(item.path)"
        >
          <a class="nav-link">
            <span>{{ item.name }}</span>
          </a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<style scoped>
*{
  margin: 0;
}

a{
  padding: 0;
}

#navigation{
  display: none;
}


@media screen and (min-width: 615px){
  #navigation{
    display: block;
    position: fixed;
    top: 0;
    right: 0;
    left: 0;
    z-index: 999;
    width: 100%;
    height: 44px;
    background: rgba(0,0,0);
  }
}

#navigation .nav-content{
  margin: 0 auto;
  max-width: 980px;
  position: relative;
  z-index: 2;
  padding: 0 max(22px, env(safe-area-inset-right)) 0 max(22px, env(safe-area-inset-left));
}

#navigation .nav-list{
  width: auto;
  z-index: 3;
  cursor: default;
  margin: 0 -8px;
  height: 44px;
  display: flex;
  -webkit-box-pack: justify;
  justify-content:space-between;
}

#navigation .nav-item{
  list-style-type: none;
  box-sizing: border-box;
  display: inline-block;
  position: relative;
  height: 44px;
  z-index: 1;
  vertical-align: top;

}

#navigation .nav-link{
  font-size: 12px;
  font-weight: 400;
  line-height: 3.66667;
  color: wheat;
  position: relative;
  z-index: 1;
  display: inline-block;
  padding: 0 8px;
  height: 44px;
  background: no-repeat;
  text-decoration: none;
  white-space: nowrap;
  cursor: pointer;
  user-select: none;
}

#navigation .nav-link:hover{
  color: aliceblue;
}

</style>
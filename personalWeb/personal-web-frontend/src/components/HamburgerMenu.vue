<script setup>
</script>

<template>
<header>
  <input type="checkbox" id = "toggle">
  <label for="toggle">
    <div class="hamburger-container">
      <span></span>
      <span></span>
    </div>
  </label>

  <div class="nav-items">
    <ul>
      <li>Home</li>
      <li>iDea</li>
      <li>Progress</li>
      <li>self-intro</li>
      <li></li>
    </ul>
  </div>
</header>
</template>

<style scoped>

#toggle:checked +label + .box {
  background-color: cyan;
}

#toggle {
  display: none;
}

.hamburger-container{
  display: block;
  width: 20px;
  height: 20px;
  position: relative;
  top: 16px;
}

.hamburger-container span{
  display: block;
  height: 1px;
  background-color: #fff;
  position: relative;
  transition: transform .3s ease-in-out, top .3s ease-in-out .3s;
  top: 0;
}

.hamburger-container span:nth-child(2){
  margin-top: 7px;
}
#toggle:checked + label .hamburger-container span:nth-child(1){
  transform: rotate(45deg);
  top:4px;
  transition: top .3s ease-in-out, transform .3s ease-in-out .3s;
}

#toggle:checked + label .hamburger-container span:nth-child(2){
  transform: rotate(-45deg);
  top:-4px;
  transition: top .3s ease-in-out, transform .3s ease-in-out .3s;
}

header{
  background-color: #000;
  height: 44px;
  padding: 0 18px;
}

body{
  padding: 0;
  margin:0;
}
</style>
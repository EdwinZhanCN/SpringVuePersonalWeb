<template>
  <ul class="list">
    <li class="list-item" v-for="(page, index) in pages" :key="index">
      <a>{{ page.title }}</a>
    </li>
  </ul>
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
a{
  font-size: 18px;
  font-weight: bold;
  line-height: 3em;
  position: relative;
  display: inline-block;
  padding: 0 8px;
  height: 44px;
  background: no-repeat;
  text-decoration: none;
  white-space: nowrap;
  cursor: pointer;
  user-select: none;
}

.list{
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: space-between;
  width: auto;
  height: auto;
  border-radius: 10px;
  background-color: rgb(242,242,247);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
.list-item{
  font-family: "Helvetica Neue",serif;
  width: 10rem;
  cursor: pointer;
  text-align: center;
  list-style-type: none;
  border-radius: 10px;
  display: inline-block;
  position: relative;
}

.list-item:hover{
  background: rgb(229,229,234);
}
</style>


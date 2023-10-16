<script setup>
import { ref, onMounted, onUnmounted } from 'vue';
const tags = ref([
  {
    title: 'My first App',
    items: [
      { text: 'Introduction', class: 'list-link', href: '#intro', ariaCurrent: 'false' },
      { text: 'Fake Class', class: 'list-link', href: '#fakeClass', ariaCurrent: 'false' },
      { text: 'Game Logic', class: 'list-link', href: '#gameLogic', ariaCurrent: 'false' },
    ],
  },
  {
    title: 'My first java program',
    items: [
      { text: 'Introduction', class: 'list-link', href: '#intro2', ariaCurrent: 'false' },
      { text: 'Binary search', class: 'list-link', href: '#bisearch', ariaCurrent: 'false' },
      { text: 'Data selection', class: 'list-link', href: '#dataSelect', ariaCurrent: 'false' },
      { text: 'User Interaction', class: 'list-link', href: '#userInter', ariaCurrent: 'false' },
    ],
  },
]);


</script>

<template>
  <nav id="sidebar-link" class="sidebar">
    <div class="sidebar-inner">
      <aside class = "sidebar-inner-container">
        <section id = "nav">
          <div v-for="tag in tags" :key="tag.title">
            <header>
              <h2>{{ tag.title }}</h2>
            </header>
            <ul class="list">
              <li v-for="item in tag.items" :key="item.href">
                <a :class=item.class :href="item.href" :aria-current="item.ariaCurrent">
                  {{ item.text }}
                </a>
              </li>
            </ul>
          </div>
        </section>
      </aside>
    </div>
  </nav>
</template>

<style scoped>
*{
  margin: 0;
}

#nav{
  padding: 0;
  position: relative;
}

ul{
  padding:0;
}

a{
  text-decoration: none;
}

li{
  display: list-item;
  text-align: -webkit-match-parent;
}

.sidebar{
  display: none;
}

@media screen and (min-width: 615px){
  .sidebar{
    display: block;
    top: 20px;
    padding-top: 2rem;
    position: sticky;
    max-height: calc(100vh);
    align-self: start;
    width: 100%;
  }
}

.sidebar h2{
  font-weight: 500;
}

.sidebar .list{
  padding-top: 10px;
  list-style: none;
  padding-left: 0;
}

.sidebar .list-link:not(.button){
  color: black;
  border-left: 2px solid rgba(0,0,0,0.3);
  display: block;
  padding: .5rem 1rem;
  text-decoration: none;
}

.sidebar .list-link:not(.button) .active{
  border-left-color: #c85a64;
  background-color: rgba(146,187,143,0.6);
}

.sidebar .list-link:not(.button):hover{
  color: #92bb8f;
}
.sidebar .list li{
  font-size: 14px;
  margin: 0;
}

.sidebar-inner{
  font-family: Arial, Helvetica, sans-serif;
  display: flex;
}

.sidebar-inner-container a{
  animation-name: taglineEmerge;
  animation-duration: 1s;
  animation-fill-mode: forwards;
}


@keyframes taglineEmerge{
  0%{
    transform:translateY(50px);
    opacity:0
  }
  100%{
    transform:translateY(0px);
    opacity:1
  }
}
</style>
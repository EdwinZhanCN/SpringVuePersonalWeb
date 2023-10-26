<template>
  <div class = "navigation">
    <title-icon/>
    <list/>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import list from "@/components/navigation bar/List.vue";
import titleIcon from "@/components/navigation bar/titleIcon.vue";

export default defineComponent({
  components: {
    list,
    titleIcon,
  },
})

</script>

<style>
.navigation{
  display: none;
}
@media screen and (min-width: 980px) {
  .navigation {
    padding-top: 20px;
    padding-left: 53px;
    height: 50px;
    display: grid;
    grid-template-columns: 1fr 4fr;
    grid-gap: 2rem;
  }
}


</style>
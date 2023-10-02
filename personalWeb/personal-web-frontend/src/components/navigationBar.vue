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
    padding-left: 53px;
    padding-right: 53px;
    max-width: 957px;
    height: 50px;
    display: grid;
    grid-gap: 3rem;
    grid-template-columns: 2fr 7fr;
  }
}


</style>
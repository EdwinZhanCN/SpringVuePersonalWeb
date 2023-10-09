<div class="threeImg">
<div class="iconleft" @click="zuohua">
</div>
<div class="Containt">
  <ul :style="{'left':calleft + 'px', width: widthData + 'px'} " v-on:mouseover="stopmove()" v-on:mouseout="move()" class="imgBoxoul">
    <li v-for="(item,index) in dataList" :key="index" @click="gotodetails(item.id)" ref="lis">
      <img :src="item.thumb" />
      <div class="item-content">
        <p class="item-title">{{item.title}}</p>
        <div class="item-detail line-2">{{item.subtitle}}</div>
      </div>
    </li>
  </ul>
</div>
<div class="iconright" @click="youhua">
</div>
</div>

<script>
export default {
  data() {
    return {
      calleft: 0,
      speed:1
    };
  },

  created() {
    this.move();
  },
  mounted() {
    const imgBox = document.getElementsByClassName("imgBoxoul")[0];
    imgBox.innerHTML += imgBox.innerHTML;
  },
  props: ["dataList"],
  computed: {
    widthData(){
      return 240 * Number(this.dataList.length*2)
    }
  },
  methods: {
    //移动
    move() {
      this.timer = setInterval(this.starmove, 20);
    },
    //开始移动
    starmove() {
      this.calleft -= 1.2;//*this.speed
      if (this.calleft <= -1150) {
        this.calleft = 0;
      }
    },
    //鼠标悬停时停止移动
    stopmove() {
      clearInterval(this.timer);
    },
    //点击按钮左移
    zuohua() {
      this.calleft -= 240;//this.speed = 1
      if (this.calleft <= -1200) {
        this.calleft = 0;
      }
    },
    //点击按钮右移
    youhua() { //this.speed = -1
      this.calleft += 240;
      if (this.calleft >= 0) {
        this.calleft = -1200;
      }
    },

  }
};
</script>

<style>

.threeImg {
  position: relative;
}

.threeImg .Containt ul {
  margin: 0 auto;
  width: 2400px;
  position: absolute;
  left: 0;
  cursor: pointer;
  height: 100%;
  z-index: 10;
}

.threeImg .Containt ul li {
  float: left;
  width: 220px;
  height: 350px;
  margin-right: 20px;
  border-radius: 10px;
  overflow: hidden;
  background-color: #ffffff;
}

.threeImg .Containt ul li img {
  width: 100%;
  height: 263px;
}

.Containt {
  position: relative;
  padding: 60px 0;
  overflow-y: auto;
  width: 1200px;
  height: 365px;
  margin: 0 auto;
}

.iconleft {
  position: absolute;
  width: 20px;
  height: 80px;
  top: 35%;
  left: 15%;
  z-index: 99999;
  cursor: pointer;
}

.iconright {
  position: absolute;
  top: 37%;
  right: 15%;
  width: 20px;
  height: 80px;
  z-index: 99999;;
  cursor: pointer;
}
</style>

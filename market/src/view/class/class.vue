<template>
  <div class="wrapper" ref="wrapper">
    CLASS
    <ul class="content">
      <li>item1</li>
      <li>item2</li>
      <li>item3</li>
      <li>item4</li>
      <li>item5</li>
      <li>item6</li>
      <li>item7</li>
      <li>item8</li>
      <li>item9</li>
      <li>item10</li>
      <li>item11</li>
      <li>item12</li>
      <li>item13</li>
      <li>item14</li>
      <li>item15</li>
      <li>item16</li>
      <li>item17</li>
      <li>item18</li>
      <li>item19</li>
      <li>item20</li>
      <li>item21</li>
      <li>item22</li>
      <li>item23</li>
      <li>item24</li>
      <li>item25</li>
      <li>item26</li>
      <li>item27</li>
      <li>item28</li>
      <li>item29</li>
      <li>item30</li>
      <li>item31</li>
      <li>item32</li>
      <li>item33</li>
      <li>item34</li>
      <li>item35</li>
      <li>item36</li>
      <li>item37</li>
      <li>item38</li>
      <li>item39</li>
      <li>item40</li>
      <li>item41</li>
      <li>item42</li>
      <li>item43</li>
      <li>item44</li>
      <li>item45</li>
      <li>item46</li>
      <li>item47</li>
      <li>item48</li>
      <li>item49</li>
      <li>item50</li>
    </ul>
  </div>
</template>

<script>
  import BScroll from "better-scroll";

  export default {
    name: "class",
    data(){
      return {
        scroll:'',
        wrap:''
      }
    },
    mounted(){
      this.$nextTick(() => {
        this.wrap = document.querySelector('.wrapper');
        console.log(this.wrap);
        this.scroll = new BScroll(this.wrap, {
          probeType: 2,
          pullUpLoad: true,
        });

        this.scroll.on('scroll',(position) => {
          // console.log(position);
        });
        this.scroll.on('pullUpload',() => {
          console.log("load more");
        })
      });

    }
  }
</script>

<style scoped>
  .wrapper {
    background-color: skyblue;
    height: 100px;
    overflow: hidden;
  }
</style>

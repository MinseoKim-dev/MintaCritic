<template>
  <div id="app">
    <div class="top">
      MintaCritic
      <router-link v-if="this.$store.state.isLoggedIn" to="/logout"><a>로그아웃</a></router-link>
      <router-link v-else to="/login"><a>로그인</a></router-link>
      <router-link to="/register"><a>회원 가입</a></router-link>
    </div>
    <div class="left">
      <router-link to="/home"><button class="menu">홈</button></router-link><br>
      <router-link to="/search_album"><button class="menu">리뷰 작성하기</button></router-link>
      <router-link to="/register_album"><button class="menu">앨범 등록하기</button></router-link>
    </div>
    <div class="right">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: start;
  height: 100%;
  color: #2c3e50;
  margin-top: 0;
}
html, body {
  height: 100%;
  margin: 0;
  padding: 0;
}
template {
  height: 100%
}
div {
  height: 100%
}
a {
  float: right;
  font-size: small;
  margin-right: 10px;
}
div.top {
  width: 100%;
  height: 7%;
  font-size: xx-large;
  margin-left: 10px;
  margin-top: 10px;
}
div.left {
  align-content: center;
  width: 15%;
  height: 93%;
  overflow: auto;
  background-color: #F94C57;
  float: left;
  box-sizing: border-box;
  font-size: large;
  font-family: "Nanum Gothic", sans-serif;
}
div.right {
  width: 85%;
  height: 93%;
  overflow: auto;
  background-color: #C2CAD7;
  float: right;
  font-family: "Nanum Gothic", sans-serif;
  box-sizing: border-box;
}
button.menu {
  background-color: transparent;
  width: 100%;
  height: 40px;
  font-size: x-large;
  margin-top: 20px;
  color: white;
  border: none;
  text-align: center;
}
</style>

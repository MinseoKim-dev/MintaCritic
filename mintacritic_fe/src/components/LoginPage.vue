<template>
<form v-on:submit.prevent="login">
  ID: <input v-model="userid" type="text"/><br>
  PW: <input v-model="passwd" type="password"/><br>
  <button type="submit">로그인</button>
</form>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginPage",
  data: function() {
    return {
      userid: "",
      passwd: ""
    }
  },
  mounted() {
    if (this.$store.state.isLoggedIn) {
      alert('이미 로그인된 상태입니다.')
      this.$router.push('/main')
    }
  },
  methods: {
    login: function() {
      axios.get("/api/users/"+this.userid)
      .then((response) => {
        if (response.data == "") {
          alert('존재하지 않는 ID입니다.')
        } else {
          if (response.data == this.passwd) {
            //login success
            this.$store.state.isLoggedIn = true
            this.$store.state.userid = this.userid
            this.$store.state.nickname = response.data.nickname
            this.$router.push('/home')
          } else {
            alert('비밀번호가 일치하지 않습니다.')
          }
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
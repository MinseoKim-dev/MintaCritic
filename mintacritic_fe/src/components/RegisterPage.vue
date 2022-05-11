<template>
  <form v-on:submit.prevent="register">
    <label for="userid">ID: </label>
    <input v-model="userid" id="userid" type="text" /><button v-on:click="checkIDValidity">중복 확인</button><br>
    <label for="password">PW: </label>
    <input v-model="passwd" id="password" type="password" /><br>
    <label for="nickname">닉네임: </label>
    <input v-model="nickname" id="nickname" type="text" /><button v-on:click="checkNicknameValidity">중복 확인</button><br>
    <button type="submit">회원가입</button>
  </form>
</template>

<script>
import axios from "axios";

export default {
  name: "RegisterPage",
  data: function() {
    return {
      userid: "",
      passwd: "",
      nickname: "",
      hashedPassword: "",
      idValidityChecked: false,
      nicknameValidityChecked: false
    }
  },
  methods: {
    register: function() {
      if (this.idValidityChecked && this.nicknameValidityChecked) {
        console.log(this.userid)
        axios.post("/api/users", null, { params: {
            userid: this.userid,
            password: this.passwd,
            nickname: this.nickname
          }}).then((response) => {
          if (response.status == 200) {
            //success
            alert('회원 가입이 완료되었습니다.')
            this.$router.push('/login')
          }
        })
      } else {
        alert('먼저 ID와 닉네임 중복 확인을 해주세요.')
      }
    },
    checkIDValidity: function(e) {
      e.preventDefault()
      axios.get("/api/users/check/id/"+this.userid)
      .then((response) => {
        if (response.data > 0) {
          alert('이 ID는 사용중입니다.')
        } else {
          this.idValidityChecked = true
          alert('사용 가능한 ID입니다.')
        }
      })
    },
    checkNicknameValidity: function(e) {
      e.preventDefault()
      axios.get("/api/users/check/nickname/"+this.nickname)
      .then((response) => {
        console.log(response)
        if (response.data > 0) {
          alert('이 닉네임은 사용중입니다.')
        } else {
          this.nicknameValidityChecked = true
          alert('사용 가능한 ID입니다.')
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
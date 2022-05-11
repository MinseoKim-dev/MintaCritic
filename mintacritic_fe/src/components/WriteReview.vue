<template>
  <body>
  <img :src="coverArtUrl" alt="" width="300px" height="300px"><br>
  <h2>{{artist}} - {{title}}</h2>
  <form v-on:submit.prevent="saveReview">
    <h1>리뷰를 작성하세요!</h1>
    <input v-model="rate" id="rate" type="number" placeholder="Rate"/><br>
    <textarea v-model="comment" id="comment" rows="10" columns="50" aria-placeholder="Comment"></textarea><br>
    <button type="submit">리뷰 저장하기</button>
  </form>
  </body>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      rate: 0,
      comment: ''
    }
  },
  props: {
    artist: String,
    title: String,
    coverArtUrl: String
  },
  name: "WriteReview",

  methods: {
    saveReview: function() {
      console.log(this.$store.state.userid)
      axios.post(`/api/reviews/${this.artist}/${this.title}/${this.$store.state.userid}`, null, {params: {
          rate: this.rate,
          comment: this.comment
        }}).then((response) => {
        console.log(response.data)
        if (response.data.comment == "!!exist") {
          alert("이미 리뷰를 등록한 앨범입니다!")
        } else {
          alert("리뷰 등록 완료")
        }
        this.$router.push('/home')
      })
    }
  }
}
</script>

<style scoped>
input {
  margin-bottom: 5px;
}
</style>
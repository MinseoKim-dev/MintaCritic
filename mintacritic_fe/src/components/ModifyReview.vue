<template>
  <body>
  <form v-on:submit.prevent="modifyData">
    <h1>수정하실 정보를 입력하세요!</h1>
    <label for="rate">Rate: </label>
    <input v-model="rate" id="rate" type="number"/><br>`
    <textarea v-model="comment" id="comment" aria-placeholder="Comment"></textarea><br>
    <button type="submit">수정</button>
  </form>
  </body>
</template>

<script>
import axios from "axios";

export default {
  name: "ModifyReview",
  data: function() {
    return {
      rate: 0,
      comment: "",
    }
  },
  props: {
    artist: String,
    title: String,
  },
  methods: {
    modifyData: function () {
      console.log(this.artist)
      console.log(this.title)
      axios.put(`/api/reviews/${this.artist}/${this.title}/${this.$store.state.userid}`, null, { params: {
          rate: this.rate,
          comment: this.comment
        }}).then((response) => {
          console.log(response)
          this.$router.go(-2)
        })
    }
  }
}
</script>

<style scoped>

</style>
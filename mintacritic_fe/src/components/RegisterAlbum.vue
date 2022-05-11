<template>
<form v-on:submit.prevent="registerNewAlbum">
  <label for="artist">Artist: </label>
  <input v-model="artist" id="artist" type="text"/><br>
  <label for="title">Title: </label>
  <input v-model="title" id="title" type="text" /><br>
  <label for="coverArtUrl">Url of Cover Art: </label>
  <input v-model="coverArtUrl" id="coverArtUrl" type="text"/><br>
  <button type="submit">등록</button>
</form>
</template>

<script>
import axios from "axios";

export default {
  name: "RegisterAlbum",
  data: function() {
    return {
      artist: "",
      title: "",
      coverArtUrl: ""
    }
  },
  methods: {
    registerNewAlbum: function() {
      axios.post("/api/albums", null , { params: {
          artist: this.artist,
          title: this.title,
          coverArtUrl: this.coverArtUrl
        }}).then((response) => {
        if (response.status == 200) {
          alert('앨범 등록이 완료되었습니다.')
          this.$router.go(-1)
        } else {
          console.log(response)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
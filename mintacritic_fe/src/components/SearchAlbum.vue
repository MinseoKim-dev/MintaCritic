<template>
<body>
  <form v-on:submit.prevent="searchAlbum">
    <h1>리뷰를 작성하려는 앨범을 검색하세요!</h1>
    <label for="artist">Artist: </label>
    <input v-model="artist" id="artist" type="text"/><br>
    <label for="title">Title: </label>
    <input v-model="title" id="title" type="text" /><br>
    <button type="submit">검색</button>
  </form>
  <b v-if="this.hasSearched">
  <img v-if="this.hasFound" :src="this.coverArtUrl" width="250px" height="250px" alt="" v-on:click="goToWriteReview" />
  <p v-else>찾으시는 앨범이 없습니다. <button v-on:click="goToRegisterAlbum">등록하러 가기</button></p>
  </b>
</body>
</template>

<script>
import axios from "axios";

export default {
  name: "SearchAlbum",
  data: function() {
    return {
      artist: "",
      title: "",
      coverArtUrl: "",
      hasSearched: false,
      hasFound: false
    }
  },
  methods: {
    searchAlbum: function() {
      this.hasSearched = true
      axios.get("api/albums/"+this.artist+"/"+this.title)
      .then((response) => {
        if (response.data.artist == "") {
          this.hasFound = false
        } else {
          this.coverArtUrl = response.data.coverArtUrl
          this.hasFound = true
        }
      })
    },
    goToRegisterAlbum: function() {
      this.$router.push('/register_album')
    },
    goToWriteReview: function() {
      this.$router.push({name: 'writeReview', params: {artist: this.artist, title: this.title, coverArtUrl: this.coverArtUrl}})
    }
  }
}
</script>

<style scoped>
body {
  margin-top: 20px;
  margin-left: 20px;
}

</style>
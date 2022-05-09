<template>
  <form v-on:submit="saveAlbum">
    <h1>리뷰를 작성하세요!</h1>
    <label for="artist">Artist: </label>
    <input v-model="artist" id="artist" type="text"/><br>
    <label for="title">Title: </label>
    <input v-model="title" id="title" type="text" /><br>
    <input v-model="rate" type="number" placeholder="Rate"/>
    <input v-model="trackList" type="text" placeholder="TrackList"/>
    <input v-model="coverArtUrl" id="coverart" type="text" placeholder="Cover Art Url">
    <textarea v-model="comment" id="comment" aria-placeholder="Comment"></textarea>
    <button type="submit">Save Album</button>
  </form>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      artist: '',
      title: '',
      rate: 0,
      trackList: '',
      coverArtUrl: '',
      comment: ''
    }
  },
  name: "WriteReview",

  methods: {
    saveAlbum: function() {
      axios.post("/api", {
        artist: this.artist,
        title: this.title,
        rate: this.rate,
        trackList: this.trackList,
        coverArtUrl: this.coverArtUrl,
        comment: this.comment
      }).then(function(response) {
        console.log(response.data)
      })
    }
  }
}
</script>

<style scoped>

</style>
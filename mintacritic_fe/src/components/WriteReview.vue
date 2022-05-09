<template>
  <form v-on:submit="saveAlbum">
    <input v-model="artist" type="text" placeholder="Artist"/>
    <input v-model="title" type="text" placeholder="Title"/>
    <input v-model="rate" type="number" placeholder="Rate"/>
    <input v-model="trackList" type="text" placeholder="TrackList"/>
    <input v-model="coverArtUrl" type="text" placeholder="Cover Art Url">
    <textarea v-model="comment" aria-placeholder="Comment"></textarea>
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
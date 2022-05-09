<template>
  <div class="hello">
    <img v-for="(url, index) in urls" :key="url" id="cover" :src="url" alt="" height="100px" width="100px" v-on:click="goToReview(artists[index], titles[index])">
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'MainPage',
  data() {
    return {
      urls: [],
      artists: [],
      titles: []
    }
  },
  props: {
    msg: String
  },

  mounted: function() {
      this.fetchData()
  },

  methods: {
    fetchData: function() {
       axios.get("/api")
      .then((response) => {
        //console.log(response.data[1])
        response.data.forEach(e => {
          this.urls.push(e.coverArtUrl)
          this.artists.push(e.artist)
          this.titles.push(e.title)
        })
      })
    },
    goToReview: function(artist, title) {
      this.$router.push({name: 'review', params: {artist: artist, title: title}})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

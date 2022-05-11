<template>
  <div class="hello">
    <img v-for="(url, index) in urls" :key="url" id="cover" :src="url" alt="" height="150px" width="150px" v-on:click="goToReview(artists[index], titles[index], url)">
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
    if (this.$store.state.isLoggedIn) {
      this.fetchData()
    } else {
      console.log(this.$store.state)
      this.$router.push('/login')
    }
  },

  methods: {
    fetchData: function() {
       axios.get("/api/reviews/"+this.$store.state.userid)
      .then((response) => {
        console.log(response)
        response.data.forEach(e => {
          console.log(e)
          this.urls.push(e.album.coverArtUrl)
          this.artists.push(e.album.artist)
          this.titles.push(e.album.title)
        })
      })
    },
    goToReview: function(artist, title, url) {
      this.$router.push({name: 'review', params: {artist: artist, title: title, coverArtUrl: url}})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

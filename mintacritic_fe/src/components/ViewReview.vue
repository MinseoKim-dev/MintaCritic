<template>
  <div id="content">
    <img id="cover" :src="coverArtUrl" alt="" height="300px" width="300px"><br>
    Artist: {{artist}}<br>
    Title: {{title}}<br>
    Track List: {{trackList}}<br>
    Rate: {{rate}}<br>
    Your Comment: {{comment}}<br>
    <button v-on:click="deleteReview">이 리뷰 삭제하기</button><br>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ViewReview",
  data() {
    return {
      rate: 0,
      trackList: "",
      coverArtUrl: "",
      comment: ""
    }
  },
  props: {
    artist: String,
    title: String
  },
  mounted: function() {
    this.getAlbumInfo()
  },
  methods: {
    getAlbumInfo: function() {
      axios.get("/api/"+this.artist+"/"+this.title)
      .then((response) => {
        console.log(response)
        this.rate = response.data.rate
        this.trackList = response.data.trackList
        this.coverArtUrl = response.data.coverArtUrl
        this.comment = response.data.comment
      })
    },
    deleteReview: function() {
      axios.delete("/api/"+this.artist+"/"+this.title)
      .then((response) => {
        console.log(response)
        this.$router.push('/home')
      })
    }
  }

}
</script>

<style scoped>
#content {
  font-size: large
}

</style>
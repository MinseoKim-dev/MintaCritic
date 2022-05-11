<template>
  <div id="content">
    <img id="cover" :src="coverArtUrl" alt="" height="300px" width="300px"><br>
    <p>Artist: {{artist}}<br></p>
    <p>Title: {{title}}<br></p>
    <p>Rate: {{rate}}<br></p>
    <p>Your Comment: {{comment}}<br></p>
    <button v-on:click="deleteReview">이 리뷰 삭제하기</button><br>
    <button v-on:click="modifyReview(artist, title)">이 리뷰 수정하기</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ViewReview",
  data() {
    return {
      rate: 0,
      comment: ""
    }
  },
  props: {
    artist: String,
    title: String,
    coverArtUrl: String
  },
  mounted: function() {
    if (this.$store.state.isLoggedIn) {
      this.getAlbumInfo();
    } else {
      alert('로그인 정보가 없습니다!')
    }

  },
  methods: {
    getAlbumInfo: function() {
      axios.get(`/api/reviews/${this.artist}/${this.title}/${this.$store.state.userid}`)
      .then((response) => {
        console.log(response)
        this.rate = response.data.rate
        this.comment = response.data.comment
      })
    },
    deleteReview: function() {
      axios.delete(`/api/reviews/${this.artist}/${this.title}/${this.$store.state.userid}`)
      .then((response) => {
        console.log(response)
        this.$router.push('/home')
      })
    },
    modifyReview: function(artist, title) {
      this.$router.push({name: 'modify', params: {artist: artist, title: title}})
    }
  }

}
</script>

<style scoped>
#content {
  font-size: large
}

</style>
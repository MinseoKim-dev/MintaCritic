<template>
  <div class="hello">
    <img id="cover" :src="url" alt="" height="100px" width="100px">
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'MainPage',
  data() {
    return {
      url: ''
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
        this.url = response.data[1].coverArtUrl
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>

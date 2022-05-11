<template>
<body>
</body>
</template>

<script>
export default {
  name: "LogoutPage",
  mounted: function() {
    this.logout()
  },
  methods: {
    logout: function() {
      this.$store.state.isLoggedIn = false
      this.$store.state.userid = ""
      this.$store.state.nickname = ""
      this.$router.push('/home')
    }
  }
}
</script>

<style scoped>

</style>
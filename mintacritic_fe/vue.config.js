const { defineConfig } = require('@vue/cli-service')
module.exports = {
  transpileDependencies: true,
  outputDir: "../src/main/resources/static",
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:9080',
        changeOrigin: true
      }
    }
  }
}

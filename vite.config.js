import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': resolve(__dirname, 'src')
    }
  },
  build: {
    outDir: 'dist',
    assetsDir: 'assets'
  },
  server: {
    host: '0.0.0.0',
    port: 5173,
    allowedHosts: ['.cpolar.top', '.cpolar.cn', 'localhost', '127.0.0.1', '0.0.0.0']
  },
  preview: {
    host: '0.0.0.0',
    port: 4173,
    allowedHosts: ['.cpolar.top', '.cpolar.cn', 'localhost', '127.0.0.1', '0.0.0.0']
  }
})
<template>
  <div class="app">
    <NavHeader />
    <main>
      <router-view />
    </main>
    <FooterSection />
  </div>
</template>

<script setup>
import NavHeader from './components/NavHeader.vue'
import FooterSection from './components/FooterSection.vue'
</script>

<style>
html {
  scroll-behavior: smooth;
}

body {
  margin: 0;
  padding: 0;
  font-family: 'Inter', sans-serif;
  background: linear-gradient(
    180deg,
    #0f0f14 0%,
    #111118 8%,
    #13131c 16%,
    #15151e 24%,
    #17171f 32%,
    #191921 40%,
    #1b1b23 48%,
    #1d1d25 56%,
    #1f1f27 64%,
    #1d1d25 72%,
    #1b1b23 80%,
    #191921 88%,
    #17171f 96%,
    #0f0f14 100%
  );
  color: #e8e8e8;
  min-height: 100vh;
  position: relative;
}

body::before {
  content: '';
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  pointer-events: none;
  opacity: 0.03;
  z-index: 9999;
  background-image: url("data:image/svg+xml,%3Csvg viewBox='0 0 256 256' xmlns='http://www.w3.org/2000/svg'%3E%3Cfilter id='noise'%3E%3CfeTurbulence type='fractalNoise' baseFrequency='0.9' numOctaves='4' stitchTiles='stitch'/%3E%3C/filter%3E%3Crect width='100%25' height='100%25' filter='url(%23noise)'/%3E%3C/svg%3E");
}

::-webkit-scrollbar {
  width: 6px;
}

::-webkit-scrollbar-track {
  background: #0d0d0f;
}

::-webkit-scrollbar-thumb {
  background: linear-gradient(180deg, #6b7b8c, #9b8aa5);
  border-radius: 3px;
}

::-webkit-scrollbar-thumb:hover {
  background: linear-gradient(180deg, #7b8b9c, #ab9ab5);
}

main {
  position: relative;
  z-index: 1;
}
</style>
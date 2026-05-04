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
  background: linear-gradient(135deg, #0f0f1a 0%, #1a1a2e 50%, #16213e 100%);
  color: #fff;
  min-height: 100vh;
}

::-webkit-scrollbar {
  width: 8px;
}

::-webkit-scrollbar-track {
  background: #1a1a2e;
}

::-webkit-scrollbar-thumb {
  background: linear-gradient(180deg, #6c5ce7, #a29bfe);
  border-radius: 4px;
}

::-webkit-scrollbar-thumb:hover {
  background: linear-gradient(180deg, #7c6ce7, #b2a9fe);
}
</style>
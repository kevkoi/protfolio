<template>
  <div class="home">
    <HeroSection />
    <AboutPreview />
    <MusicShowcase />
    <GallerySection />
    <ContactSection />
  </div>
</template>

<script setup>
import HeroSection from '../components/HeroSection.vue'
import AboutPreview from '../components/AboutPreview.vue'
import MusicShowcase from '../components/MusicShowcase.vue'
import GallerySection from '../components/GallerySection.vue'
import ContactSection from '../components/ContactSection.vue'
</script>

<style scoped>
.home {
  min-height: 100vh;
}
</style>
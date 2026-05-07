<template>
  <section class="gallery-section" id="gallery">
    <div class="section-header">
      <span class="section-label">Gallery</span>
      <h2 class="section-title">Visual <span class="gradient-text">Collection</span></h2>
      <p class="section-description">A glimpse into my creative journey through images</p>
    </div>
    
    <div class="gallery-grid">
      <div v-for="(image, index) in galleryImages" :key="index" 
           class="gallery-item"
           @click="openLightbox(index)">
        <img :src="image.src" :alt="image.alt" />
        <div class="image-overlay">
          <Search class="overlay-icon" />
          <span class="overlay-text">{{ image.title }}</span>
        </div>
      </div>
    </div>
    
    <div v-if="lightboxOpen" class="lightbox" @click="closeLightbox">
      <button class="lightbox-close" @click="closeLightbox">
        <X />
      </button>
      <button class="lightbox-prev" @click.stop="prevImage">
        <ChevronLeft />
      </button>
      <img :src="galleryImages[currentImage].src" :alt="galleryImages[currentImage].alt" />
      <button class="lightbox-next" @click.stop="nextImage">
        <ChevronRight />
      </button>
    </div>
  </section>
</template>

<script setup>
import { ref } from 'vue'
import { Search, X, ChevronLeft, ChevronRight } from 'lucide-vue-next'

const galleryImages = [
  { src: '/images/gallery/19A2578.jpg', alt: 'Studio Session', title: 'Studio Session' },
  { src: '/images/gallery/B19A2552.jpg', alt: 'Performance', title: 'Live Performance' },
  { src: '/images/albums/EP-Cover.png', alt: 'EP Cover', title: 'EP Cover Art' },
  { src: '/images/profiles/头像.jpg', alt: 'Portrait', title: 'Portrait' }
]

const lightboxOpen = ref(false)
const currentImage = ref(0)

const openLightbox = (index) => {
  currentImage.value = index
  lightboxOpen.value = true
  document.body.style.overflow = 'hidden'
}

const closeLightbox = () => {
  lightboxOpen.value = false
  document.body.style.overflow = ''
}

const prevImage = () => {
  currentImage.value = (currentImage.value - 1 + galleryImages.length) % galleryImages.length
}

const nextImage = () => {
  currentImage.value = (currentImage.value + 1) % galleryImages.length
}
</script>

<style scoped>
.gallery-section {
  padding: 6rem 2rem;
  background: transparent;
}

.section-header {
  text-align: center;
  margin-bottom: 4rem;
}

.section-label {
  color: #9b8aa5;
  font-size: 0.9rem;
  font-weight: 600;
  letter-spacing: 2px;
  text-transform: uppercase;
}

.section-title {
  font-family: 'Playfair Display', serif;
  font-size: 2.5rem;
  margin: 0.5rem 0;
}

.gradient-text {
  background: linear-gradient(135deg, #9b8aa5, #6b7b8c);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.section-description {
  color: rgba(138, 138, 143, 0.8);
  margin: 0;
}

.gallery-grid {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 1.5rem;
}

.gallery-item {
  position: relative;
  border-radius: 15px;
  overflow: hidden;
  cursor: pointer;
  transition: all 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
  aspect-ratio: 1 / 1;
}

.gallery-item:hover {
  transform: scale(1.03);
  box-shadow: 0 10px 40px rgba(155, 138, 165, 0.3);
}

.gallery-item img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: filter 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.gallery-item:hover img {
  filter: brightness(0.7);
}

.image-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(155, 138, 165, 0.6);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  opacity: 0;
  transition: opacity 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.gallery-item:hover .image-overlay {
  opacity: 1;
}

.overlay-icon {
  width: 40px;
  height: 40px;
  margin-bottom: 0.5rem;
  color: #0d0d0f;
}

.overlay-text {
  font-weight: 600;
  color: #0d0d0f;
}

.lightbox {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.9);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.lightbox-close {
  position: absolute;
  top: 1rem;
  right: 1rem;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.1);
  border: none;
  color: #fff;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: background 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.lightbox-close:hover {
  background: rgba(255, 255, 255, 0.2);
}

.lightbox-prev,
.lightbox-next {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.1);
  border: none;
  color: #fff;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: background 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.lightbox-prev:hover,
.lightbox-next:hover {
  background: rgba(255, 255, 255, 0.2);
}

.lightbox-prev {
  left: 1rem;
}

.lightbox-next {
  right: 1rem;
}

.lightbox img {
  max-width: 90vw;
  max-height: 90vh;
  border-radius: 10px;
}

@media (max-width: 768px) {
  .gallery-grid {
    grid-template-columns: 1fr;
  }
  
  .gallery-item.large,
  .gallery-item.medium,
  .gallery-item.small {
    grid-row: span 1;
  }
  
  .section-title {
    font-size: 2rem;
  }
}
</style>

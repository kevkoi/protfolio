<template>
  <section class="hero" id="hero">
    <div class="hero-content">
      <div class="hero-text">
        <div class="hero-subtitle animate-fade-in-up">
          <span class="music-note">♪</span> Songwriter & Topliner
        </div>
        <h1 class="hero-title animate-fade-in-up" style="animation-delay: 0.2s;">
          Amy <span class="gradient-text">Ren</span>
        </h1>
        <p class="hero-description animate-fade-in-up" style="animation-delay: 0.4s;">
          Crafting emotionally intimate pop and R&B ballads that translate 
          quiet, personal experiences into empathetic songs.
        </p>
        <div class="hero-buttons animate-fade-in-up" style="animation-delay: 0.6s;">
          <button class="btn btn-primary" @click="scrollToMusic">
            <Music /> Listen Now
          </button>
          <button class="btn btn-secondary" @click="scrollToContact">
            <MessageCircle /> Get in Touch
          </button>
        </div>
      </div>
      
      <div class="hero-visual animate-fade-in-up" style="animation-delay: 0.3s;">
        <div class="artist-image">
          <img src="/images/profiles/头像.jpg" alt="Amy Ren" />
        </div>
      </div>
    </div>
    
    <div class="scroll-indicator">
      <div class="scroll-arrow"></div>
    </div>
  </section>
</template>

<script setup>
import { Music, MessageCircle } from 'lucide-vue-next'

const scrollToMusic = () => {
  const element = document.getElementById('music-showcase')
  if (element) {
    element.scrollIntoView({ behavior: 'smooth' })
  }
}

const scrollToContact = () => {
  const element = document.getElementById('contact')
  if (element) {
    element.scrollIntoView({ behavior: 'smooth' })
  }
}
</script>

<style scoped>
.hero {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  overflow: hidden;
  padding: 6rem 2rem 2rem;
  background: transparent;
}

.hero::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: radial-gradient(ellipse at center, rgba(155, 138, 165, 0.12) 0%, transparent 70%);
  pointer-events: none;
}

.hero-content {
  max-width: 1200px;
  width: 100%;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
  position: relative;
  z-index: 1;
}

.hero-subtitle {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  color: #9b8aa5;
  font-size: 1.1rem;
  font-weight: 500;
  margin-bottom: 1rem;
}

.music-note {
  /* 移除 bounce 动画 */
}

@keyframes bounce {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-8px); }
}

.hero-title {
  font-family: 'Playfair Display', serif;
  font-size: 3.5rem;
  line-height: 1.2;
  margin-bottom: 1.5rem;
}

.gradient-text {
  background: linear-gradient(135deg, #9b8aa5, #6b7b8c);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.hero-description {
  color: rgba(138, 138, 143, 0.7);
  font-size: 1.1rem;
  line-height: 1.8;
  margin-bottom: 2rem;
  max-width: 500px;
}

.hero-buttons {
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

.btn {
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
  padding: 0.875rem 2rem;
  border-radius: 30px;
  font-weight: 600;
  text-decoration: none;
  transition: all 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
  border: none;
  cursor: pointer;
}

.btn-primary {
  background: linear-gradient(135deg, #6b7b8c, #9b8aa5);
  color: #0d0d0f;
}

.btn-primary:hover {
  transform: translateY(-3px);
  box-shadow: 0 10px 30px rgba(107, 123, 140, 0.4);
}

.btn-secondary {
  background: transparent;
  color: #e8e8e8;
  border: 2px solid #6b7b8c;
}

.btn-secondary:hover {
  background: #6b7b8c;
  color: #0d0d0f;
}

.hero-visual {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

.artist-image {
  position: relative;
  width: 400px;
  height: 400px;
  border-radius: 50%;
  overflow: hidden;
  box-shadow: 0 20px 60px rgba(155, 138, 165, 0.3);
  animation: pulse-glow 3s ease-in-out infinite;
}

.artist-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

@keyframes pulse-glow {
  0%, 100% { box-shadow: 0 20px 60px rgba(155, 138, 165, 0.3); }
  50% { box-shadow: 0 20px 80px rgba(155, 138, 165, 0.5); }
}

.scroll-indicator {
  position: absolute;
  bottom: 2rem;
  left: 50%;
  transform: translateX(-50%);
  animation: bounce 2s ease-in-out infinite;
}

.scroll-arrow {
  width: 30px;
  height: 50px;
  border: 2px solid rgba(155, 138, 165, 0.5);
  border-radius: 25px;
  position: relative;
}

.scroll-arrow::before {
  content: '';
  position: absolute;
  top: 10px;
  left: 50%;
  transform: translateX(-50%);
  width: 6px;
  height: 6px;
  background: #9b8aa5;
  border-radius: 50%;
  animation: scroll-bounce 1.5s ease-in-out infinite;
}

@keyframes scroll-bounce {
  0%, 100% { top: 10px; opacity: 1; }
  50% { top: 25px; opacity: 0.5; }
}

@media (max-width: 900px) {
  .hero-content {
    grid-template-columns: 1fr;
    text-align: center;
    gap: 2rem;
  }
  
  .hero-title {
    font-size: 2.5rem;
  }
  
  .artist-image {
    width: 300px;
    height: 300px;
  }
  
  .hero-description {
    margin: 0 auto 2rem;
  }
  
  .hero-buttons {
    justify-content: center;
  }
}
</style>

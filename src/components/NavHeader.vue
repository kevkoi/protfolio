<template>
  <nav class="navbar" :class="{ 'navbar-scrolled': isScrolled }">
    <div class="nav-container">
      <div class="nav-logo" @click="scrollToSection('#hero')">
        <span class="logo-icon">♪</span>
        <span class="logo-text">Amy Ren</span>
      </div>
      
      <div class="nav-links" :class="{ 'nav-links-active': isMenuOpen }">
        <a v-for="link in navLinks" :key="link.name" 
           :href="link.path" 
           class="nav-link"
           @click.prevent="scrollToSection(link.path); isMenuOpen = false">
          {{ link.name }}
        </a>
      </div>
      
      <button class="nav-toggle" @click="isMenuOpen = !isMenuOpen">
        <span class="bar"></span>
        <span class="bar"></span>
        <span class="bar"></span>
      </button>
    </div>
  </nav>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'

const isScrolled = ref(false)
const isMenuOpen = ref(false)

const navLinks = [
  { name: 'Home', path: '#hero' },
  { name: 'About', path: '#about-preview' },
  { name: 'Music', path: '#music-showcase' },
  { name: 'Gallery', path: '#gallery' },
  { name: 'Contact', path: '#contact' }
]

const handleScroll = () => {
  isScrolled.value = window.scrollY > 50
}

const scrollToSection = (path) => {
  if (path === '#hero') {
    window.scrollTo({ top: 0, behavior: 'smooth' })
    return
  }
  const element = document.querySelector(path)
  if (element) {
    element.scrollIntoView({ behavior: 'smooth' })
  }
}

onMounted(() => {
  window.addEventListener('scroll', handleScroll)
})

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll)
})
</script>

<style scoped>
.navbar {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  background: transparent;
  transition: all 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
  padding: 1rem 0;
}

.navbar-scrolled {
  background: rgba(13, 13, 15, 0.95);
  backdrop-filter: blur(10px);
  box-shadow: 0 2px 20px rgba(0, 0, 0, 0.4);
}

.nav-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.nav-logo {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  cursor: pointer;
  padding: 0.5rem 0;
}

.logo-icon {
  font-size: 1.8rem;
  background: linear-gradient(135deg, #9b8aa5, #6b7b8c);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  animation: pulse 2s ease-in-out infinite;
}

@keyframes pulse {
  0%, 100% { opacity: 1; }
  50% { opacity: 0.7; }
}

.logo-text {
  font-family: 'Playfair Display', serif;
  font-size: 1.5rem;
  font-weight: 600;
  background: linear-gradient(135deg, #e8e8e8, #9b8aa5);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.nav-links {
  display: flex;
  align-items: center;
  gap: 2.5rem;
}

.nav-link {
  color: rgba(138, 138, 143, 0.85);
  text-decoration: none;
  font-weight: 500;
  font-size: 0.95rem;
  transition: all 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
  position: relative;
  padding: 0.5rem 0;
}

.nav-link::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 0;
  height: 2px;
  background: linear-gradient(90deg, #6b7b8c, #9b8aa5);
  transition: width 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.nav-link:hover {
  color: #e8e8e8;
}

.nav-link:hover::after {
  width: 100%;
}

.nav-toggle {
  display: none;
  flex-direction: column;
  gap: 5px;
  background: none;
  border: none;
  cursor: pointer;
}

.bar {
  width: 25px;
  height: 2px;
  background: #fff;
  transition: all 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.nav-toggle.active .bar:nth-child(1) {
  transform: rotate(-45deg) translate(-5px, 6px);
}

.nav-toggle.active .bar:nth-child(2) {
  opacity: 0;
}

.nav-toggle.active .bar:nth-child(3) {
  transform: rotate(45deg) translate(-5px, -6px);
}

@media (max-width: 768px) {
  .nav-links {
    position: fixed;
    top: 70px;
    left: -100%;
    width: 100%;
    height: calc(100vh - 70px);
    background: rgba(13, 13, 15, 0.98);
    backdrop-filter: blur(10px);
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    padding-top: 2rem;
    gap: 2rem;
    transition: left 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
  }
  
  .nav-links.nav-links-active {
    left: 0;
  }
  
  .nav-link {
    font-size: 1.1rem;
    padding: 0.75rem 0;
  }
  
  .nav-toggle {
    display: flex;
  }
}
</style>

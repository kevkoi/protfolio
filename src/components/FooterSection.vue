<template>
  <footer class="footer">
    <div class="footer-content">
      <div class="footer-section">
        <div class="footer-logo">
          <span class="logo-icon">♪</span>
          <span class="logo-text">Harmony</span>
        </div>
        <p class="footer-description">
          A musical journey through sound and creativity.
        </p>
        <div class="social-links">
          <a href="https://www.instagram.com/amyyren_?igsh=Zm1hbDlrcmR3enlk&utm_source=qr" class="social-link">
            <Instagram />
          </a>
        </div>
      </div>
      
      <div class="footer-section">
        <h3>Quick Links</h3>
        <ul class="footer-links">
          <li><a href="#hero">Home</a></li>
          <li><a href="#about-preview">About</a></li>
          <li><a href="#music-showcase">Music</a></li>
          <li><a href="#gallery">Gallery</a></li>
          <li><a href="#contact">Contact</a></li>
        </ul>
      </div>
    </div>
    
    <div class="footer-bottom">
      <p>&copy; 2024 Amy Ren. All rights reserved.</p>
    </div>
  </footer>
</template>

<script setup>
import { Instagram } from 'lucide-vue-next'
</script>

<style scoped>
.footer {
  padding: 3rem 2rem 1.5rem;
  background: #1a1512;
}

.footer-content {
  max-width: 800px;
  margin: 0 auto;
  padding: 0 2rem;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 2rem;
}

.footer-section {
  text-align: center;
}

.footer-logo {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 0.5rem;
  margin-bottom: 0.75rem;
}

.logo-icon {
  font-size: 1.6rem;
  background: linear-gradient(135deg, #c9a962, #e8d5b7);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.logo-text {
  font-family: 'Playfair Display', serif;
  font-size: 1.4rem;
  font-weight: 600;
  background: linear-gradient(135deg, #f5f0e8, #e8d5b7);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.footer-description {
  color: rgba(197, 184, 168, 0.6);
  font-size: 0.9rem;
  margin-bottom: 1rem;
}

.social-links {
  display: flex;
  justify-content: center;
  gap: 1rem;
}

.social-link {
  width: 36px;
  height: 36px;
  border-radius: 50%;
  background: rgba(201, 169, 98, 0.15);
  display: flex;
  justify-content: center;
  align-items: center;
  color: #e8d5b7;
  transition: all 0.3s ease;
}

.social-link:hover {
  background: linear-gradient(135deg, #c9a962, #b8860b);
  color: #fff;
  transform: translateY(-2px);
}

.footer-section h3 {
  color: #f5f0e8;
  margin-bottom: 0.75rem;
  font-family: 'Playfair Display', serif;
  font-size: 1.1rem;
}

.footer-links {
  list-style: none;
  padding: 0;
}

.footer-links li {
  margin-bottom: 0.4rem;
}

.footer-links a {
  color: rgba(197, 184, 168, 0.6);
  text-decoration: none;
  font-size: 0.9rem;
  transition: color 0.3s ease;
}

.footer-links a:hover {
  color: #c9a962;
}

.footer-bottom {
  text-align: center;
  padding-top: 1.5rem;
  margin-top: 1.5rem;
  border-top: 1px solid rgba(255, 255, 255, 0.08);
  color: rgba(197, 184, 168, 0.5);
  font-size: 0.85rem;
}
</style>

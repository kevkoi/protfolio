<template>
  <section class="instagram-feed">
    <div class="section-header">
      <span class="section-label">Connect</span>
      <h2 class="section-title">Follow Me on <span class="gradient-text">Instagram</span></h2>
      <p class="section-description">Stay updated with my latest music and creative journey</p>
    </div>
    
    <div class="instagram-connect">
      <div class="instagram-card">
        <Instagram class="instagram-icon-large" />
        <h3>@amyyren_</h3>
        <p>Songwriter & Topliner | Berklee College of Music</p>
        <a href="https://www.instagram.com/amyyren_?igsh=Zm1hbDlrcmR3enlk&utm_source=qr" 
           target="_blank" 
           rel="noopener noreferrer" 
           class="btn btn-primary">
          <Instagram /> Follow @amyyren_
        </a>
      </div>
    </div>
    
    <div class="section-footer">
      <p class="footer-text">See more on my Instagram for exclusive content and updates</p>
    </div>
  </section>
</template>

<script setup>
import { Instagram } from 'lucide-vue-next'
</script>

<style scoped>
.instagram-feed {
  padding: 6rem 2rem;
  background: transparent;
}

.section-header {
  text-align: center;
  margin-bottom: 3rem;
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
  margin: 0.5rem 0 1rem;
}

.section-description {
  color: rgba(138, 138, 143, 0.8);
  margin: 0;
  font-size: 1.1rem;
}

.instagram-connect {
  max-width: 500px;
  margin: 0 auto;
  padding: 3rem 2rem;
  background: rgba(155, 138, 165, 0.06);
  border-radius: 20px;
  border: 1px solid rgba(155, 138, 165, 0.2);
  backdrop-filter: blur(10px);
}

.gradient-text {
  background: linear-gradient(135deg, #9b8aa5, #6b7b8c);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.instagram-connect {
  max-width: 600px;
  margin: 0 auto;
}

.instagram-card {
  background: rgba(155, 138, 165, 0.05);
  border-radius: 20px;
  padding: 3rem 2rem;
  text-align: center;
  border: 1px solid rgba(155, 138, 165, 0.2);
}

.instagram-icon-large {
  width: 60px;
  height: 60px;
  color: #9b8aa5;
  margin-bottom: 1rem;
}

.instagram-card h3 {
  font-family: 'Playfair Display', serif;
  font-size: 1.8rem;
  color: #e8e8e8;
  margin-bottom: 0.5rem;
}

.instagram-card p {
  color: rgba(138, 138, 143, 0.8);
  margin-bottom: 2rem;
}

.section-footer {
  text-align: center;
  margin-top: 3rem;
}

.footer-text {
  color: rgba(138, 138, 143, 0.6);
  font-style: italic;
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

@media (max-width: 768px) {
  .instagram-card {
    padding: 2rem 1.5rem;
  }
  
  .section-title {
    font-size: 2rem;
  }
  
  .instagram-card h3 {
    font-size: 1.5rem;
  }
}
</style>

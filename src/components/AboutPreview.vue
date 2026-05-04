<template>
  <section class="about-preview" id="about-preview">
    <div class="about-content">
      <div class="about-image">
        <img src="https://cdn.jsdelivr.net/gh/kevkoi/portfolio-assets@v1.0/images/gallery/19A2578.jpg" alt="Amy Ren" />
        <div class="image-overlay"></div>
      </div>
      
      <div class="about-text">
        <span class="section-label">About Me</span>
        <h2 class="section-title">Amy <span class="gradient-text">Ren</span></h2>
        <p class="about-description">
          Amy Ren is a songwriter and topliner crafting emotionally intimate pop and R&B ballads 
          that translate quiet, personal experiences into empathetic songs for artists who imbue 
          their music with longing and regret.
        </p>
        <p class="about-description">
          Her lyric writing blends emotional narration with visceral imagery and metaphor to 
          create wistful/melancholic stories that connect with people at an intimate level 
          (she knows she's doing it right when her song makes people cry).
        </p>
        <p class="about-description">
          She's influenced by Taylor Swift for her narrative clarity and emotional honesty, 
          and Billie Eilish for her use of restraint, space, and vulnerability. As a current 
          student at Berklee College of Music, Amy is working on a three-song EP scheduled for 
          release in the summer of 2026. When she is not in a studio session, she can be found 
          at Michael's perusing yarn.
        </p>
        <p class="about-description">
          She's excited to collaborate with artists who care about lyrics and intention, and 
          who are open, curious, and generous in the creative process.
        </p>
      </div>
    </div>
  </section>
</template>

<script setup>
import { User } from 'lucide-vue-next'
</script>

<style scoped>
.about-preview {
  padding: 6rem 2rem;
  background: linear-gradient(180deg, #2d2520 0%, #3d352d 100%);
}

.about-content {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
}

.about-image {
  position: relative;
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
}

.about-image img {
  width: 100%;
  height: 400px;
  object-fit: cover;
  transition: transform 0.5s ease;
}

.about-image:hover img {
  transform: scale(1.05);
  transition: transform 0.5s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.image-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(135deg, rgba(201, 169, 98, 0.2) 0%, transparent 50%);
}

.section-label {
  color: #c9a962;
  font-size: 0.9rem;
  font-weight: 600;
  letter-spacing: 2px;
  text-transform: uppercase;
}

.section-title {
  font-family: 'Playfair Display', serif;
  font-size: 2.5rem;
  margin: 0.5rem 0 1.5rem;
}

.gradient-text {
  background: linear-gradient(135deg, #c9a962, #e8d5b7);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.about-description {
  color: rgba(197, 184, 168, 0.7);
  line-height: 1.8;
  margin-bottom: 1rem;
}

.about-stats {
  display: flex;
  gap: 2rem;
  margin: 2rem 0;
}

.stat {
  text-align: center;
}

.stat-number {
  display: block;
  font-size: 2rem;
  font-weight: 700;
  background: linear-gradient(135deg, #c9a962, #e8d5b7);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.stat-label {
  color: rgba(197, 184, 168, 0.6);
  font-size: 0.9rem;
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
  background: linear-gradient(135deg, #c9a962, #b8860b);
  color: #1a1512;
}

.btn-primary:hover {
  transform: translateY(-3px);
  box-shadow: 0 10px 30px rgba(201, 169, 98, 0.4);
}

@media (max-width: 900px) {
  .about-content {
    grid-template-columns: 1fr;
    text-align: center;
  }
  
  .about-stats {
    justify-content: center;
  }
  
  .section-title {
    font-size: 2rem;
  }
}
</style>

<template>
  <div class="about-page">
    <section class="about-hero">
      <div class="about-hero-content">
        <h1 class="hero-title">About <span class="gradient-text">Me</span></h1>
        <p class="hero-description">Discover my musical journey and creative process</p>
      </div>
    </section>
    
    <section class="about-content">
      <div class="content-wrapper">
        <div class="about-image">
          <img src="https://trae-api-cn.mchost.guru/api/ide/v1/text_to_image?prompt=musician%20artist%20professional%20portrait%20creative%20studio%20lighting&image_size=portrait_4_3" alt="Artist" />
        </div>
        
        <div class="about-text">
          <h2 class="section-title">The Journey</h2>
          <p>
            Born and raised in a family of musicians, I discovered my passion for music at a very young age. 
            My journey began with classical piano lessons at the age of 5, and by 10, I was already composing 
            my own pieces.
          </p>
          <p>
            After graduating from Berklee College of Music with a degree in Music Production and Composition, 
            I embarked on a career that has taken me around the world. From intimate jazz clubs in Paris to 
            massive stadiums in Tokyo, every performance has shaped my artistry.
          </p>
          <p>
            Today, I blend classical training with modern production techniques to create music that transcends 
            genres and speaks to the soul. My mission is to connect people through the universal language of sound.
          </p>
          
          <div class="skills">
            <h3>Skills & Expertise</h3>
            <div class="skill-tags">
              <span v-for="skill in skills" :key="skill" class="skill-tag">{{ skill }}</span>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <section class="timeline-section">
      <h2 class="section-title">Career <span class="gradient-text">Timeline</span></h2>
      <div class="timeline">
        <div v-for="(event, index) in timelineEvents" :key="index" class="timeline-item" :class="{ 'timeline-item-right': index % 2 === 1 }">
          <div class="timeline-dot"></div>
          <div class="timeline-content">
            <span class="timeline-year">{{ event.year }}</span>
            <h3>{{ event.title }}</h3>
            <p>{{ event.description }}</p>
          </div>
        </div>
      </div>
    </section>
    
    <section class="awards-section">
      <h2 class="section-title">Awards & <span class="gradient-text">Recognition</span></h2>
      <div class="awards-grid">
        <div v-for="(award, index) in awards" :key="index" class="award-card">
          <Award class="award-icon" />
          <h3>{{ award.title }}</h3>
          <p>{{ award.year }}</p>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup>
import { Award } from 'lucide-vue-next'

const skills = ['Music Composition', 'Piano Performance', 'Music Production', 'Songwriting', 'Audio Engineering', 'Live Performance']

const timelineEvents = [
  { year: '2010', title: 'Started Piano Lessons', description: 'Began my musical journey with classical piano training.' },
  { year: '2015', title: 'Berklee College of Music', description: 'Enrolled at Berklee, studying Music Production and Composition.' },
  { year: '2017', title: 'First Album Release', description: 'Released my debut album "Dreams Collection" to critical acclaim.' },
  { year: '2019', title: 'World Tour', description: 'Embarked on my first international tour across 15 countries.' },
  { year: '2022', title: 'Grammy Nomination', description: 'Received first Grammy nomination for Best New Artist.' },
  { year: '2024', title: 'Berklee Alumni Award', description: 'Honored with the Distinguished Alumni Award.' }
]

const awards = [
  { title: 'Grammy Nomination', year: '2022' },
  { title: 'Billboard Top 10', year: '2023' },
  { title: 'MTV Music Award', year: '2023' },
  { title: 'Berklee Alumni Award', year: '2024' }
]
</script>

<style scoped>
.about-page {
  min-height: 100vh;
}

.about-hero {
  min-height: 50vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(135deg, rgba(108, 92, 231, 0.1) 0%, transparent 50%);
  padding: 6rem 2rem 2rem;
}

.hero-title {
  font-family: 'Playfair Display', serif;
  font-size: 3.5rem;
  text-align: center;
}

.gradient-text {
  background: linear-gradient(135deg, #6c5ce7, #a29bfe);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.hero-description {
  text-align: center;
  color: rgba(255, 255, 255, 0.7);
  font-size: 1.2rem;
}

.about-content {
  padding: 4rem 2rem;
}

.content-wrapper {
  max-width: 1000px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 1.5fr;
  gap: 4rem;
  align-items: start;
}

.about-image {
  position: relative;
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 0 20px 40px rgba(108, 92, 231, 0.2);
}

.about-image img {
  width: 100%;
  height: 400px;
  object-fit: cover;
}

.about-text h2 {
  font-family: 'Playfair Display', serif;
  font-size: 2rem;
  margin-bottom: 1.5rem;
}

.about-text p {
  color: rgba(255, 255, 255, 0.7);
  line-height: 1.8;
  margin-bottom: 1rem;
}

.skills {
  margin-top: 2rem;
}

.skills h3 {
  margin-bottom: 1rem;
}

.skill-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.75rem;
}

.skill-tag {
  padding: 0.5rem 1rem;
  background: rgba(108, 92, 231, 0.2);
  border-radius: 20px;
  font-size: 0.9rem;
  color: #a29bfe;
}

.timeline-section {
  padding: 4rem 2rem;
  background: linear-gradient(180deg, #1a1a2e 0%, #16213e 100%);
}

.timeline-section .section-title {
  font-family: 'Playfair Display', serif;
  font-size: 2.5rem;
  text-align: center;
  margin-bottom: 3rem;
}

.timeline {
  max-width: 800px;
  margin: 0 auto;
  position: relative;
}

.timeline::before {
  content: '';
  position: absolute;
  left: 50%;
  top: 0;
  bottom: 0;
  width: 2px;
  background: linear-gradient(180deg, #6c5ce7, #a29bfe);
  transform: translateX(-50%);
}

.timeline-item {
  position: relative;
  margin-bottom: 3rem;
  width: 45%;
}

.timeline-item:nth-child(odd) {
  margin-left: 0;
}

.timeline-item:nth-child(even) {
  margin-left: 55%;
}

.timeline-dot {
  position: absolute;
  top: 1rem;
  width: 20px;
  height: 20px;
  border-radius: 50%;
  background: linear-gradient(135deg, #6c5ce7, #a29bfe);
  border: 3px solid #1a1a2e;
}

.timeline-item:nth-child(odd) .timeline-dot {
  right: -26px;
}

.timeline-item:nth-child(even) .timeline-dot {
  left: -26px;
}

.timeline-content {
  background: rgba(255, 255, 255, 0.05);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 15px;
  padding: 1.5rem;
}

.timeline-year {
  color: #a29bfe;
  font-weight: 600;
}

.timeline-content h3 {
  margin: 0.5rem 0;
}

.timeline-content p {
  color: rgba(255, 255, 255, 0.7);
  margin: 0;
  font-size: 0.9rem;
}

.awards-section {
  padding: 4rem 2rem;
}

.awards-section .section-title {
  font-family: 'Playfair Display', serif;
  font-size: 2.5rem;
  text-align: center;
  margin-bottom: 3rem;
}

.awards-grid {
  max-width: 1000px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 2rem;
}

.award-card {
  background: rgba(255, 255, 255, 0.05);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 15px;
  padding: 2rem;
  text-align: center;
  transition: transform 0.3s ease;
}

.award-card:hover {
  transform: translateY(-5px);
}

.award-icon {
  width: 40px;
  height: 40px;
  color: #a29bfe;
  margin-bottom: 1rem;
}

.award-card h3 {
  margin: 0 0 0.5rem;
}

.award-card p {
  margin: 0;
  color: rgba(255, 255, 255, 0.6);
}

@media (max-width: 768px) {
  .hero-title {
    font-size: 2.5rem;
  }
  
  .content-wrapper {
    grid-template-columns: 1fr;
  }
  
  .timeline::before {
    left: 20px;
  }
  
  .timeline-item {
    width: calc(100% - 40px);
    margin-left: 40px !important;
  }
  
  .timeline-dot {
    left: -26px !important;
    right: auto !important;
  }
  
  .section-title {
    font-size: 2rem;
  }
}
</style>
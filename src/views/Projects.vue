<template>
  <div class="projects-page">
    <section class="projects-hero">
      <div class="projects-hero-content">
        <h1 class="hero-title">My <span class="gradient-text">Projects</span></h1>
        <p class="hero-description">Discover the creative projects I've worked on</p>
      </div>
    </section>
    
    <section class="projects-section">
      <div class="filter-tabs">
        <button v-for="tab in filterTabs" :key="tab" 
                class="filter-tab" :class="{ 'active': activeFilter === tab }"
                @click="activeFilter = tab">
          {{ tab }}
        </button>
      </div>
      
      <div class="projects-grid">
        <div v-for="(project, index) in filteredProjects" :key="index" class="project-card">
          <div class="project-image">
            <img :src="project.image" :alt="project.title" />
            <div class="project-category">{{ project.category }}</div>
          </div>
          <div class="project-content">
            <h3>{{ project.title }}</h3>
            <p>{{ project.description }}</p>
            <div class="project-meta">
              <span class="project-date">{{ project.date }}</span>
            </div>
            <button class="btn btn-secondary" @click="openProject(project)">
              <Eye /> View Project
            </button>
          </div>
        </div>
      </div>
    </section>
    
    <section class="events-section">
      <h2 class="section-title">Upcoming <span class="gradient-text">Events</span></h2>
      <div class="events-list">
        <div v-for="(event, index) in events" :key="index" class="event-card">
          <div class="event-date">
            <span class="date-day">{{ event.day }}</span>
            <span class="date-month">{{ event.month }}</span>
          </div>
          <div class="event-info">
            <h3>{{ event.title }}</h3>
            <div class="event-meta">
              <MapPin class="event-icon" />
              <span>{{ event.location }}</span>
            </div>
            <p>{{ event.description }}</p>
          </div>
          <button class="btn btn-primary">
            <Ticket /> Get Tickets
          </button>
        </div>
      </div>
    </section>
    
    <section class="collaborations-section">
      <h2 class="section-title">Collaborations</h2>
      <div class="collaborations-grid">
        <div v-for="(collab, index) in collaborations" :key="index" class="collab-card">
          <img :src="collab.image" :alt="collab.name" />
          <h4>{{ collab.name }}</h4>
          <p>{{ collab.role }}</p>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { Eye, MapPin, Ticket } from 'lucide-vue-next'

const filterTabs = ['All', 'Music Production', 'Compositions', 'Live Performances', 'Audio Engineering']
const activeFilter = ref('All')

const projects = [
  {
    title: 'Berklee College Commencement',
    description: 'Composed and performed the graduation ceremony music for the Class of 2024.',
    image: '/images/gallery/19A2578.jpg',
    category: 'Live Performances',
    date: 'May 2024'
  },
  {
    title: 'Film Score: "Silent Melodies"',
    description: 'Created original soundtrack for the independent film exploring musical expression.',
    image: '/images/gallery/B19A2552.jpg',
    category: 'Compositions',
    date: 'April 2024'
  },
  {
    title: 'Jazz Fusion Album',
    description: 'Produced and engineered a jazz fusion album featuring international artists.',
    image: '/images/albums/EP-Cover.png',
    category: 'Music Production',
    date: 'March 2024'
  },
  {
    title: 'Virtual Reality Experience',
    description: 'Created immersive audio experience for a VR music exhibition at MoMA.',
    image: '/images/gallery/19A2578.jpg',
    category: 'Audio Engineering',
    date: 'February 2024'
  },
  {
    title: 'Boston Symphony Collaboration',
    description: 'Guest performer with the Boston Symphony Orchestra for their spring concert series.',
    image: '/images/gallery/B19A2552.jpg',
    category: 'Live Performances',
    date: 'January 2024'
  },
  {
    title: 'Electronic Music EP',
    description: 'Produced an experimental electronic music EP blending classical elements with modern beats.',
    image: '/images/albums/EP-Cover.png',
    category: 'Music Production',
    date: 'December 2023'
  }
]

const events = [
  { day: '15', month: 'June', title: 'Summer Concert Series', location: 'Boston, MA', description: 'Live performance at the Boston Common' },
  { day: '28', month: 'June', title: 'New York City Showcase', location: 'New York, NY', description: 'Intimate concert at The Blue Note' },
  { day: '12', month: 'July', title: 'Lollapalooza', location: 'Chicago, IL', description: 'Main stage performance' },
  { day: '25', month: 'July', title: 'Berklee Alumni Concert', location: 'Boston, MA', description: 'Annual alumni showcase' }
]

const collaborations = [
  { name: 'John Smith', role: 'Pianist', image: '/images/profiles/头像.jpg' },
  { name: 'Sarah Johnson', role: 'Vocalist', image: '/images/profiles/头像.jpg' },
  { name: 'Mike Davis', role: 'Producer', image: '/images/profiles/头像.jpg' },
  { name: 'Boston Symphony', role: 'Orchestra', image: '/images/gallery/B19A2552.jpg' }
]

const filteredProjects = computed(() => {
  if (activeFilter.value === 'All') return projects
  return projects.filter(p => p.category === activeFilter.value)
})

const openProject = (project) => {
  alert(`Opening project: ${project.title}`)
}
</script>

<style scoped>
.projects-page {
  min-height: 100vh;
}

.projects-hero {
  min-height: 40vh;
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

.section-title {
  font-family: 'Playfair Display', serif;
  font-size: 2.5rem;
  text-align: center;
  margin-bottom: 3rem;
}

.projects-section {
  padding: 4rem 2rem;
}

.filter-tabs {
  display: flex;
  justify-content: center;
  gap: 1rem;
  margin-bottom: 3rem;
  flex-wrap: wrap;
}

.filter-tab {
  padding: 0.75rem 1.5rem;
  background: transparent;
  border: 1px solid rgba(108, 92, 231, 0.3);
  border-radius: 25px;
  color: #fff;
  cursor: pointer;
  transition: all 0.3s ease;
}

.filter-tab:hover {
  border-color: #6c5ce7;
}

.filter-tab.active {
  background: linear-gradient(135deg, #6c5ce7, #a29bfe);
  border-color: transparent;
}

.projects-grid {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
}

.project-card {
  background: rgba(255, 255, 255, 0.05);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 15px;
  overflow: hidden;
  transition: transform 0.3s ease;
}

.project-card:hover {
  transform: translateY(-5px);
}

.project-image {
  position: relative;
}

.project-image img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.project-category {
  position: absolute;
  top: 1rem;
  left: 1rem;
  padding: 0.25rem 0.75rem;
  background: rgba(108, 92, 231, 0.8);
  border-radius: 15px;
  font-size: 0.8rem;
}

.project-content {
  padding: 1.5rem;
}

.project-content h3 {
  margin: 0 0 0.75rem;
}

.project-content p {
  color: rgba(255, 255, 255, 0.7);
  font-size: 0.9rem;
  margin: 0 0 1rem;
  line-height: 1.6;
}

.project-date {
  color: #a29bfe;
  font-size: 0.85rem;
}

.btn {
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
  padding: 0.75rem 1.5rem;
  border-radius: 25px;
  font-weight: 500;
  text-decoration: none;
  transition: all 0.3s ease;
  border: none;
  cursor: pointer;
  margin-top: 1rem;
}

.btn-secondary {
  background: transparent;
  color: #fff;
  border: 1px solid #6c5ce7;
}

.btn-secondary:hover {
  background: #6c5ce7;
}

.btn-primary {
  background: linear-gradient(135deg, #6c5ce7, #a29bfe);
  color: #fff;
}

.btn-primary:hover {
  transform: translateY(-2px);
  box-shadow: 0 5px 20px rgba(108, 92, 231, 0.4);
}

.events-section {
  padding: 4rem 2rem;
  background: linear-gradient(180deg, #1a1a2e 0%, #16213e 100%);
}

.events-list {
  max-width: 800px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.event-card {
  display: flex;
  gap: 2rem;
  padding: 1.5rem;
  background: rgba(255, 255, 255, 0.05);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 15px;
  align-items: center;
}

.event-date {
  text-align: center;
  width: 70px;
}

.date-day {
  display: block;
  font-size: 2rem;
  font-weight: 700;
  background: linear-gradient(135deg, #6c5ce7, #a29bfe);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.date-month {
  font-size: 0.9rem;
  color: rgba(255, 255, 255, 0.6);
}

.event-info h3 {
  margin: 0 0 0.5rem;
}

.event-meta {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  color: rgba(255, 255, 255, 0.6);
  font-size: 0.9rem;
  margin-bottom: 0.5rem;
}

.event-icon {
  width: 16px;
  height: 16px;
}

.event-info p {
  margin: 0;
  color: rgba(255, 255, 255, 0.7);
  font-size: 0.9rem;
}

.collaborations-section {
  padding: 4rem 2rem;
}

.collaborations-grid {
  max-width: 800px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  gap: 2rem;
}

.collab-card {
  text-align: center;
}

.collab-card img {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  object-fit: cover;
  margin-bottom: 1rem;
  border: 3px solid rgba(108, 92, 231, 0.3);
}

.collab-card h4 {
  margin: 0 0 0.25rem;
}

.collab-card p {
  margin: 0;
  color: rgba(255, 255, 255, 0.6);
  font-size: 0.9rem;
}

@media (max-width: 768px) {
  .hero-title {
    font-size: 2.5rem;
  }
  
  .section-title {
    font-size: 2rem;
  }
  
  .event-card {
    flex-direction: column;
    text-align: center;
  }
  
  .event-meta {
    justify-content: center;
  }
}
</style>
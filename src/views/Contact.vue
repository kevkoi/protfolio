<template>
  <div class="contact-page">
    <section class="contact-hero">
      <div class="contact-hero-content">
        <h1 class="hero-title">Get in <span class="gradient-text">Touch</span></h1>
        <p class="hero-description">I'd love to hear from you. Whether it's for collaborations, bookings, or just to say hello.</p>
      </div>
    </section>
    
    <section class="contact-main">
      <div class="contact-container">
        <div class="contact-info-section">
          <h2 class="section-title">Contact <span class="gradient-text">Information</span></h2>
          
          <div class="info-cards">
            <div class="info-card">
              <Mail class="info-icon" />
              <div class="info-content">
                <h4>Email</h4>
                <p>flora.r.0571@gmail.com</p>
              </div>
            </div>
            
            <div class="info-card">
              <Phone class="info-icon" />
              <div class="info-content">
                <h4>Phone</h4>
                <p>+1 (555) 123-4567</p>
                <p>+1 (555) 987-6543</p>
              </div>
            </div>
            
            <div class="info-card">
              <MapPin class="info-icon" />
              <div class="info-content">
                <h4>Location</h4>
                <p>Boston, MA, USA</p>
                <p>Los Angeles, CA, USA</p>
              </div>
            </div>
            
            <div class="info-card">
              <Clock class="info-icon" />
              <div class="info-content">
                <h4>Response Time</h4>
                <p>Typically within 24 hours</p>
                <p>Monday - Friday</p>
              </div>
            </div>
          </div>
          
          <div class="social-section">
            <h3>Follow Me</h3>
            <div class="social-links">
              <a v-for="social in socials" :key="social.name" :href="social.url" class="social-link">
                <component :is="social.icon" />
                <span>{{ social.name }}</span>
              </a>
            </div>
          </div>
        </div>
        
        <div class="contact-form-section">
          <h2 class="section-title">Send <span class="gradient-text">Message</span></h2>
          <form class="contact-form" @submit.prevent="handleSubmit">
            <div class="form-row">
              <div class="form-group">
                <input type="text" v-model="form.name" placeholder="Your Name" class="form-input" />
              </div>
              <div class="form-group">
                <input type="email" v-model="form.email" placeholder="Your Email" class="form-input" />
              </div>
            </div>
            
            <div class="form-row">
              <div class="form-group">
                <select v-model="form.subject" class="form-input">
                  <option value="" disabled>Select Subject</option>
                  <option value="booking">Booking Inquiry</option>
                  <option value="collaboration">Collaboration</option>
                  <option value="press">Press/Media</option>
                  <option value="fan">Fan Message</option>
                  <option value="other">Other</option>
                </select>
              </div>
              <div class="form-group">
                <input type="text" v-model="form.phone" placeholder="Your Phone (optional)" class="form-input" />
              </div>
            </div>
            
            <div class="form-group">
              <textarea v-model="form.message" placeholder="Your Message" class="form-textarea"></textarea>
            </div>
            
            <div class="form-group checkbox-group">
              <input type="checkbox" id="newsletter" v-model="form.newsletter" />
              <label for="newsletter">Subscribe to newsletter</label>
            </div>
            
            <button type="submit" class="btn btn-primary">
              <Send /> Send Message
            </button>
          </form>
        </div>
      </div>
    </section>
    
    <section class="booking-section">
      <div class="booking-content">
        <div class="booking-info">
          <h2 class="section-title">Booking <span class="gradient-text">Inquiries</span></h2>
          <p>For booking inquiries, please include the following information:</p>
          <ul>
            <li>Event type (concert, private event, corporate, etc.)</li>
            <li>Date and location</li>
            <li>Expected audience size</li>
            <li>Budget range</li>
          </ul>
          <button class="btn btn-secondary" @click="scrollToForm">
            <Calendar /> Request Booking
          </button>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import { Mail, Phone, MapPin, Clock, Send, Calendar, Instagram, Twitter, Youtube, Facebook } from 'lucide-vue-next'

const form = reactive({
  name: '',
  email: '',
  subject: '',
  phone: '',
  message: '',
  newsletter: false
})

const socials = [
  { name: 'Instagram', url: '#', icon: Instagram },
  { name: 'Twitter', url: '#', icon: Twitter },
  { name: 'Youtube', url: '#', icon: Youtube },
  { name: 'Facebook', url: '#', icon: Facebook }
]

const handleSubmit = () => {
  alert('Message sent successfully!')
  form.name = ''
  form.email = ''
  form.subject = ''
  form.phone = ''
  form.message = ''
  form.newsletter = false
}

const scrollToForm = () => {
  const element = document.querySelector('.contact-form')
  if (element) {
    element.scrollIntoView({ behavior: 'smooth' })
  }
}
</script>

<style scoped>
.contact-page {
  min-height: 100vh;
}

.contact-hero {
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

.contact-main {
  padding: 4rem 2rem;
}

.contact-container {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 1.5fr;
  gap: 4rem;
}

.section-title {
  font-family: 'Playfair Display', serif;
  font-size: 2rem;
  margin-bottom: 2rem;
}

.info-cards {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.info-card {
  display: flex;
  gap: 1rem;
  padding: 1.5rem;
  background: rgba(255, 255, 255, 0.05);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 15px;
}

.info-icon {
  width: 40px;
  height: 40px;
  color: #a29bfe;
}

.info-content h4 {
  margin: 0 0 0.5rem;
}

.info-content p {
  margin: 0;
  color: rgba(255, 255, 255, 0.6);
  font-size: 0.9rem;
}

.social-section {
  margin-top: 2rem;
}

.social-section h3 {
  margin-bottom: 1rem;
}

.social-links {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}

.social-link {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  padding: 0.75rem 1.25rem;
  background: rgba(255, 255, 255, 0.05);
  border-radius: 25px;
  color: #fff;
  text-decoration: none;
  transition: all 0.3s ease;
}

.social-link:hover {
  background: rgba(108, 92, 231, 0.2);
  color: #a29bfe;
}

.contact-form {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.form-row {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 1rem;
}

.form-group {
  width: 100%;
}

.form-input {
  width: 100%;
  padding: 1rem;
  border: 1px solid rgba(108, 92, 231, 0.3);
  border-radius: 10px;
  background: rgba(255, 255, 255, 0.05);
  color: #fff;
  outline: none;
  transition: border-color 0.3s ease;
  box-sizing: border-box;
}

.form-input:focus {
  border-color: #6c5ce7;
}

.form-input::placeholder {
  color: rgba(255, 255, 255, 0.4);
}

select.form-input {
  appearance: none;
  background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 24 24' fill='none' stroke='%23a29bfe' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3E%3Cpolyline points='6 9 12 15 18 9'%3E%3C/polyline%3E%3C/svg%3E");
  background-repeat: no-repeat;
  background-position: right 1rem center;
}

.form-textarea {
  width: 100%;
  padding: 1rem;
  border: 1px solid rgba(108, 92, 231, 0.3);
  border-radius: 10px;
  background: rgba(255, 255, 255, 0.05);
  color: #fff;
  outline: none;
  transition: border-color 0.3s ease;
  resize: vertical;
  min-height: 150px;
  box-sizing: border-box;
}

.form-textarea:focus {
  border-color: #6c5ce7;
}

.form-textarea::placeholder {
  color: rgba(255, 255, 255, 0.4);
}

.checkbox-group {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.checkbox-group input {
  width: auto;
}

.checkbox-group label {
  color: rgba(255, 255, 255, 0.7);
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
  transition: all 0.3s ease;
  border: none;
  cursor: pointer;
}

.btn-primary {
  background: linear-gradient(135deg, #6c5ce7, #a29bfe);
  color: #fff;
}

.btn-primary:hover {
  transform: translateY(-3px);
  box-shadow: 0 10px 30px rgba(108, 92, 231, 0.4);
}

.btn-secondary {
  background: transparent;
  color: #fff;
  border: 2px solid #6c5ce7;
}

.btn-secondary:hover {
  background: #6c5ce7;
}

.booking-section {
  padding: 4rem 2rem;
  background: linear-gradient(180deg, #16213e 0%, #1a1a2e 100%);
}

.booking-content {
  max-width: 800px;
  margin: 0 auto;
  text-align: center;
}

.booking-info p {
  color: rgba(255, 255, 255, 0.7);
  margin-bottom: 1.5rem;
}

.booking-info ul {
  text-align: left;
  color: rgba(255, 255, 255, 0.7);
  margin-bottom: 2rem;
}

.booking-info li {
  margin-bottom: 0.5rem;
}

@media (max-width: 768px) {
  .hero-title {
    font-size: 2.5rem;
  }
  
  .contact-container {
    grid-template-columns: 1fr;
  }
  
  .form-row {
    grid-template-columns: 1fr;
  }
  
  .section-title {
    font-size: 1.5rem;
  }
}
</style>
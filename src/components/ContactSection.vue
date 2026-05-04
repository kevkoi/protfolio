<template>
  <section class="contact-section" id="contact">
    <div class="section-header">
      <span class="section-label">Connect</span>
      <h2 class="section-title">Follow <span class="gradient-text">Me</span></h2>
    </div>
    
    <div class="contact-content">
      <a href="https://www.instagram.com/amyyren_?igsh=Zm1hbDlrcmR3enlk&utm_source=qr" 
         target="_blank" 
         rel="noopener noreferrer" 
         class="social-link">
        <Instagram />
        <span>@amyyren_</span>
      </a>
      
      <a href="mailto:flora.r.0571@gmail.com" 
         class="social-link email-link">
        <Mail />
        <span>flora.r.0571@gmail.com</span>
      </a>
    </div>
    
    <form class="contact-form" @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="name">NAME</label>
        <input 
          type="text" 
          id="name" 
          v-model="formData.name" 
          placeholder="Your name" 
          required
        />
      </div>
      
      <div class="form-group">
        <label for="email">EMAIL</label>
        <input 
          type="email" 
          id="email" 
          v-model="formData.email" 
          placeholder="your@email.com" 
          required
        />
      </div>
      
      <div class="form-group">
        <label for="message">MESSAGE</label>
        <textarea 
          id="message" 
          v-model="formData.message" 
          placeholder="Your message..." 
          rows="5" 
          required
        ></textarea>
      </div>
      
      <button type="submit" class="submit-btn" :disabled="isSubmitting">
        {{ isSubmitting ? 'Sending...' : 'Send Message' }}
      </button>
      
      <p v-if="submitMessage" class="submit-status" :class="submitStatus">
        {{ submitMessage }}
      </p>
    </form>
  </section>
</template>

<script setup>
import { ref } from 'vue'
import { Instagram, Mail } from 'lucide-vue-next'

const formData = ref({
  name: '',
  email: '',
  message: ''
})
const isSubmitting = ref(false)
const submitMessage = ref('')
const submitStatus = ref('')

const handleSubmit = async () => {
  isSubmitting.value = true
  submitMessage.value = ''
  
  try {
    const response = await fetch('http://localhost:8080/api/send-email', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData.value)
    })
    
    const result = await response.json()
    
    if (result.success) {
      submitMessage.value = 'Message sent successfully!'
      submitStatus.value = 'success'
      formData.value = { name: '', email: '', message: '' }
    } else {
      throw new Error(result.message || 'Failed to send message')
    }
  } catch (error) {
    submitMessage.value = 'Failed to send message. Please try again or send an email directly.'
    submitStatus.value = 'error'
    console.error('Error:', error)
  } finally {
    isSubmitting.value = false
  }
}
</script>

<style scoped>
.contact-section {
  padding: 6rem 2rem;
  background: #1a1512;
}

.section-header {
  text-align: center;
  margin-bottom: 3rem;
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
  margin: 0.5rem 0;
  color: #f5f0e8;
}

.gradient-text {
  background: linear-gradient(135deg, #c9a962, #e8d5b7);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.contact-content {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  gap: 1.5rem;
}

.social-link {
  display: inline-flex;
  align-items: center;
  gap: 1rem;
  padding: 1.25rem 2.5rem;
  background: rgba(201, 169, 98, 0.15);
  border: 1px solid rgba(201, 169, 98, 0.3);
  border-radius: 50px;
  color: #e8d5b7;
  text-decoration: none;
  font-size: 1.1rem;
  font-weight: 500;
  transition: all 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.social-link:hover {
  background: linear-gradient(135deg, #c9a962, #b8860b);
  border-color: #c9a962;
  color: #fff;
  transform: translateY(-3px);
  box-shadow: 0 10px 30px rgba(201, 169, 98, 0.3);
}

.social-link :deep(svg) {
  width: 24px;
  height: 24px;
}

@media (max-width: 768px) {
  .section-title {
    font-size: 2rem;
  }
  
  .social-link {
    padding: 1rem 2rem;
    font-size: 1rem;
  }
}

.contact-form {
  max-width: 600px;
  margin: 3rem auto 0;
  background: rgba(201, 169, 98, 0.08);
  padding: 2.5rem;
  border-radius: 20px;
  border: 1px solid rgba(201, 169, 98, 0.2);
}

.form-group {
  margin-bottom: 1.5rem;
}

.form-group label {
  display: block;
  color: #c9a962;
  font-size: 0.9rem;
  font-weight: 600;
  letter-spacing: 1px;
  text-transform: uppercase;
  margin-bottom: 0.5rem;
}

.form-group input,
.form-group textarea {
  width: 100%;
  padding: 1rem;
  background: rgba(26, 21, 18, 0.8);
  border: 1px solid rgba(201, 169, 98, 0.3);
  border-radius: 10px;
  color: #f5f0e8;
  font-size: 1rem;
  transition: all 0.3s ease;
  box-sizing: border-box;
}

.form-group input:focus,
.form-group textarea:focus {
  outline: none;
  border-color: #c9a962;
  box-shadow: 0 0 20px rgba(201, 169, 98, 0.2);
}

.form-group input::placeholder,
.form-group textarea::placeholder {
  color: rgba(232, 213, 183, 0.4);
}

.form-group textarea {
  resize: vertical;
  min-height: 120px;
}

.submit-btn {
  width: 100%;
  padding: 1.25rem;
  background: linear-gradient(135deg, #c9a962, #b8860b);
  border: none;
  border-radius: 10px;
  color: #1a1512;
  font-size: 1.1rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.submit-btn:hover:not(:disabled) {
  transform: translateY(-3px);
  box-shadow: 0 10px 30px rgba(201, 169, 98, 0.4);
}

.submit-btn:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.submit-status {
  text-align: center;
  margin-top: 1.5rem;
  font-weight: 500;
}

.submit-status.success {
  color: #4ade80;
}

.submit-status.error {
  color: #f87171;
}

@media (max-width: 768px) {
  .contact-form {
    padding: 1.5rem;
  }
}
</style>

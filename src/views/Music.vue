<template>
  <div class="music-page">
    <section class="music-hero">
      <div class="music-hero-content">
        <h1 class="hero-title">My <span class="gradient-text">Music</span></h1>
        <p class="hero-description">Explore my discography and listen to my latest tracks</p>
      </div>
    </section>
    
    <section class="albums-section">
      <h2 class="section-title">Albums</h2>
      <div class="albums-grid">
        <div v-for="(album, index) in albums" :key="index" class="album-card" @click="selectAlbum(album)">
          <div class="album-cover">
            <img :src="album.cover" :alt="album.title" />
            <div class="play-overlay">
              <Play class="play-icon" />
            </div>
          </div>
          <div class="album-info">
            <h3>{{ album.title }}</h3>
            <p>{{ album.year }} - {{ album.tracks.length }} tracks</p>
          </div>
        </div>
      </div>
    </section>
    
    <section class="selected-album" v-if="selectedAlbum">
      <div class="album-detail">
        <div class="album-header">
          <img :src="selectedAlbum.cover" :alt="selectedAlbum.title" class="album-cover-large" />
          <div class="album-meta">
            <span class="album-year">{{ selectedAlbum.year }}</span>
            <h2 class="album-title">{{ selectedAlbum.title }}</h2>
            <p class="album-description">{{ selectedAlbum.description }}</p>
          </div>
        </div>
        
        <div class="track-list-container">
          <h3 class="tracks-title">Track List</h3>
          <div class="track-list">
            <div v-for="(track, index) in selectedAlbum.tracks" :key="index" 
                 class="track-item" :class="{ 'track-active': currentTrack === index }"
                 @click="playTrack(index)">
              <div class="track-number">
                <Play v-if="currentTrack !== index" class="mini-play" />
                <Pause v-else class="mini-play" />
                <span v-if="currentTrack !== index">{{ index + 1 }}</span>
              </div>
              <div class="track-info">
                <h4>{{ track.title }}</h4>
                <p>{{ track.duration }}</p>
              </div>
              <span class="track-duration">{{ track.duration }}</span>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <section class="singles-section">
      <h2 class="section-title">Latest Singles</h2>
      <div class="singles-grid">
        <div v-for="(single, index) in singles" :key="index" class="single-card">
          <div class="single-cover">
            <img :src="single.cover" :alt="single.title" />
            <button class="play-button" @click="playSingle(single)">
              <Play />
            </button>
          </div>
          <div class="single-info">
            <h3>{{ single.title }}</h3>
            <p>{{ single.release }}</p>
          </div>
        </div>
      </div>
    </section>
    
    <section class="streaming-section">
      <h2 class="section-title">Listen On</h2>
      <div class="streaming-links">
        <a v-for="platform in streamingPlatforms" :key="platform.name" :href="platform.url" class="streaming-link">
          <component :is="platform.icon" />
          <span>{{ platform.name }}</span>
        </a>
      </div>
    </section>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { Play, Pause, Music2 } from 'lucide-vue-next'

const albums = [
  {
    title: 'Dreams Collection',
    year: '2017',
    cover: 'https://trae-api-cn.mchost.guru/api/ide/v1/text_to_image?prompt=music%20album%20cover%20abstract%20dreamy%20purple%20blue%20colors&image_size=square',
    description: 'A collection of dreamy melodies and ambient soundscapes that transport listeners to another dimension.',
    tracks: [
      { title: 'Midnight Dreams', duration: '5:42' },
      { title: 'Echoes of Tomorrow', duration: '4:28' },
      { title: 'Starlight Serenade', duration: '6:15' },
      { title: 'Rhythm of the Night', duration: '3:56' },
      { title: 'Melody Unleashed', duration: '5:33' },
      { title: 'Peaceful Horizons', duration: '4:18' }
    ]
  },
  {
    title: 'Classical Fusion',
    year: '2019',
    cover: 'https://trae-api-cn.mchost.guru/api/ide/v1/text_to_image?prompt=classical%20music%20album%20cover%20elegant%20piano%20orchestra&image_size=square',
    description: 'Blending classical compositions with modern electronic elements for a unique listening experience.',
    tracks: [
      { title: 'Serenade in Blue', duration: '6:45' },
      { title: 'Moonlight Sonata Remix', duration: '5:22' },
      { title: 'Symphonic Dreams', duration: '7:12' },
      { title: 'Baroque Electronica', duration: '4:58' },
      { title: 'Classical Journey', duration: '8:33' }
    ]
  },
  {
    title: 'Live at Berklee',
    year: '2022',
    cover: 'https://trae-api-cn.mchost.guru/api/ide/v1/text_to_image?prompt=live%20concert%20album%20cover%20stage%20lights%20performance&image_size=square',
    description: 'Recorded live at Berklee College of Music during my homecoming concert.',
    tracks: [
      { title: 'Intro', duration: '2:15' },
      { title: 'Midnight Dreams (Live)', duration: '6:32' },
      { title: 'Echoes of Tomorrow (Live)', duration: '5:18' },
      { title: 'Serenade in Blue (Live)', duration: '7:45' },
      { title: 'Encore: Starlight', duration: '4:22' }
    ]
  }
]

const singles = [
  { title: 'New Horizons', cover: 'https://trae-api-cn.mchost.guru/api/ide/v1/text_to_image?prompt=music%20single%20cover%20futuristic%20neon%20colors&image_size=square', release: '2024' },
  { title: 'Summer Vibes', cover: 'https://trae-api-cn.mchost.guru/api/ide/v1/text_to_image?prompt=music%20single%20cover%20summer%20sunset%20beach&image_size=square', release: '2024' },
  { title: 'Winter Nights', cover: 'https://trae-api-cn.mchost.guru/api/ide/v1/text_to_image?prompt=music%20single%20cover%20winter%20night%20snow%20cozy&image_size=square', release: '2023' }
]

const streamingPlatforms = [
  { name: 'Spotify', url: '#', icon: Music2 },
  { name: 'Apple Music', url: '#', icon: Music2 },
  { name: 'YouTube', url: '#', icon: Music2 },
  { name: 'SoundCloud', url: '#', icon: Music2 }
]

const selectedAlbum = ref(albums[0])
const currentTrack = ref(null)

const selectAlbum = (album) => {
  selectedAlbum.value = album
  currentTrack.value = null
}

const playTrack = (index) => {
  currentTrack.value = currentTrack.value === index ? null : index
}

const playSingle = (single) => {
  alert(`Playing: ${single.title}`)
}
</script>

<style scoped>
.music-page {
  min-height: 100vh;
}

.music-hero {
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

.albums-section {
  padding: 4rem 2rem;
}

.albums-grid {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 2rem;
}

.album-card {
  cursor: pointer;
}

.album-cover {
  position: relative;
  border-radius: 15px;
  overflow: hidden;
  margin-bottom: 1rem;
}

.album-cover img {
  width: 100%;
  height: 250px;
  object-fit: cover;
  transition: transform 0.3s ease;
}

.album-card:hover .album-cover img {
  transform: scale(1.05);
}

.play-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(108, 92, 231, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  opacity: 0;
  transition: opacity 0.3s ease;
}

.album-card:hover .play-overlay {
  opacity: 1;
}

.play-icon {
  width: 60px;
  height: 60px;
}

.album-info h3 {
  margin: 0 0 0.25rem;
}

.album-info p {
  margin: 0;
  color: rgba(255, 255, 255, 0.6);
  font-size: 0.9rem;
}

.selected-album {
  padding: 4rem 2rem;
  background: linear-gradient(180deg, #1a1a2e 0%, #16213e 100%);
}

.album-detail {
  max-width: 1000px;
  margin: 0 auto;
}

.album-header {
  display: flex;
  gap: 3rem;
  margin-bottom: 3rem;
  align-items: center;
}

.album-cover-large {
  width: 250px;
  height: 250px;
  border-radius: 15px;
  object-fit: cover;
}

.album-year {
  color: #a29bfe;
  font-weight: 600;
}

.album-title {
  font-family: 'Playfair Display', serif;
  font-size: 2.5rem;
  margin: 0.5rem 0;
}

.album-description {
  color: rgba(255, 255, 255, 0.7);
  max-width: 600px;
}

.tracks-title {
  margin-bottom: 1.5rem;
}

.track-list {
  background: rgba(255, 255, 255, 0.05);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 15px;
  overflow: hidden;
}

.track-item {
  display: flex;
  align-items: center;
  gap: 1rem;
  padding: 1rem 1.5rem;
  cursor: pointer;
  transition: background 0.3s ease;
}

.track-item:hover {
  background: rgba(108, 92, 231, 0.1);
}

.track-active {
  background: rgba(108, 92, 231, 0.2);
}

.track-number {
  width: 25px;
  height: 25px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #a29bfe;
  font-size: 0.9rem;
}

.mini-play {
  width: 16px;
  height: 16px;
}

.track-info h4 {
  margin: 0 0 0.2rem;
}

.track-info p {
  margin: 0;
  color: rgba(255, 255, 255, 0.5);
  font-size: 0.85rem;
}

.track-duration {
  margin-left: auto;
  color: rgba(255, 255, 255, 0.5);
  font-size: 0.9rem;
}

.singles-section {
  padding: 4rem 2rem;
}

.singles-grid {
  max-width: 1000px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 2rem;
}

.single-card {
  text-align: center;
}

.single-cover {
  position: relative;
  border-radius: 15px;
  overflow: hidden;
  margin-bottom: 1rem;
}

.single-cover img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.play-button {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background: rgba(108, 92, 231, 0.9);
  border: none;
  color: #fff;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  opacity: 0;
  transition: all 0.3s ease;
}

.single-card:hover .play-button {
  opacity: 1;
}

.play-button:hover {
  transform: translate(-50%, -50%) scale(1.1);
}

.single-info h3 {
  margin: 0 0 0.25rem;
}

.single-info p {
  margin: 0;
  color: rgba(255, 255, 255, 0.6);
  font-size: 0.9rem;
}

.streaming-section {
  padding: 4rem 2rem;
  background: linear-gradient(180deg, #16213e 0%, #0f0f1a 100%);
}

.streaming-links {
  max-width: 600px;
  margin: 0 auto;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 1rem;
}

.streaming-link {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  padding: 1rem 2rem;
  background: rgba(255, 255, 255, 0.05);
  border: 1px solid rgba(108, 92, 231, 0.3);
  border-radius: 30px;
  color: #fff;
  text-decoration: none;
  transition: all 0.3s ease;
}

.streaming-link:hover {
  background: rgba(108, 92, 231, 0.2);
  border-color: #6c5ce7;
}

@media (max-width: 768px) {
  .hero-title {
    font-size: 2.5rem;
  }
  
  .section-title {
    font-size: 2rem;
  }
  
  .album-header {
    flex-direction: column;
    text-align: center;
  }
  
  .album-description {
    margin: 0 auto;
  }
}
</style>
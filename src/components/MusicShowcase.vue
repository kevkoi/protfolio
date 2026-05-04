<template>
  <section class="music-showcase" id="music-showcase">
    <audio
      ref="audioRef"
      :src="currentTrack?.src"
      @timeupdate="handleTimeUpdate"
      @loadedmetadata="handleLoadedMetadata"
      @ended="handleEnded"
      @volumechange="handleVolumeChange"
    ></audio>
    
    <div class="section-header">
      <span class="section-label">Featured</span>
      <h2 class="section-title">Latest <span class="gradient-text">Tracks</span></h2>
    </div>
    
    <div class="music-container">
      <div class="audio-section">
        <h3 class="section-subtitle">Listen to My Music</h3>
        <div class="player-card">
          <div class="player-header">
            <div class="track-info">
              <img :src="currentTrack?.cover" :alt="currentTrack?.title" class="album-cover" />
              <div class="track-details">
                <h4 class="track-title">{{ currentTrack?.title }}</h4>
                <p class="track-artist">Amy Ren</p>
              </div>
            </div>
          </div>
          
          <div class="player-controls">
            <div class="player-controls-left">
              <div class="volume-section">
                <button class="volume-btn" @click="toggleMute">
                  <component :is="isMuted ? VolumeX : Volume2" :size="18" />
                </button>
                <input 
                  type="range" 
                  min="0" 
                  max="100" 
                  v-model="volume" 
                  @input="handleVolumeChange"
                  class="volume-slider" 
                />
              </div>
            </div>
            
            <div class="player-controls-main">
              <button class="control-btn-small" @click="playPrevious">
                <SkipBack />
              </button>
              <button class="control-btn" @click="togglePlay">
                <component :is="isPlaying ? Pause : Play" />
              </button>
              <button class="control-btn-small" @click="playNext">
                <SkipForward />
              </button>
            </div>
            
            <div class="player-controls-right">
            </div>
          </div>
          
          <div class="progress-section">
            <div 
              class="progress-bar" 
              ref="progressBarRef"
              @click="handleProgressClick"
              @mousedown="handleProgressMouseDown"
            >
              <div class="progress" :style="{ width: progress + '%' }"></div>
            </div>
            <div class="time-display">
              <span class="time">{{ formatTime(currentTime) }}</span>
              <span class="time">{{ formatTime(duration) }}</span>
            </div>
          </div>
        </div>
        
        <div class="track-list">
          <div v-for="track in tracks" :key="track.id" class="track-item" @click="playTrack(track)">
            <div class="track-number">{{ track.id }}</div>
            <div class="track-info">
              <h5>{{ track.title }}</h5>
              <p>{{ track.album }}</p>
            </div>
            <span class="track-duration">{{ track.duration }}</span>
          </div>
        </div>
      </div>
    </div>
    
    <div class="section-footer">
      <button class="btn btn-secondary" @click="scrollToMusicSection">
        <Music /> View All Music
      </button>
    </div>
  </section>
</template>

<script setup>
import { ref, computed, onMounted, onUnmounted } from 'vue'
import { Play, Pause, Volume2, VolumeX, Music, SkipBack, SkipForward } from 'lucide-vue-next'

const audioRef = ref(null)
const isPlaying = ref(false)
const currentTrackIndex = ref(0)
const volume = ref(75)
const currentTime = ref(0)
const duration = ref(0)
const isMuted = ref(false)
const progressBarRef = ref(null)
const isDragging = ref(false)

const tracks = [
  { id: 1, title: 'If I Could See U Once More', album: 'Summer 2026 EP', duration: '3:42', src: 'https://cdn.jsdelivr.net/gh/kevkoi/portfolio-assets@v1.0/audio/tracks/If I Could See U Once More.mp3', cover: 'https://cdn.jsdelivr.net/gh/kevkoi/portfolio-assets@v1.0/images/albums/EP-Cover.png' },
  { id: 2, title: 'What Bruises You', album: 'Summer 2026 EP', duration: '4:15', src: 'https://cdn.jsdelivr.net/gh/kevkoi/portfolio-assets@v1.0/audio/tracks/What Bruises you.mp3', cover: 'https://cdn.jsdelivr.net/gh/kevkoi/portfolio-assets@v1.0/images/albums/EP-Cover.png' },
  { id: 3, title: "Won't Let It Lie", album: 'Summer 2026 EP', duration: '3:58', src: 'https://cdn.jsdelivr.net/gh/kevkoi/portfolio-assets@v1.0/audio/tracks/won_t let it lie.mp3', cover: 'https://cdn.jsdelivr.net/gh/kevkoi/portfolio-assets@v1.0/images/albums/EP-Cover.png' }
]

const currentTrack = computed(() => tracks[currentTrackIndex.value])

const progress = computed(() => {
  if (duration.value === 0) return 0
  return (currentTime.value / duration.value) * 100
})

const togglePlay = () => {
  if (audioRef.value) {
    if (isPlaying.value) {
      audioRef.value.pause()
    } else {
      audioRef.value.play()
    }
    isPlaying.value = !isPlaying.value
  }
}

const playNext = () => {
  if (currentTrackIndex.value < tracks.length - 1) {
    playTrack(tracks[currentTrackIndex.value + 1])
  } else {
    playTrack(tracks[0])
  }
}

const playPrevious = () => {
  if (currentTrackIndex.value > 0) {
    playTrack(tracks[currentTrackIndex.value - 1])
  } else {
    playTrack(tracks[tracks.length - 1])
  }
}

const formatTime = (seconds) => {
  const mins = Math.floor(seconds / 60)
  const secs = Math.floor(seconds % 60)
  return `${mins}:${secs.toString().padStart(2, '0')}`
}

const playTrack = (track) => {
  const index = tracks.findIndex(t => t.id === track.id)
  if (index !== -1 && audioRef.value) {
    // 先设置为暂停状态
    if (isPlaying.value) {
      audioRef.value.pause()
    }
    isPlaying.value = false
    
    // 更新当前歌曲索引
    currentTrackIndex.value = index
    // 显式设置新的音频源
    audioRef.value.src = track.src
    // 重置时间
    audioRef.value.currentTime = 0
    
    // 加载并播放新歌曲
    audioRef.value.load()
    
    // 等待加载完成后播放
    audioRef.value.addEventListener('canplay', function onCanPlay() {
      audioRef.value.play().catch(error => {
        console.log('播放出错:', error)
      })
      isPlaying.value = true
      audioRef.value.removeEventListener('canplay', onCanPlay)
    })
  }
}

const handleProgressClick = (event) => {
  if (progressBarRef.value && audioRef.value && duration.value > 0) {
    const rect = progressBarRef.value.getBoundingClientRect()
    const clickX = event.clientX - rect.left
    const percentage = clickX / rect.width
    audioRef.value.currentTime = percentage * duration.value
  }
}

const handleProgressMouseDown = (event) => {
  isDragging.value = true
  // 添加全局鼠标事件监听
  window.addEventListener('mousemove', handleProgressMouseMove)
  window.addEventListener('mouseup', handleProgressMouseUp)
  // 立即更新一次
  handleProgressMouseMove(event)
}

const handleProgressMouseMove = (event) => {
  if (!isDragging.value || !progressBarRef.value || !audioRef.value || duration.value === 0) {
    return
  }
  const rect = progressBarRef.value.getBoundingClientRect()
  let moveX = event.clientX - rect.left
  // 限制在进度条范围内
  moveX = Math.max(0, Math.min(rect.width, moveX))
  const percentage = moveX / rect.width
  audioRef.value.currentTime = percentage * duration.value
}

const handleProgressMouseUp = () => {
  isDragging.value = false
  window.removeEventListener('mousemove', handleProgressMouseMove)
  window.removeEventListener('mouseup', handleProgressMouseUp)
}

const handleVolumeClick = (event) => {
  const volumeBar = event.currentTarget
  const rect = volumeBar.getBoundingClientRect()
  const clickX = event.clientX - rect.left
  const percentage = clickX / rect.width
  volume.value = Math.round(percentage * 100)
  isMuted.value = false
  if (audioRef.value) {
    audioRef.value.volume = volume.value / 100
  }
}

const handleVolumeChange = () => {
  if (audioRef.value) {
    audioRef.value.volume = isMuted.value ? 0 : volume.value / 100
  }
}

const toggleMute = () => {
  isMuted.value = !isMuted.value
  if (audioRef.value) {
    audioRef.value.volume = isMuted.value ? 0 : volume.value / 100
  }
}

const handleTimeUpdate = () => {
  if (audioRef.value) {
    currentTime.value = audioRef.value.currentTime
  }
}

const handleLoadedMetadata = () => {
  if (audioRef.value) {
    duration.value = audioRef.value.duration
  }
}

const handleEnded = () => {
  playNext()
}

const scrollToMusicSection = () => {
  const element = document.getElementById('music-showcase')
  if (element) {
    element.scrollIntoView({ behavior: 'smooth' })
  }
}

onMounted(() => {
  if (audioRef.value) {
    audioRef.value.volume = volume.value / 100
  }
})

onUnmounted(() => {
  // 清理拖拽事件监听器
  window.removeEventListener('mousemove', handleProgressMouseMove)
  window.removeEventListener('mouseup', handleProgressMouseUp)
})
</script>

<style scoped>
.music-showcase {
  padding: 6rem 2rem;
  background: linear-gradient(180deg, #3d352d 0%, #2d2520 100%);
}

.section-header {
  text-align: center;
  margin-bottom: 4rem;
}

.section-label {
  color: #e8d5b7;
  font-size: 0.9rem;
  font-weight: 600;
  letter-spacing: 2px;
  text-transform: uppercase;
}

.section-title {
  font-family: 'Playfair Display', serif;
  font-size: 2.5rem;
  margin: 0.5rem 0;
}

.gradient-text {
  background: linear-gradient(135deg, #c9a962, #e8d5b7);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.music-container {
  max-width: 800px;
  margin: 0 auto;
}

.section-subtitle {
  font-family: 'Playfair Display', serif;
  font-size: 1.3rem;
  margin-bottom: 1.5rem;
}

.player-card {
  background: rgba(255, 255, 255, 0.05);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 20px;
  padding: 1.5rem;
  margin-bottom: 1.5rem;
}

.player-header {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 1rem;
}

.track-info {
  display: flex;
  gap: 1rem;
  align-items: center;
}

.album-cover {
  width: 80px;
  height: 80px;
  border-radius: 10px;
  object-fit: cover;
}

.track-details h4 {
  margin: 0 0 0.25rem;
  color: #f5f0e8;
  font-size: 1.1rem;
}

.track-details p {
  margin: 0;
  color: rgba(197, 184, 168, 0.7);
  font-size: 0.9rem;
}

.player-controls {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 1.25rem 0;
}

.player-controls-left {
  flex: 1;
  display: flex;
  justify-content: flex-start;
}

.player-controls-main {
  flex: 0 0 auto;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 1.5rem;
}

.player-controls-right {
  flex: 1;
}

.volume-section {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.volume-btn {
  background: none;
  border: none;
  color: rgba(197, 184, 168, 0.6);
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: color 0.3s ease;
  padding: 0.2rem;
}

.volume-btn:hover {
  color: #c9a962;
}

.volume-slider {
  width: 80px;
  height: 4px;
  cursor: pointer;
  appearance: none;
  background: rgba(255, 255, 255, 0.15);
  border-radius: 2px;
  outline: none;
}

.volume-slider::-webkit-slider-thumb {
  appearance: none;
  width: 12px;
  height: 12px;
  border-radius: 50%;
  background: #c9a962;
  cursor: pointer;
  transition: all 0.2s ease;
}

.volume-slider::-webkit-slider-thumb:hover {
  transform: scale(1.2);
}

.control-btn-small {
  width: 36px;
  height: 36px;
  border-radius: 50%;
  background: transparent;
  border: 1px solid rgba(201, 169, 98, 0.4);
  color: rgba(197, 184, 168, 0.8);
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: all 0.3s ease;
}

.control-btn-small:hover {
  border-color: #c9a962;
  color: #c9a962;
  transform: scale(1.05);
}

.control-btn {
  width: 52px;
  height: 52px;
  border-radius: 50%;
  background: linear-gradient(135deg, #c9a962, #b8860b);
  border: none;
  color: #1a1512;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: all 0.3s ease;
}

.control-btn:hover {
  transform: scale(1.05);
  box-shadow: 0 4px 20px rgba(201, 169, 98, 0.4);
}

.progress-section {
  margin: 0.75rem 0;
}

.progress-bar {
  height: 4px;
  background: rgba(255, 255, 255, 0.15);
  border-radius: 2px;
  cursor: pointer;
  overflow: hidden;
  transition: height 0.2s ease;
}

.progress-bar:hover {
  height: 6px;
}

.progress {
  height: 100%;
  background: linear-gradient(90deg, #c9a962, #b8860b);
  border-radius: 2px;
  transition: width 0.2s linear;
}

.time-display {
  display: flex;
  justify-content: space-between;
  margin-top: 0.5rem;
}

.time {
  font-size: 0.75rem;
  color: rgba(197, 184, 168, 0.6);
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
  transition: all 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
  border-bottom: 1px solid rgba(255, 255, 255, 0.05);
}

.track-item:last-child {
  border-bottom: none;
}

.track-item:hover {
  background: rgba(201, 169, 98, 0.1);
}

.track-number {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background: rgba(201, 169, 98, 0.2);
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 0.85rem;
  color: #e8d5b7;
}

.track-item:hover .track-number {
  background: #c9a962;
  color: #1a1512;
}

.track-info h5 {
  margin: 0 0 0.2rem;
  color: #f5f0e8;
}

.track-info p {
  margin: 0;
  color: rgba(197, 184, 168, 0.6);
  font-size: 0.85rem;
}

.track-duration {
  margin-left: auto;
  color: rgba(197, 184, 168, 0.6);
  font-size: 0.85rem;
}

.section-footer {
  text-align: center;
  margin-top: 3rem;
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

.btn-secondary {
  background: transparent;
  color: #e8d5b7;
  border: 2px solid #c9a962;
}

.btn-secondary:hover {
  background: #c9a962;
  color: #1a1512;
}

@media (max-width: 900px) {
  .music-container {
    grid-template-columns: 1fr;
  }
  
  .section-title {
    font-size: 2rem;
  }
}
</style>

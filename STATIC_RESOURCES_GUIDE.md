# 静态资源使用指南

## 目录结构

```
g:\work\personal_web\ProtfolioWeb\
├── public/                              # 前端静态资源
│   ├── images/
│   │   ├── gallery/                    # 画廊图片
│   │   ├── albums/                     # 专辑封面
│   │   └── profiles/                   # 个人资料图片
│   ├── audio/
│   │   └── tracks/                     # 音乐曲目
│   ├── video/
│   │   └── performances/               # 表演视频
│   └── README.md                       # 前端资源说明
│
└── src/main/resources/static/            # 后端静态资源
    ├── images/
    ├── audio/
    └── video/
```

## 前端资源使用 (Vue)

### 1. 图片使用
```vue
<img src="/images/gallery/photo1.jpg" alt="Gallery" />
<img src="/images/albums/album-cover.jpg" alt="Album" />
<img src="/images/profiles/artist.jpg" alt="Artist" />
```

### 2. 音频使用
```vue
<audio src="/audio/tracks/song1.mp3" controls></audio>
```

### 3. 视频使用
```vue
<video src="/video/performances/show1.mp4" controls></video>
```

## 后端资源使用 (Spring Boot)

### 访问方式
- 后端静态资源URL: `http://localhost:8080/images/photo.jpg`
- 前端静态资源URL: `http://localhost:5173/images/photo.jpg`

### 在Spring Boot中提供静态资源
资源会自动通过 `classpath:/static/` 提供访问。

## 支持的文件类型

### 图片
- `.png`, `.jpg`, `.jpeg`, `.gif`, `.svg`, `.webp`

### 音频
- `.mp3`, `.wav`, `.ogg`, `.flac`

### 视频
- `.mp4`, `.webm`, `.ogg`

## 在Vue组件中的使用示例

### GallerySection.vue
已添加 `localGalleryImages` 数组，示例本地资源路径：
```javascript
const localGalleryImages = [
  { src: '/images/gallery/studio.jpg', alt: 'Studio', title: 'Recording Studio' }
]
```

### MusicShowcase.vue
已添加本地音频和视频资源路径：
```javascript
const tracks = [
  { id: 1, title: 'Midnight Dreams', src: '/audio/tracks/midnight-dreams.mp3' }
]
const videoSrc = '/video/performances/live-berklee.mp4'
```

## 添加新资源步骤

1. **准备文件**: 准备你的图片、音频、视频文件
2. **选择位置**:
   - 前端资源 → 放入 `public/` 目录
   - 后端资源 → 放入 `src/main/resources/static/` 目录
3. **引用文件**: 在组件中使用相应路径引用

## 注意事项

1. **文件名**: 避免使用中文和特殊字符
2. **文件大小**: 大文件会影响加载速度，建议优化
3. **路径格式**: 使用正斜杠 `/` 而不是反斜杠 `\`
4. **Vite构建**: 构建时，`public/` 目录内容会原样复制到 `dist/` 目录

## 切换使用本地资源

要使用本地资源替换外部图片，只需：

1. 将图片放入 `public/images/` 相应目录
2. 在组件中将外部URL替换为本地路径，如：
   ```vue
   <!-- 之前 -->
   <img src="https://external-url.com/image.jpg" />
   
   <!-- 之后 -->
   <img src="/images/gallery/photo.jpg" />
   ```

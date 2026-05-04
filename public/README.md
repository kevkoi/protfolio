# 静态资源存放说明

## 目录结构

```
public/
├── images/
│   ├── gallery/       # 画廊图片
│   ├── albums/        # 专辑封面
│   └── profiles/      # 个人资料图片
├── audio/
│   └── tracks/        # 音乐曲目
└── video/
    └── performances/  # 表演视频
```

## 使用方法

### 图片使用
```vue
<img src="/images/gallery/photo1.jpg" alt="Gallery" />
<img src="/images/albums/album-cover.jpg" alt="Album" />
<img src="/images/profiles/artist.jpg" alt="Artist" />
```

### 音频使用
```vue
<audio src="/audio/tracks/song1.mp3" controls></audio>
```

### 视频使用
```vue
<video src="/video/performances/show1.mp4" controls></video>
```

## 支持的文件类型

- 图片: `.png`, `.jpg`, `.jpeg`, `.gif`, `.svg`, `.webp`
- 音频: `.mp3`, `.wav`, `.ogg`, `.flac`
- 视频: `.mp4`, `.webm`, `.ogg`

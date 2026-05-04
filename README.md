# Music Portfolio Website

Amy Ren 的音乐作品集网站，基于 Vue 3 + Vite 构建。

## 📋 目录

- [项目介绍](#项目介绍)
- [环境要求](#环境要求)
- [安装步骤](#安装步骤)
- [开发命令](#开发命令)
- [生产部署](#生产部署)
- [内网穿透配置](#内网穿透配置)
- [项目结构](#项目结构)
- [技术栈](#技术栈)

## 🎵 项目介绍

这是一个展示音乐人作品集的个人网站，包含：
- 音乐播放器功能
- 图片画廊展示
- 艺术家简介
- 联系方式

## 💻 环境要求

- Node.js >= 18.0.0
- npm >= 9.0.0

## 📦 安装步骤

```bash
# 克隆项目（如果需要）
git clone <repository-url>

# 进入项目目录
cd ProtfolioWeb

# 安装依赖
npm install
```

## 🛠️ 开发命令

### 开发模式

```bash
npm run dev
```

- 启动开发服务器
- 地址：`http://localhost:5173`
- 特点：热更新启用，适合开发调试

### 代码检查

```bash
npm run lint
```

### 预览生产构建

```bash
npm run preview
```

- 启动生产预览服务器
- 地址：`http://localhost:4173`（或可用端口）
- 特点：压缩优化后的代码，加载速度更快

## 🚀 生产部署

### 构建生产版本

```bash
npm run build
```

- 生成优化后的静态文件
- 输出目录：`dist/`
- 文件会被压缩并优化

### 部署到静态托管

将 `dist` 目录下的文件上传到任何静态托管服务：
- Vercel
- Netlify
- GitHub Pages
- Cloudflare Pages

## 🌐 内网穿透配置

### 配置说明

项目已配置 `allowedHosts` 以支持 cpolar 内网穿透。

### 启动穿透服务

```bash
# 开发模式穿透
cpolar http 5173

# 生产预览穿透
cpolar http 4173
```

### 常用 cpolar 命令

```bash
# 启动 cpolar
cpolar http <端口号>

# 查看在线隧道
cpolar status

# 停止服务
Ctrl + C
```

### 手动添加域名白名单

如需添加新的穿透域名，修改 `vite.config.js`：

```js
server: {
  host: '0.0.0.0',
  port: 5173,
  allowedHosts: ['your-new-domain.cpolar.top', 'localhost', '127.0.0.1']
},
preview: {
  host: '0.0.0.0',
  port: 4173,
  allowedHosts: ['your-new-domain.cpolar.top', 'localhost', '127.0.0.1']
}
```

## 📁 项目结构

```
ProtfolioWeb/
├── public/                 # 静态资源
│   ├── images/            # 图片资源
│   └── audio/             # 音频资源
├── src/
│   ├── assets/            # 动态导入的资源
│   ├── components/        # Vue 组件
│   │   ├── AboutPreview.vue
│   │   ├── ContactSection.vue
│   │   ├── FooterSection.vue
│   │   ├── GallerySection.vue
│   │   ├── HeroSection.vue
│   │   ├── InstagramFeed.vue
│   │   ├── MusicShowcase.vue
│   │   └── NavHeader.vue
│   ├── views/             # 页面视图
│   ├── App.vue            # 根组件
│   └── main.js            # 入口文件
├── index.html             # HTML 入口
├── package.json           # 项目配置
└── vite.config.js         # Vite 配置
```

## 🛠️ 技术栈

| 技术 | 版本 | 用途 |
|------|------|------|
| Vue | ^3.4.21 | 渐进式 JavaScript 框架 |
| Vue Router | ^4.3.0 | 页面路由管理 |
| Vite | ^5.1.0 | 下一代前端构建工具 |
| Axios | ^1.6.7 | HTTP 请求库 |
| Lucide Vue Next | ^0.264.0 | 图标库 |
| Sass | ^1.70.0 | CSS 预处理器 |

## 📝 CDN 资源

项目使用 GitHub Releases + jsDelivr CDN 托管静态资源：

```
https://cdn.jsdelivr.net/gh/kevkoi/portfolio-assets@v1.0/<文件路径>
```

如需更新资源：
1. 上传新文件到 GitHub 仓库
2. 创建新的 Release
3. 更新代码中的 CDN 链接版本号

## 🔧 常见问题

### Q: 端口被占用怎么办？

```bash
# 查看端口占用
netstat -ano | findstr :5173

# 结束占用进程
taskkill /F /PID <进程ID>
```

### Q: 穿透后无法访问？

1. 检查 cpolar 状态是否 online
2. 确认端口号是否正确
3. 尝试重启 cpolar 服务
4. 检查防火墙设置

### Q: 图片/音频加载慢？

静态资源已配置 CDN 加速。如需进一步优化：
1. 压缩图片（推荐 TinyPNG）
2. 压缩音频（推荐 192kbps）
3. 更新 GitHub Release
4. 清除浏览器缓存

## 📄 许可证

MIT License

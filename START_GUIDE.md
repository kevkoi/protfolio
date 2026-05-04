# 启动配置说明

## 🚀 快速启动

### 开发模式

```bash
# 普通开发模式
npm run dev

# 指定端口 5173 开发
npm run dev:5173

# 外部访问开发模式（推荐用于穿透）
npm run dev:host
```

### 生产预览

```bash
# 普通预览模式
npm run preview

# 指定端口 4173 预览
npm run preview:4173

# 外部访问预览模式（推荐用于穿透）
npm run preview:host
```

### 生产构建

```bash
# 构建生产版本
npm run build
```

## 📋 命令说明

| 命令 | 说明 | 地址 | 用途 |
|------|------|------|------|
| `npm run dev` | 开发模式 | `http://localhost:5173` | 本地开发，热更新 |
| `npm run dev:5173` | 固定端口5173开发 | `http://localhost:5173` | 需要固定端口 |
| `npm run dev:host` | 外部访问开发 | `http://0.0.0.0:5173` | 配合内网穿透 |
| `npm run build` | 构建生产版本 | `dist/` | 部署前构建 |
| `npm run preview` | 预览生产版本 | `http://localhost:4173` | 测试生产代码 |
| `npm run preview:4173` | 固定端口4173预览 | `http://localhost:4173` | 需要固定端口 |
| `npm run preview:host` | 外部访问预览 | `http://0.0.0.0:4173` | 配合内网穿透 |

## 🌐 配合内网穿透使用

### 开发模式穿透

```bash
# 终端1：启动开发服务器
npm run dev:host

# 终端2：启动cpolar
cpolar http 5173
```

### 生产预览穿透（推荐）

```bash
# 终端1：启动预览服务器
npm run preview:host

# 终端2：启动cpolar
cpolar http 4173
```

### 访问地址

cpolar 会生成类似地址：
```
http://xxx.cpolar.top  ->  http://localhost:4173
```

## ⚙️ 配置说明

### vite.config.js 配置

```javascript
export default defineConfig({
  // 开发服务器配置
  server: {
    host: '0.0.0.0',
    port: 5173,
    allowedHosts: 'all'  // 允许所有域名访问
  },
  
  // 预览服务器配置
  preview: {
    host: '0.0.0.0',
    port: 4173,
    allowedHosts: ['your-domain.cpolar.top', 'localhost', '127.0.0.1']
  }
})
```

### 添加新的穿透域名

编辑 `vite.config.js`，在 `allowedHosts` 数组中添加：

```javascript
preview: {
  allowedHosts: [
    'new-domain.cpolar.top',  // 新增域名
    'existing-domain.cpolar.top',
    'localhost',
    '127.0.0.1'
  ]
}
```

## 🔧 常见问题

### 端口被占用

```bash
# Windows 查看端口占用
netstat -ano | findstr :5173

# 结束进程
taskkill /F /PID <进程ID>
```

### cpolar 生成新域名

每次重启 cpolar 可能生成新域名，需要：
1. 将新域名添加到 `vite.config.js`
2. 重启服务器

### 访问被阻止

确保在 `vite.config.js` 中配置了：
```javascript
allowedHosts: 'all'  // 或者包含你的域名
```

## 📌 推荐工作流程

### 日常开发

```bash
npm run dev
```

### 对外展示

```bash
npm run build           # 构建
npm run preview:host   # 启动预览服务器
cpolar http 4173       # 启动穿透
```

### 部署前测试

```bash
npm run build
npm run preview
# 浏览器访问 http://localhost:4173
```

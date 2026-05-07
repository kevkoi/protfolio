# 邮件发送功能配置与使用指南

## 🎉 当前状态

✅ **前端已启动** - http://localhost:5174/
✅ **后端已启动** - http://localhost:8080/

## 📋 完整启动说明

### 1️⃣ 配置邮件密码（重要）

编辑项目根目录下的 `.env` 文件：

```env
EMAIL_USER=flora.r.0571@gmail.com
EMAIL_PASS=your-app-password  # 这里填入你的 Gmail 应用专用密码
EMAIL_TO=flora.r.0571@gmail.com
PORT=8080
```

#### 如何获取 Gmail 应用专用密码：

1. 登录你的 Google 账号：https://myaccount.google.com/
2. 启用 **两步验证**（如果还没启用）
3. 访问：https://myaccount.google.com/apppasswords
4. 选择应用：**邮件 (Mail)**
5. 选择设备：**其他 (Custom)**，输入名称：`Portfolio Website`
6. 点击 **生成**
7. 复制生成的 16 位密码（中间有空格也没关系）
8. 将密码填入 `.env` 文件的 `EMAIL_PASS` 字段

### 2️⃣ 重启后端服务器

配置好密码后，在运行后端的终端按 `Ctrl+C` 停止，然后重新运行：

```bash
npm run server
```

### 3️⃣ 测试邮件发送

1. 在浏览器中访问 http://localhost:5174/
2. 滚动到联系表单区域
3. 填写姓名、邮箱、消息
4. 点击 **发送消息**
5. 检查你的 Gmail 收件箱！

## 🚀 日常启动

### 启动前端
```bash
npm run dev
```

### 启动后端
```bash
npm run server
```

或者使用开发模式（自动重启）：
```bash
npm run server:dev
```

## 📂 项目文件说明

| 文件 | 说明 |
|------|------|
| `server.js` | Node.js 后端服务器 |
| `.env` | 环境配置（包含邮箱密码） |
| `.env.example` | 配置文件示例模板 |
| `src/components/ContactSection.vue` | 前端联系表单组件 |

## 🔧 后端 API

### 健康检查
```
GET http://localhost:8080/api/health
```

### 发送邮件
```
POST http://localhost:8080/api/send-email
Content-Type: application/json

{
  "name": "Your Name",
  "email": "your@email.com",
  "message": "Your message here..."
}
```

## ⚠️ 注意事项

1. **不要提交 `.env` 文件到 Git** - 里面包含敏感密码
2. **Gmail 应用专用密码** - 不能使用 Gmail 的登录密码
3. **端口占用** - 如果 8080 端口被占用，可以在 `.env` 中修改 `PORT` 为其他值

## 🎯 测试清单

- [ ] 配置好 Gmail 应用专用密码
- [ ] 后端服务器正常运行（http://localhost:8080）
- [ ] 前端服务器正常运行（http://localhost:5174）
- [ ] 填写表单，成功发送邮件
- [ ] 收到了测试邮件！

## 🆘 遇到问题？

### 邮件发送失败
- 检查 `.env` 中的密码是否正确
- 确保 Gmail 两步验证已开启
- 查看后端终端的错误日志

### 无法连接后端
- 确认后端服务器在运行
- 检查浏览器控制台的错误信息
- 确认端口没有被占用

---

祝使用愉快！🎵

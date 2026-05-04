# 邮件功能配置指南

## 1. 获取 Gmail 应用专用密码

由于 Gmail 的安全策略，您需要创建一个应用专用密码：

1. 登录您的 Google 账户
2. 访问：https://myaccount.google.com/security
3. 开启 **两步验证**（如果尚未开启）
4. 开启后，访问：https://myaccount.google.com/apppasswords
5. 选择应用类型：**Mail**
6. 选择设备：**Other (Custom Name)**，输入 "Portfolio Website"
7. 点击 **生成**，复制生成的 16 位密码

## 2. 配置 application.properties

编辑 `src/main/resources/application.properties` 文件：

```properties
# 邮件配置
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=flora.r.0571@gmail.com
# 替换为您的 Gmail 应用专用密码
spring.mail.password=your-generated-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com

# 收件人邮箱（可以和发送邮箱相同）
portfolio.email.to=flora.r.0571@gmail.com
```

## 3. 启动 Spring Boot 后端

### 方法一：使用 Maven（推荐）
```bash
# 进入项目目录
cd g:\work\personal_web\ProtfolioWeb

# 使用 Maven 编译并运行
.\mvnw.cmd spring-boot:run
```

### 方法二：使用 IDE
- 在 IntelliJ IDEA 或 Eclipse 中导入 Maven 项目
- 找到 `ProtfolioWebApplication.java` 并运行

## 4. 启动 Vue 前端（开发模式）

打开另一个终端窗口：
```bash
cd g:\work\personal_web\ProtfolioWeb
npm run dev
```

## 5. 访问网站

- 前端地址：http://localhost:5173
- 后端地址：http://localhost:8080

## 6. 测试邮件功能

1. 在网站上填写联系表单
2. 点击 "Send Message"
3. 检查您的 Gmail 收件箱，应该能收到邮件

## 故障排除

### 问题 1：邮件发送失败
- 检查网络连接
- 确认应用专用密码正确
- 查看后端控制台错误日志

### 问题 2：CORS 错误
- 项目已配置允许所有来源访问，应该不会有问题
- 如果遇到，检查 WebConfig.java

### 问题 3：找不到或加载主类
- 确保您在正确的项目目录下
- 运行 `mvn clean compile` 重新编译

## 使用其他邮箱服务商

如果不使用 Gmail，请修改配置：

### QQ 邮箱
```properties
spring.mail.host=smtp.qq.com
spring.mail.port=587
```

### 163 邮箱
```properties
spring.mail.host=smtp.163.com
spring.mail.port=465
spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
```

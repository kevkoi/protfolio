require('dotenv').config();
const express = require('express');
const cors = require('cors');
const nodemailer = require('nodemailer');

const app = express();
const PORT = process.env.PORT || 8080;

// 中间件
app.use(cors());
app.use(express.json());

// 配置邮件发送器
const transporter = nodemailer.createTransport({
    host: 'smtp.gmail.com',
    port: 465,
    secure: true,
    auth: {
        user: process.env.EMAIL_USER || 'flora.r.0571@gmail.com',
        pass: process.env.EMAIL_PASS || 'your-app-password'
    }
});

// 健康检查
app.get('/api/health', (req, res) => {
    res.json({ status: 'ok', message: 'Server is running' });
});

// 发送邮件接口
app.post('/api/send-email', async (req, res) => {
    try {
        const { name, email, message } = req.body;
        
        console.log('Received email request:', { name, email });

        // 验证必填字段
        if (!name || !email || !message) {
            return res.status(400).json({
                success: false,
                message: 'Name, email and message are required'
            });
        }

        // 邮件内容
        const mailOptions = {
            from: process.env.EMAIL_USER || 'flora.r.0571@gmail.com',
            to: process.env.EMAIL_TO || 'flora.r.0571@gmail.com',
            subject: `New Contact Message from ${name}`,
            text: `
You have received a new message from your portfolio website!

Name: ${name}
Email: ${email}

Message:
${message}
            `.trim()
        };

        // 发送邮件
        const info = await transporter.sendMail(mailOptions);
        console.log('Email sent successfully:', info.messageId);

        res.json({
            success: true,
            message: 'Email sent successfully!'
        });

    } catch (error) {
        console.error('Error sending email:', error);
        res.status(500).json({
            success: false,
            message: `Failed to send email: ${error.message}`
        });
    }
});

// 启动服务器
app.listen(PORT, () => {
    console.log(`
===========================================
🚀 Portfolio Backend Server is running!
📡 Port: ${PORT}
🌐 Health Check: http://localhost:${PORT}/api/health
===========================================
    `.trim());
});

module.exports = app;

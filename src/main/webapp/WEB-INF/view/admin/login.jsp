<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="../resources/css/login.css"> 
</head>
<body>
    <div class="login-container">
        <h2>Đăng nhập vào hệ thống</h2>
        <form id="loginForm"> 
            <div class="input-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Nhập email của bạn" required>
                <span class="error-message" id="emailError"></span> 
            </div>
            <div class="input-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" placeholder="Nhập mật khẩu của bạn" required>
                <span class="error-message" id="passwordError"></span> 
            </div>
            <button type="submit">Đăng nhập</button>
        </form>
        <div class="links">
            <a href="./register.html">Đăng ký</a> | <a href="#">Quên mật khẩu?</a>
        </div>
        <div class="social-login">
            <p>Hoặc đăng nhập bằng:</p>
            <a href="/oauth2/authorization/google" class="google-login"><img src="../resources/img/google-logo.svg" alt="Google">Google</a>
        </div>
    </div>
    <script src="../resources/js/login.js"></script> 
</body>
</html>
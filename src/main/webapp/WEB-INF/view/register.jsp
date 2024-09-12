<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <style>
        /* Basic Styling - mostly reused from login.css */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0; 
        }

        .login-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px; 
        }

        h2 {
            text-align: center;
            margin-bottom: 25px; 
            color: #333; 
        }

        .input-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; 
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #28a745; /* Green for registration */
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px; 
        }

        button:hover {
            background-color: #218838; /* Darker green on hover */
        }

        .links {
            text-align: center;
            margin-top: 15px; 
        }

        .links a {
            color: #007bff;
            text-decoration: none;
        }

        .links a:hover {
            text-decoration: underline;
        }

        /* Error Message Styling */
        .error-message {
            color: #d9534f; /* Red for error messages */
            font-size: 12px; 
            display: none; 
        }

        .social-login {
            text-align: center;
            margin-top: 20px;
        }

        .social-login a {
            display: block;
            margin: 0 auto;
            text-align: center;
            text-decoration: none;
            color: #333; 
        }

        .social-login img {
            height: 20px;
            width: auto;
            vertical-align: middle;
            margin-right: 5px;
        }

        .google-login {
            color: #db4437; 
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Đăng ký tài khoản</h2>
        <form id="registerForm">
            <div class="input-group">
                <label for="fullname">Họ và tên:</label>
                <input type="text" id="fullname" name="fullname" placeholder="Nhập họ và tên của bạn" required>
                <span class="error-message" id="fullnameError"></span>
            </div>
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
            <div class="input-group">
                <label for="confirmPassword">Xác nhận mật khẩu:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Nhập lại mật khẩu" required>
                <span class="error-message" id="confirmPasswordError"></span>
            </div>
            <button type="submit">Đăng ký</button>
        </form>
        <div class="links">
            <p>Đã có tài khoản? <a href="/admin/login">Đăng nhập</a></p> 
        </div>
        <div class="social-login">
            <p>Hoặc đăng nhập bằng:</p>
            <a href="/oauth2/authorization/google" class="google-login"><img src="./google-logo.svg" alt="Google"> Google</a>
        </div>
    </div>
    <script>
        document.getElementById('registerForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent default form submission

            // Client-side validation
            let fullname = document.getElementById('fullname').value;
            let email = document.getElementById('email').value;
            let password = document.getElementById('password').value;
            let confirmPassword = document.getElementById('confirmPassword').value;

            let isValid = true;

            // Full name validation
            if (fullname === "") {
                document.getElementById('fullnameError').textContent = "Vui lòng nhập họ và tên.";
                document.getElementById('fullnameError').style.display = "block";
                isValid = false;
            } else {
                document.getElementById('fullnameError').style.display = "none";
            }

            // Email validation
            if (email === "") {
                document.getElementById('emailError').textContent = "Vui lòng nhập email.";
                document.getElementById('emailError').style.display = "block";
                isValid = false;
            } else if (!isValidEmail(email)) {
                document.getElementById('emailError').textContent = "Email không hợp lệ.";
                document.getElementById('emailError').style.display = "block";
                isValid = false;
            } else {
                document.getElementById('emailError').style.display = "none";
            }

            // Password validation
            if (password === "") {
                document.getElementById('passwordError').textContent = "Vui lòng nhập mật khẩu.";
                document.getElementById('passwordError').style.display = "block";
                isValid = false;
            } else if (password.length < 6) {
                document.getElementById('passwordError').textContent = "Mật khẩu phải có ít nhất 6 ký tự.";
                document.getElementById('passwordError').style.display = "block";
                isValid = false;
            } else {
                document.getElementById('passwordError').style.display = "none";
            }

            // Confirm password validation
            if (confirmPassword === "") {
                document.getElementById('confirmPasswordError').textContent = "Vui lòng xác nhận mật khẩu.";
                document.getElementById('confirmPasswordError').style.display = "block";
                isValid = false;
            } else if (confirmPassword !== password) {
                document.getElementById('confirmPasswordError').textContent = "Mật khẩu xác nhận không khớp.";
                document.getElementById('confirmPasswordError').style.display = "block";
                isValid = false;
            } else {
                document.getElementById('confirmPasswordError').style.display = "none";
            }

            if (isValid) {
                // If the form is valid, you can proceed with submitting the data to the server
                // For example, using AJAX or by allowing the default form submission
                alert("Registration successful!"); // Replace with your actual registration logic
                window.location.href = "./login.html"; 
            }
        });

        // Helper function to validate email format (basic check)
        function isValidEmail(email) {
            return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
        }
    </script>
</body>
</html>
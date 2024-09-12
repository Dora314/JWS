<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <style>
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
            background-color: #007bff; 
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px; 
        }

        button:hover {
            background-color: #0056b3; 
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

        .error-message {
            color: #d9534f; 
            font-size: 12px; 
            display: none; 
        }
    </style>
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
            <a href="/admin/register">Đăng ký</a>
        </div>
        <div class="social-login">
            <p>Hoặc đăng nhập bằng:</p>
            <a href="/login/oauth2/code/google" class="google-login"><img src="./google-logo.svg" alt="Google">Google</a>
        </div>
    </div>
    <script>
        document.getElementById('loginForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent default form submission

            // Basic client-side validation (you can add more robust checks)
            let email = document.getElementById('email').value;
            let password = document.getElementById('password').value;

            let isValid = true;

            if (email === "") {
                document.getElementById('emailError').textContent = "Vui lòng nhập email.";
                document.getElementById('emailError').style.display = "block";
                isValid = false;
            } else {
                document.getElementById('emailError').style.display = "none";
            }

            if (password === "") {
                document.getElementById('passwordError').textContent = "Vui lòng nhập mật khẩu.";
                document.getElementById('passwordError').style.display = "block";
                isValid = false;
            } else {
                document.getElementById('passwordError').style.display = "none";
            }

            if (isValid) {
                // If the form is valid, you can proceed with submitting the data to the server
                // For example, using AJAX or by allowing the default form submission
                alert("Form submitted successfully!"); // Replace with your actual form submission logic
            }
        });
    </script>
</body>
</html>
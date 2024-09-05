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
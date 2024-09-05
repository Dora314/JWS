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
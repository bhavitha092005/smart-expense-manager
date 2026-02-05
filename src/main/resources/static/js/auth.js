const API_BASE_URL = "http://localhost:8080/api";

const loginForm = document.getElementById("loginForm");
const registerForm = document.getElementById("registerForm");
const message = document.getElementById("message");

/* ===================== LOGIN ===================== */
if (loginForm) {
    loginForm.addEventListener("submit", async (e) => {
        e.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        try {
            const response = await fetch(`${API_BASE_URL}/auth/login`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ username, password })
            });

            if (!response.ok) {
                message.style.color = "red";
                message.innerText = "Invalid username or password";
                return;
            }

            const data = await response.json();

            // ✅ SAVE JWT TOKEN
            localStorage.setItem("token", data.token);

            // ✅ REDIRECT TO DASHBOARD
            window.location.href = "dashboard.html";

        } catch (error) {
            message.style.color = "red";
            message.innerText = "Server error. Please try again.";
        }
    });
}

/* ===================== REGISTER ===================== */
if (registerForm) {
    registerForm.addEventListener("submit", async (e) => {
        e.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        try {
            const response = await fetch(`${API_BASE_URL}/auth/register`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ username, password })
            });

            if (response.ok) {
                message.style.color = "green";
                message.innerText = "Registration successful! Redirecting to login...";

                // ⏳ Redirect to login page after 1.5 seconds
                setTimeout(() => {
                    window.location.href = "login.html";
                }, 1500);

            } else {
                message.style.color = "red";
                message.innerText = "Registration failed. Username may already exist.";
            }

        } catch (error) {
            message.style.color = "red";
            message.innerText = "Server error. Please try again.";
        }
    });
}

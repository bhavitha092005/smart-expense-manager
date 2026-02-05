const API_BASE_URL = "http://localhost:8080/api";
const token = localStorage.getItem("token");

if (!token) {
    window.location.href = "index.html";
}

function logout() {
    localStorage.removeItem("token");
    window.location.href = "index.html";
}

async function loadDashboard() {

    const now = new Date();
    const month = now.getMonth() + 1;
    const year = now.getFullYear();

    const response = await fetch(
        `${API_BASE_URL}/dashboard?month=${month}&year=${year}`, {
            headers: {
                "Authorization": "Bearer " + token
            }
        }
    );

    if (!response.ok) {
        alert("Failed to load dashboard");
        return;
    }

    const data = await response.json();

    document.getElementById("totalExpenses").innerText = data.totalExpenses;
    document.getElementById("budgetAmount").innerText = data.budget;
    document.getElementById("remainingAmount").innerText = data.remaining;

    const percentage = data.budget > 0
        ? (data.totalExpenses / data.budget) * 100
        : 0;

    document.getElementById("progress").style.width =
        Math.min(percentage, 100) + "%";
}

loadDashboard();

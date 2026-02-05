const budgetForm = document.getElementById("budgetForm");

budgetForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const month = document.getElementById("budgetMonth").value;
    const year = document.getElementById("budgetYear").value;
    const amount = document.getElementById("budgetAmountInput").value;

    const response = await fetch(`${API_BASE_URL}/budget`, {
        method: "POST",
        headers: {
            "Authorization": "Bearer " + token,
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ month, year, amount })
    });

    if (response.ok) {
        alert("Budget saved successfully");
        loadDashboard();
    } else {
        alert("Failed to save budget");
    }
});

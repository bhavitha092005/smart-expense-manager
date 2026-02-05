const expenseForm = document.getElementById("expenseForm");
const expenseTableBody = document.getElementById("expenseTableBody");

async function loadExpenses() {

    const response = await fetch(`${API_BASE_URL}/expenses`, {
        headers: {
            "Authorization": "Bearer " + token
        }
    });

    const expenses = await response.json();
    expenseTableBody.innerHTML = "";

    expenses.forEach(expense => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${expense.category}</td>
            <td>${expense.amount}</td>
            <td>${expense.date}</td>
            <td>${expense.description || ""}</td>
        `;

        expenseTableBody.appendChild(row);
    });
}

expenseForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const category = document.getElementById("category").value;
    const amount = document.getElementById("amount").value;
    const date = document.getElementById("date").value;
    const description = document.getElementById("description").value;

    const response = await fetch(`${API_BASE_URL}/expenses`, {
        method: "POST",
        headers: {
            "Authorization": "Bearer " + token,
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ category, amount, date, description })
    });

    if (response.ok) {
        expenseForm.reset();
        loadExpenses();
        loadDashboard();
    } else {
        alert("Failed to add expense");
    }
});

loadExpenses();

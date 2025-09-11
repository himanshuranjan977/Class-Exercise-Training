document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form refresh
    
    let username = document.getElementById("username").value.trim();
    let password = document.getElementById("password").value.trim();

    if (!username || !password) {
        alert("Please enter both username and password.");
        return;
    }

    if (username === "admin" && password === "admin") {
        alert("Correct");
    } else {
        alert("Wrong");
    }
});

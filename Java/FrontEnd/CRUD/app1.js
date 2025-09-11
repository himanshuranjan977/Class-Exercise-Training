window.onload = function () {
    loadUsers();
};

function loadUsers() {
    const apiUrl = "https://jsonplaceholder.typicode.com/posts";
    document.getElementById("loading-bar").classList.remove("d-none");

    var userList = document.getElementById("user-list");
    var rows = "";

    $.ajax({
        url: apiUrl,
        method: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            data.forEach(post => {
                rows += `<tr>
                    <td>${post.userId}</td>
                    <td>${post.id}</td>
                    <td>${post.title}</td>
                    <td>${post.body}</td>
                    <td>
                        <button class="btn btn-danger btn-sm" onclick="deleteUser(${post.id})">Delete</button>
                        <button class="btn btn-warning btn-sm" onclick="editUser(${post.id})">Edit</button>
                    </td>
                </tr>`;
            });
            userList.innerHTML = rows;
            document.getElementById("loading-bar").classList.add("d-none");
        },
        error: function (error) {
            console.error("Error fetching users:", error);
            document.getElementById("loading-bar").classList.add("d-none");
        }
    });
}

function editUser(id) {
    $.get(`https://jsonplaceholder.typicode.com/posts/${id}`, function(post) {
        document.getElementById("id").value = post.id;
        document.getElementById("Userid").value = post.userId;
        document.getElementById("title").value = post.title;
        document.getElementById("body").value = post.body;
    });
}

function updateUser(event) {
    event.preventDefault();
    const id = document.getElementById("id").value;
    const updatedData = {
        userId: document.getElementById("Userid").value,
        title: document.getElementById("title").value,
        body: document.getElementById("body").value
    };

    $.ajax({
        url: `https://jsonplaceholder.typicode.com/posts/${id}`,
        method: "PUT",
        data: updatedData,
        success: function(response) {
            alert("Post updated successfully!");
            loadUsers();
        },
        error: function(error) {
            console.error("Error updating post:", error);
        }
    });
}

function deleteUser(id) {
    $.ajax({
        url: `https://jsonplaceholder.typicode.com/posts/${id}`,
        method: "DELETE",
        success: function() {
            alert("Post deleted successfully!");
            loadUsers();
        },
        error: function(error) {
            console.error("Error deleting post:", error);
        }
    });
}

window.onload = function () {
    loadUsers();
}

function loadUsers() {
    const apiUrl = "https://jsonplaceholder.typicode.com/users";
    document.getElementById("loading-list").classList.remove("d-done");

    var userList = document.getElementById("user-list");
    var rows = "";
  
    $.ajax({
        url: apiUrl,
        method: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            data.forEach(temp => {
                rows += '<tr>'
                    + '<td>' + temp['username'] + '</td>'
                    + '<td>' + temp['company']['name'] + '</td>'
                    + '<td>' + temp['address']['city'] + '</td>'
                    + '<td>' + temp['address']['zipcode'] + '</td>'
                    + '<td><button type="button" class="btn btn-danger btn-sm" onclick="deleteUser(' + temp['id'] + ')">Delete</button>  <button type="button" class="btn btn-warning btn-sm" onclick="editUser(' + temp['id'] + ')">Edit</button></td>'

                    + '<td> </td>'
                    + '</tr>';
            });
            userList.innerHTML = rows;
            document.getElementById("loading-list").classList.add("d-done");
        },
        error: function (error) {
            console.error("Error fetching users:", error);
            document.getElementById("loading-list").classList.remove("d-done");
        }
    });

    
}
function deleteUser(id) {
    var userConfirmation = confirm("Are you sure to delete this user?");
    if (userConfirmation) {
        const apiUrl = "https://jsonplaceholder.typicode.com/users/" + id;
        $.ajax({
            url: apiUrl,
            method: "DELETE",
            success: function(response) {
                alert("User deleted successfully");
                loadUsers(); // reload table
            },
            error: function(error) {
                console.error("Error deleting user:", error);
            }
        });
    } else {
        alert("Delete cancelled by user");
    }
}

function editUser(id){
    const apiUrl = "https://jsonplaceholder.typicode.com/users/" + id;
    $.ajax({
        url: apiUrl,
        method: "GET",
        dataType: "json",
        success: function(userInfo){
            document.getElementById("id").value = userInfo.id; // ✅ Store ID
            document.getElementById("username").value = userInfo.username;
            document.getElementById("companyname").value = userInfo.company.name;
            document.getElementById("city").value = userInfo.address.city;
            document.getElementById("zipcode").value = userInfo.address.zipcode;
        },
        error:function(error){
            console.error(error);
        }
    });
}

/*function editUser(id){
    const apiUrl = "https://jsonplaceholder.typicode.com/users/" + id;
    $.ajax({
        url: apiUrl,
        method: "GET",
        dataType: "json",
        success: function(userInfo){
            document.getElementById("username").value=userInfo['username'];
            document.getElementById("companyname").value=userInfo['company']['name'];
            document.getElementById("city").value=userInfo['address']['city'];
            document.getElementById("zipcode").value=userInfo['address']['zipcode'];
        },
        error:function(error){
            console.error(error);
        }

    });
    
}*/
/*function updateUser(event){
    event.preventDefault();
    var id =document.getElementById("id").value;
    const apiUrl = "https://jsonplaceholder.typicode.com/users/" + id;

    var username =document.getElementById("username").value;
    var companyname =document.getElementById("companyname").value;
    var city =document.getElementById("city").value;
    var zipcode =document.getElementById("zipcode").value;

    var jasonObject ={
        username :username,
        company: {
            name: companyname
        },
        address:{
            city:city,
            zipcode: zipcode
        }
    }
    $.ajax({
        url: apiUrl,
        method: "PUT",
        data: JSON.stringify(jasonObject),
        contentType: "application/json",
        success: function(response){
            alert("User updated successfully");
            loadUsers();
        },
        error: function(error){
            console.error(error);
        }
    });
}*/
function updateUser(event) {
    event.preventDefault();

    var id = document.getElementById("id").value;
    

    const apiUrl = "https://jsonplaceholder.typicode.com/users/" + id;

    var username = document.getElementById("username").value;
    var companyname = document.getElementById("companyname").value;
    var city = document.getElementById("city").value;
    var zipcode = document.getElementById("zipcode").value;

    var jsonObject = {
        username: username,
        company: {
            name: companyname
        },
        address: {
            city: city,
            zipcode: zipcode
        }
    };

    $.ajax({
        url: apiUrl,
        method: "PUT",
        data: JSON.stringify(jsonObject),
        contentType: "application/json",
        success: function (response) {
            alert("User updated successfully");
            loadUsers();
           
        },
        error: function (error) {
            console.error("Error updating user:", error);
            alert("Failed to update user");
            $("#loading-list").addClass("d-none"); // Hide loading on error
        }
    });
}


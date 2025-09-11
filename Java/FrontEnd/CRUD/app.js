function addUser(event){
    event.preventDefault();
    alert("added user");
    const url="https://jsonplaceholder.typicode.com/users/";

    var username=document.getElementById("username").value;
    var companyname=document.getElementById("companyname").value;
    var city=document.getElementById("city").value;
    var zipcode=document.getElementById("zipcode").value;

    var jsonObject={
        username:username,
        company:{
            name:companyname
        },
        address:{
            city:city,
            zipcode:zipcode
        }
    }

    $.ajax({
        url:url,
        method:"POST",
        data:JSON.stringify(jsonObject),
        contentType:"application/json",
        success:function(){
            alert("new user added");
        },
        error:function(error){
            console.log(error);
        }
    });
}
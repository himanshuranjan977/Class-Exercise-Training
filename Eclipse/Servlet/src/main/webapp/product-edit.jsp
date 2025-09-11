<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>

</head>
<body>

<h3>Edit the Product Information</h3>

<form action="product-update" method="get">
    <div>
        <label>Id</label>
        <input type="text" name="id" value="<%= request.getAttribute("id") %>" readonly />
    </div>

    <div>
        <label>Name</label>
        <input type="text" name="name" value="<%= request.getAttribute("name") %>" required />
    </div>

    <div>
        <label>Price</label>
        <input type="text" name="price" value="<%= request.getAttribute("price") %>" required />
    </div>

    <div>
        <label>Discount</label>
        <input type="text" name="discount" value="<%= request.getAttribute("discount") %>" required />
    </div>

    <div>
        <label>Unit</label>
        <input type="text" name="unit" value="<%= request.getAttribute("unit") %>" required />
    </div>

    <div>
        <button type="submit">Update</button>
    </div>
</form>

</body>
</html>

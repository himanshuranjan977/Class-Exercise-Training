<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Contact</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="container py-4">

    <h2 class="mb-3">Edit Contact</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/edit" class="row g-3">
        <input type="hidden" name="id" value="${contact.id}"/>
        <div class="col-md-6">
            <label class="form-label">Name</label>
            <input name="name" class="form-control" value="${contact.name}" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Phone</label>
            <input name="phone" class="form-control" value="${contact.phone}" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Email</label>
            <input type="email" name="email" class="form-control" value="${contact.email}" required>
        </div>
        <div class="col-12">
            <button class="btn btn-primary">Update</button>
            <a href="${pageContext.request.contextPath}/list" class="btn btn-secondary">Cancel</a>
        </div>
    </form>

</body>
</html>

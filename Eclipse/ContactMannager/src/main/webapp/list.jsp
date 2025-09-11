<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Contacts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="container py-4">

<div class="d-flex justify-content-between align-items-center mb-3">
    <h2 class="m-0">My Contacts</h2>
    <div>
        <a href="${pageContext.request.contextPath}/add" class="btn btn-success">Add Contact</a>
        <a href="${pageContext.request.contextPath}/" class="btn btn-outline-secondary">Home</a>
    </div>
</div>

<!-- Flash messages -->
<c:if test="${not empty sessionScope.flashSuccess}">
    <div class="alert alert-success">${sessionScope.flashSuccess}</div>
    <c:remove var="flashSuccess" scope="session"/>
</c:if>
<c:if test="${not empty sessionScope.flashError}">
    <div class="alert alert-danger">${sessionScope.flashError}</div>
    <c:remove var="flashError" scope="session"/>
</c:if>

<div class="card">
    <div class="card-body p-0">
        <div class="table-responsive">
            <table class="table table-striped mb-0">
                <thead class="table-light">
                <tr>
                    <th style="width: 80px;">ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th style="width: 160px;">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty contacts}">
                    <tr>
                        <td colspan="5" class="text-center text-muted py-4">No contacts found.</td>
                    </tr>
                </c:if>
                <c:forEach var="c" items="${contacts}">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>
                        <td>${c.phone}</td>
                        <td>${c.email}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/edit?id=${c.id}"
                               class="btn btn-sm btn-warning">Edit</a>
                            <a href="${pageContext.request.contextPath}/delete?id=${c.id}"
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('Delete this contact?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>


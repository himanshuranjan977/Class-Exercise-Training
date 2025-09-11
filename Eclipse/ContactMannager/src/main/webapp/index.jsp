<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Manager</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="container py-5">
    <div class="text-center">
        <h1 class="mb-3">Welcome to Contact Manager</h1>
        <p class="text-muted mb-4">Manage your contacts efficiently.</p>
        <a href="<%=request.getContextPath()%>/add" class="btn btn-success me-2">Add Contact</a>
        <a href="<%=request.getContextPath()%>/list" class="btn btn-primary">View Contacts</a>
    </div>
</body>
</html>

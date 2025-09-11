<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Simcard</title>
</head>
<body>
    <h2>Add Simcard</h2>
    <form action="savesimcard" method="post">
        Company: <input type="text" name="company" required/><br/><br/>
        Plan Name: <input type="text" name="planName" required/><br/><br/>
        <input type="submit" value="Save"/>
    </form>
    <br/>
    <a href="listsimcards">Back to List</a>
</body>
</html>

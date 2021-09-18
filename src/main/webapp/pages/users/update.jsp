<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>Update </title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<div class="card text-center">
    <div class="card-header">
        <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
                <a class="nav-link active" aria-current="true" href="/user/account">Info</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link active" href="/user/userPosts">Posts</a>
            </li>
        </ul>
    </div>
    <div class="card-body">
        <a href="/FeedBlog_war/users/updateByName" class="btn btn-primary">Update name</a>
    </div>
    <div class="card-body">
        <a href="/FeedBlog_war/users/updateByEmail" class="btn btn-primary">Update email</a>
    </div>
    <div class="card-body">
        <a href="/FeedBlog_war/users/updateByPassword" class="btn btn-primary">Update password</a>
    </div>
    <div class="card-body">
        <a href="/FeedBlog_war/users/delete" class="btn btn-primary">Delete</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
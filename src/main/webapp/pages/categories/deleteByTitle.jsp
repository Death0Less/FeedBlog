<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    !-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>Delete by title</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>

<div class="container">
    <form action="/FeedBlog_war/categories/deleteByTitle" method="post">
        <div class="form-group">
            <label for="exampleInputDeleteCategoryByTitle1">Delete By Title</label>
            <input name="categoryName" type="text" class="form-control" id="exampleInputDeleteCategoryByTitle1" placeholder="Enter title...">
        </div>
        <button type="submit" class="btn btn-primary">Delete</button>
    </form>
    ${message}
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</body>
</html>

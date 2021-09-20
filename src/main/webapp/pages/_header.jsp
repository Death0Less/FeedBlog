<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">FeedBlog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <c:if test="${sessionScope.user == null}">
        <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello Guest</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/FeedBlog_war/registration">Registration</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/FeedBlog_war/authorization">Authorization</a>
        </li>
    </c:if>
        <c:if test="${sessionScope.user != null}">
            <c:if test="${sessionScope.user.role.name().equals('USER')}">
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello ${sessionScope.user.name}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FeedBlog_war/posts/save">Create post</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FeedBlog_war/users/account">Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FeedBlog_war/logout">Log out</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.user.role.name().equals('ADMIN')}">
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello ${sessionScope.user.name}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FeedBlog_war/posts/save">Create post</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FeedBlog_war/users/account">Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FeedBlog_war/logout">Log out</a>
                </li>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Post
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/FeedBlog_war/posts/save">Create post</a>
                            <a class="dropdown-item" href="/FeedBlog_war/posts/deleteById">Delete by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/posts/deleteByTitle">Delete by title</a>
                            <a class="dropdown-item" href="/FeedBlog_war/posts/findAll">Find all</a>
                            <a class="dropdown-item" href="/FeedBlog_war/posts/findById">Find by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/posts/findByTitle">Find by title</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Category
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                            <a class="dropdown-item" href="/FeedBlog_war/categories/save">Save</a>
                            <a class="dropdown-item" href="/FeedBlog_war/categories/deleteById">Delete by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/categories/deleteByTitle">Delete by title</a>
                            <a class="dropdown-item" href="/FeedBlog_war/categories/findAll">Find all</a>
                            <a class="dropdown-item" href="/FeedBlog_war/categories/findById">Find by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/categories/findByTitle">Find by title</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Tag
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown3">
                            <a class="dropdown-item" href="/FeedBlog_war/tags/save">Save</a>
                            <a class="dropdown-item" href="/FeedBlog_war/tags/deleteById">Delete by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/tags/deleteByName">Delete by name</a>
                            <a class="dropdown-item" href="/FeedBlog_war/tags/findAll">Find all</a>
                            <a class="dropdown-item" href="/FeedBlog_war/tags/findById">Find by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/tags/findByName">Find by name</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            User
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                            <a class="dropdown-item" href="/FeedBlog_war/users/save">Save</a>
                            <a class="dropdown-item" href="/FeedBlog_war/users/deleteById">Delete by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/users/deleteByName">Delete by name</a>
                            <a class="dropdown-item" href="/FeedBlog_war/users/findAll">Find all</a>
                            <a class="dropdown-item" href="/FeedBlog_war/users/findById">Find by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/users/findByName">Find by name</a>
                            <a class="dropdown-item" href="/FeedBlog_war/users/updateByName">Update name</a>
                            <a class="dropdown-item" href="/FeedBlog_war/users/updateByEmail">Update email</a>
                            <a class="dropdown-item" href="/FeedBlog_war/users/updateByPassword">Update password</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown5" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Comment
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown5">
                            <a class="dropdown-item" href="/FeedBlog_war/comment/deleteById">Delete by id</a>
                            <a class="dropdown-item" href="/FeedBlog_war/comment/getAll">Get all</a>
                            <a class="dropdown-item" href="/FeedBlog_war/comment/getAllByPost">Get all by post</a>
                            <a class="dropdown-item" href="/FeedBlog_war/comment/getAllByUser">Get all by user</a>
                            <a class="dropdown-item" href="/FeedBlog_war/comment/getById">Get by id</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown6" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Moderator menu
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown6">
                            <a class="dropdown-item" href="/user/moderMenu">Unchecked list</a>
                        </div>
                    </li>

                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </c:if>
        </c:if>
    </div>
</nav>

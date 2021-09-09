<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">FeedBlog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello Guest</a>

            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Create post</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Account</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Log out</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Post
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/post/create">Create post</a>
                    <a class="dropdown-item" href="/post/deletePostById">Delete by id</a>
                    <a class="dropdown-item" href="/post/deletePostByTitle">Delete by title</a>
                    <a class="dropdown-item" href="/post/getAllPosts">Get all</a>
                    <a class="dropdown-item" href="/post/getPostById">Get by id</a>
                    <a class="dropdown-item" href="/post/getPostByTitle">Get by title</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Category
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <a class="dropdown-item" href="/category/save">Save</a>
                    <a class="dropdown-item" href="/category/deleteById">Delete by id</a>
                    <a class="dropdown-item" href="/category/deleteByTitle">Delete by title</a>
                    <a class="dropdown-item" href="/category/getAll">Get all</a>
                    <a class="dropdown-item" href="/category/getById">Get by id</a>
                    <a class="dropdown-item" href="/category/getByTitle">Get by title</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Tag
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown3">
                    <a class="dropdown-item" href="/tag/save">Save</a>
                    <a class="dropdown-item" href="/tag/deleteById">Delete by id</a>
                    <a class="dropdown-item" href="/tag/deleteByName">Delete by name</a>
                    <a class="dropdown-item" href="/tag/getAll">Get all</a>
                    <a class="dropdown-item" href="/tag/getById">Get by id</a>
                    <a class="dropdown-item" href="/tag/getByName">Get by name</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    User
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                    <a class="dropdown-item" href="/user/save">Save</a>
                    <a class="dropdown-item" href="/user/deleteById">Delete by id</a>
                    <a class="dropdown-item" href="/user/deleteByName">Delete by name</a>
                    <a class="dropdown-item" href="/user/getAll">Get all</a>
                    <a class="dropdown-item" href="/user/getById">Get by id</a>
                    <a class="dropdown-item" href="/user/getByName">Get by name</a>
                    <a class="dropdown-item" href="/user/updateName">Update name</a>
                    <a class="dropdown-item" href="/user/updatePassword">Update password</a>
                    <a class="dropdown-item" href="/user/updateAge">Update age</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown5" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Comment
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown5">
                    <a class="dropdown-item" href="/comment/deleteById">Delete by id</a>
                    <a class="dropdown-item" href="/comment/getAll">Get all</a>
                    <a class="dropdown-item" href="/comment/getAllByPost">Get all by post</a>
                    <a class="dropdown-item" href="/comment/getAllByUser">Get all by user</a>
                    <a class="dropdown-item" href="/comment/getById">Get by id</a>
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
    </div>
</nav>

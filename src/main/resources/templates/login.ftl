<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<br>
<div class="container">
    <form id="login" name="login" action="/login" method="post">
        <div class="form-group">
            <div class="input-icon">
                <i class="icon-user">
                </i>
                <input type="text" name="name" id="name" class="form-control" placeholder="帳號"
                       autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入帳號。"
                />
            </div>
        </div>
        <div class="form-group">
            <div class="input-icon">
                <i class="icon-lock">
                </i>
                <input type="password" name="password" id="password" class="form-control" placeholder="密碼"
                       data-rule-required="true" data-msg-required="請輸入密碼。"
                />
            </div>
        </div>
        <br>
        <div class="form-actions">
            <button type="button" class="submit btn btn-primary pull-right" onclick="location.href='/register'">
                註冊
                <i class="icon-angle-right">
                </i>
            </button>
            <form action="/login" method="post">
                <input class="btn btn-primary btn-block" type="submit" value="登入" onclick="return check();">
            </form>
        </div>
    </form>
    <script type="text/javascript">
        function check(){
            const name = document.getElementById("name").value;
            const password = document.getElementById("password").value;

            if (name == ""){
                alert("帳號不可空白");
                return false;
            }
            if (password == ""){
                alert("密碼不可空白");
                return false;
            }

            return true;
        }
    </script>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
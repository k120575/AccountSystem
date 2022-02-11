<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<br>
<div class="container">
    <form id="register" name="register" action="/register" method="post">
        <div class="login-wrap">

            <div class="input-group">
                <span class="input-group-addon"><i class="icon_profile"></i></span>
                <input type="text" name="name" id="name" class="form-control" placeholder="登入帳號"
                       autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲設定帳號"/>
            </div>

            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" name="password" id="password" class="form-control" placeholder="請輸入密碼"
                       data-rule-required="true" />
            </div>

            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" name="password2" id="password2" class="form-control" placeholder="請再次輸入密碼"
                       data-rule-required="true" />
            </div>

            <form action="/register" method="post">
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="註冊" >
            </form>
        </div>
    </form>
    <script type="text/javascript">
        function check(){
            var name = document.getElementsByName('name');
            var password = document.getElementById('password');
            var password2 = document.getElementById('password2');

            // if (name == ''){
            //     alert('名稱不可空白');
            // }
            // if (password == "" || password2 == ""){
            //     alert("密碼不可空白");
            // }
            // if (password !== password2){
            //     alert("兩次密碼不同");
            //     return false;
            // }
        }

    </script>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
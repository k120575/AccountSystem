<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Transfer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<br>
<div class="container">
    <form id="transfer" name="transfer" action="/transfer" method="post">
        <H5>轉出帳號</H5>
        <div class="input-group">
            <span class="input-group-addon"><i class="icon_profile"></i></span>
            <input type="text" name="transferFrom" id="transferFrom" class="form-control" placeholder="輸入轉出帳號"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲轉出帳號"/>
        </div>
        <br>
        <H5>轉入帳號</H5>
        <div class="input-group">
            <span class="input-group-addon"><i class="icon_profile"></i></span>
            <input type="text" name="transferTo" id="transferTo" class="form-control" placeholder="輸入轉入帳號"
            autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲轉入帳號"/>
        </div>
        <br>
        <H5>轉出金額</H5>
        <div class="input-group">
            <span class="input-group-addon"><i class="icon_profile"></i></span>
            <input type="text" name="credits" id="credits" class="form-control" placeholder="輸入金額"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲存入金額"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon"><i class="icon_profile"></i></span>
            <input type="text" name="comment" id="comment" class="form-control" placeholder="備註"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入備註"/>
        </div>
        <br>
        <form action="/transfer" method="post">
            <input class="btn btn-primary btn-lg btn-block" type="submit" value="轉帳" >
        </form>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
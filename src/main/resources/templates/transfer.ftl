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
        <div class="input-group">
            <span class="input-group-text">轉出帳號</span>
            <input type="text" name="transferFrom" id="transferFrom" class="form-control" placeholder="輸入轉出帳號"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲轉出帳號"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-text">轉入帳號</span>
            <input type="text" name="transferTo" id="transferTo" class="form-control" placeholder="輸入轉入帳號"
            autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲轉入帳號"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-text">轉出金額</span>
            <input type="text" name="credits" id="credits" class="form-control" placeholder="輸入轉出金額"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲轉出金額"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-text">備註</span>
            <input type="text" name="comment" id="comment" class="form-control" placeholder="備註"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入備註"/>
        </div>
        <br>
        <form action="/transfer" method="post">
            <input class="btn btn-primary btn-lg btn-block" type="submit" value="轉帳" onclick="return check();">
        </form>
    </form>
</div>
<script type="text/javascript">

    function check() {
        var transferFrom = document.getElementById("transferFrom").value;
        var transferTo = document.getElementById("transferTo").value;
        var credits = document.getElementById("credits").value;

        if (transferFrom == ""){
            alert("請輸入轉出帳號");
            return false;
        }
        if (transferTo == ""){
            alert("請輸入轉入帳號");
            return false;
        }
        if (credits == ""){
            alert("請輸入轉出金額");
            return false;
        }
        return true;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Income</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<br>
<H5>收入 Income</H5>
<br>
<div class="container">
    <form id="income" name="income" action="/income" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">收入金額</span>
            <input type="text" name="credits" id="credits" class="form-control" placeholder="輸入金額"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲存入金額"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-text">收入類型</span>
            <select class="form-select form-control" id="incomeType" name="incomeType">
                <option  value="" selected>請選擇</option>
                <option value="工資">工資</option>
                <option value="獎金">獎金</option>
                <option value="投資">投資</option>
                <option value="利息">利息</option>
                <option value="其他">其他</option>
            </select>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-text">備註</span>
            <input type="text" name="comment" id="comment" class="form-control" placeholder="備註"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入備註"/>
        </div>
        <br>
        <form action="/income" method="post">
            <input class="btn btn-primary btn-lg btn-block" type="submit" value="存入" onclick="return check();">
        </form>
    </form>
</div>
<script type="text/javascript">

    function check() {
        var credits = document.getElementById("credits").value;
        var incomeType = document.getElementById("incomeType").value;

        if (credits == ""){
            alert("請輸入金額");
            return false;
        } else if (incomeType == ""){
            alert("請選擇收入類型");
            return false;
        }
        return true;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expenditure</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<br>
<H5>支出 expenditure</H5>
<br>
<div class="container">
    <form id="expenditure" name="expenditure" action="/expenditure" method="post">
        <div class="input-group">
            <span class="input-group-text">支出金額</span>
            <input type="text" name="credits" id="credits" class="form-control" placeholder="輸入金額"
                   autofocus="autofocus" data-rule-required="true" data-msg-required="請輸入欲支出金額"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-text">支出類型</span>
            <select class="form-select" id="expenditureType" name="expenditureType" aria-label="Default select example">
                <option value="" selected>請選擇</option>
                <option value="飲食">飲食</option>
                <option value="居家">居家</option>
                <option value="交通">交通</option>
                <option value="電話網路">電話網路</option>
                <option value="信用卡">信用卡</option>
                <option value="運動">運動</option>
                <option value="學習">學習</option>
                <option value="服飾">服飾</option>
                <option value="娛樂">娛樂</option>
                <option value="醫療">醫療</option>
                <option value="保險">保險</option>
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
        <form action="/expenditure" method="post">
            <input class="btn btn-primary btn-lg btn-block" type="submit" value="支出" onclick="return check();">
        </form>
    </form>
</div>
<script type="text/javascript">

    function check() {
        var credits = document.getElementById("credits").value;
        var expenditureType = document.getElementById("expenditureType").value;

        if (credits == ""){
            alert("請輸入金額");
            return false;
        } else if (expenditureType == ""){
            alert("請選擇支出類型");
            return false;
        }
        return true;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
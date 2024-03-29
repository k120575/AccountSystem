<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<br>
<tr>
    <#if isLogin>
        <H5>HI ${user.name}</H5>
    <#else>
        <H5>HI</H5>
    </#if>
</tr>
    <div class="container">
        <div class="row g-2">
            <div class="col-6">
                <button type="button" class="btn btn-secondary p-3 border" onclick="location.href='/inquiry'">查詢 Inquiry</button>
            </div>
            <div class="col-6">
                <button type="button" class="btn btn-secondary p-3 border" onclick="location.href='/income'">收入 Income</button>
            </div>
            <div class="col-6">
                <button type="button" class="btn btn-secondary p-3 border" onclick="location.href='/expenditure'">支出 expenditure</button>
            </div>
            <div class="col-6">
                <button type="button" class="btn btn-secondary p-3 border" onclick="location.href='/transfer'">轉帳 Transfer</button>
            </div>
        </div>
    </div>
<br>
<div class="container">
    <div class="align-content-center">
        <button type="button" class="btn btn-warning p-3 border" onclick="location.href='/login'">登入或註冊</button>
        <#if isLogin>
            <button type="button" class="btn btn-warning p-3 border" onclick="location.href='/logout'">登出</button>
        </#if>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inquiry</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<br>
<div class="container">
    <table class="table table-striped table-hover" id="inquiry" name="inquiry" action="/inquiry" method="get">
        <thead>
            <tr class="table-dark">
                <th scope="col">Name</th>
                <th scope="col">balance</th>
                <th scope="col">Current Time</th>
            </tr>
        </thead>
        <tbody class="table-secondary">
            <tr>
                <td>${user.name}</td>
                <td>${balance}</td>
                <td>${currentTime}</td>
            </tr>
        </tbody>
    </table>
    <br>
    <table class="table table-striped table-hover" id="inquiry" name="inquiry" action="/inquiry" method="get">
        <thead>
        <tr class="table-secondary">
            <th scope="col">Date</th>
            <th scope="col">Action</th>
            <th scope="col">Balance</th>
        </tr>
        </thead>
        <tbody class="table-warning">
        <#if accountDetails ? has_content>
            <#list accountDetails as account>
                <tr>
                    <td>${account.createTime}</td>
                    <td>${account.action}</td>
                    <td>${account.balance}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
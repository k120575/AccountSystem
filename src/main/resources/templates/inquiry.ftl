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
                <th scope="col">Current balance</th>
                <th scope="col">Current Time</th>
            </tr>
        </thead>
        <tbody class="table-secondary">
            <tr>
                <td>${user.name}</td>
                <td>$${balance}</td>
                <td>${currentTime}</td>
            </tr>
        </tbody>
    </table>
    <br>
    <div class="container">
        <div class="row align-items-start">
            <div class="col-6">
                <form id="search" name="search" action="/search" method="post">
                    <div class="input-group input-group-sm justify-content-start">
                        <span class="input-group-text">開始日期</span>
                        <input type="date" class="date-picker" name="startDate" id="startDate">
                        &nbsp;
                        <span class="input-group-text">結束日期</span>
                        <input type="date" class="date-picker" name="endDate" id="endDate">
                        &nbsp;
                        <form action="/search" method="post">
                            <input class="btn btn-primary btn-sm btn-block" type="submit" value="搜尋" onclick="return check();">
                        </form>
                    </div>
                </form>
            </div>
            <div class="col"></div>
            <div class="col">
                <div class="col">
                    <div class="input-group input-group-sm justify-content-end">
                        <span class="input-group-text">每頁顯示幾筆</span>
                        <select class="form-select form-control" id="size" name="size" onchange="location = '/inquiry?page=1&size='+this.options[this.selectedIndex].value;">
                            <option value="5">5</option>
                            <option value="10" selected>10</option>
                            <option value="15">15</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-sm btn-primary" onclick="location.href='/index'">回首頁</button>
                </div>
            </div>
        </div>
    </div>
</div>
    <br>
<div class="container">
    <table class="table table-striped table-hover" id="inquiry" name="inquiry" action="/inquiry" method="get">
        <thead>
        <tr class="table-bordered">
            <th scope="col">Date</th>
            <th scope="col">Action</th>
            <th scope="col">Credits</th>
            <th scope="col">Balance</th>
            <th scope="col">Income Type</th>
            <th scope="col">Expenditure Type</th>
            <th scope="col">Transfer From</th>
            <th scope="col">Transfer To</th>
            <th scope="col">Comment</th>
        </tr>
        </thead>
        <tbody class="table-light">
        <#if accountDetails?? && (accountDetails?size >0)>
            <#list accountDetails as account>
                <tr>
                    <td>${account.createTime?datetime("yyyy-MM-dd'T'HH:mm:ss")?string("yyyy/MM/dd HH:mm:ss")}</td>
                    <td>${account.action}</td>
                    <td>$${account.credits}</td>
                    <td>$${account.balance}</td>
                    <#if account.incomeType??>
                        <td>${account.incomeType}</td>
                    <#else>
                        <td></td>
                    </#if>
                    <#if account.expenditureType??>
                        <td>${account.expenditureType}</td>
                    <#else>
                        <td></td>
                    </#if>
                    <#if account.transferFrom??>
                        <td>${account.transferFrom}</td>
                    <#else>
                        <td></td>
                    </#if>
                    <#if account.transferTo??>
                        <td>${account.transferTo}</td>
                    <#else>
                        <td></td>
                    </#if>
                    <#if account.comment??>
                        <td>${account.comment}</td>
                    <#else>
                        <td></td>
                    </#if>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</div>
<footer class="navbar-fixed-bottom">
    <div class="container">
        <div class="col-md-12 column d-flex justify-content-center">
            <ul class="pagination ">
                <#if currentPage lte 1>
                    <li class="disabled "><a class="page-link" href="#">上一頁</a></li>
                <#else>
                    <li>
                        <a class="page-link" href="/inquiry?page=${currentPage -
                        1}&size=${size}">上一頁</a>
                    </li>
                </#if>
                <#list 1..totalPage as index>
                    <#if currentPage == index>
                        <li class="page-item active "><a class="page-link" href="#">${index}</a>
                        </li>
                    <#else>
                        <li>
                            <a class="page-link" href="/inquiry?page=${index}&size=${size}">
                                ${index}</a>
                        </li>
                    </#if>
                </#list>
                <#if currentPage gte totalPage>
                    <li class="disabled "><a class="page-link" href="#">下一頁</a></li>
                <#else>
                    <li>
                        <a class="page-link" href="/inquiry?page=${currentPage + 1}&size=${size}">下一頁</a>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</footer>

<script type="text/javascript">

    function check() {
        var startDate = document.getElementById("startDate").value;
        var endDate = document.getElementById("endDate").value;

        if (startDate !== "" && endDate == ""){
            alert("請輸入結束時間");
            return false;
        } else if (startDate == "" && endDate !== ""){
            alert("請輸入開始時間");
            return false;
        }
        return true;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
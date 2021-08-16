<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
</head>
<body class="container">
    <hr/>
    <div>Money Transfer Service</div>
    <hr/>
    <hr/>

    <nav class="nav">
      <a class="nav-link" href="txr">Transfer</a>
      <a class="nav-link" href="statement">Statement</a>
      <a class="nav-link" href="accountlist">Account-List</a>
       <a class="nav-link" href="addaccount">New-Account</a>
      <a class="nav-link" href="logout">logout</a>
    </nav>


    <hr />
    Welcome : ${sessionScope.currentUser}
    <hr />


    <hr/>
        <a class="btn btn-lg btn-primary" href="accountlist?filter=all">All</a>&nbsp;
        <a class="btn btn-lg btn-primary" href="accountlist?filter=top10">Top 10</a>&nbsp;
    <hr/>


    <%
        List<Account> accounts=(List<Account>) request.getAttribute("accounts");
    %>

    <table class="table table-stripped">
        <thead>
        <tr>
            <td>Account Number</td>
            <td>Balance</td>
        </tr>
        </thead>
        <tbody>
        <%
            for(Account acc:accounts){
        %>
            <tr>
                <td><%=acc.getNumber()%></td>
                <td>&#8377;<%=acc.getBalance()%></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>


</body>
</html>
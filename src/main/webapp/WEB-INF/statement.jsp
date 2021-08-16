<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Txns" %>
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
        <a class="btn btn-lg btn-primary" href="statement?filter=all">All</a>&nbsp;
        <a class="btn btn-lg btn-primary" href="statement?filter=top10">Top 10</a>&nbsp;
        <a class="btn btn-lg btn-primary" href="statement?filter=debit">DEBIT</a>&nbsp;
        <a class="btn btn-lg btn-primary" href="statement?filter=credit">CREDIT</a>&nbsp;
    <hr/>

  
    <%
        List<Txns> txns=(List<Txns>) request.getAttribute("txns");
    %>

    <table class="table table-stripped">
        <thead>
        <tr>
            <td>S.No</td>
            <td>Amount</td>
            <td>Type</td>
            <td>Date</td>
            <td>Account</td>
        </tr>
        </thead>
        <tbody>
        <%
            for(Txns txn:txns){
        %>
            <tr>
                <td><%=txn.getId()%></td>
                <td>&#8377;<%=txn.getAmount()%></td>
                <td><%=txn.getType()%></td>
                <td><%=txn.getDate()%></td>
                <td><%=txn.getAccount().getNumber()%></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>


</body>
</html>
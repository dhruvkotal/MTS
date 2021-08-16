<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>

<body class="container">
  <hr />
  <div>Money Transfer Service</div>
  <hr />
  <hr />

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

  <div class="row">
    <div class="col-4"></div>
    <div class="col-4">
      <form action="addaccount" method="POST">
        <div class="card">
          <div class="card-header">Add Account Form</div>
          <div class="card-body">
            <div class="form-group">
              <label>Account Number</label>
              <input class="form-control" name="number" />
            </div>
            <div class="form-group">
              <label>Starting Balance</label>
              <input class="form-control" name="balance" />
            </div>
          </div>
          <div class="card-footer">
            <button class="btn btn-dark">Add Account</button>
          </div>
        </div>
      </form>
    </div>
  </div>

</body>

</html>
<%
int score = (Integer) request.getAttribute("score");
int total = (Integer) request.getAttribute("total");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>

<body>

    <h2>Quiz Completed!</h2>

    <p>Your Score: <%= score %> / <%= total %></p>

    <a href="index.jsp">Take Again</a>

</body>
</html>
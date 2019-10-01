<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Calculate</title>
</head>

<body>
<form action="Calculator" method="post">
    <input type="text" name="add1" size="2" value="${add1}" />+
    <input type="text" name="add2" value="${add2}" size="2" />=
    <input type="text" name="sum" value="${sum}" size="2" readonly /><br />
    <input type="text" name="mult1" value="${mult1}" size="2" />*
    <input type="text" name="mult2" value="${mult2}" size="2" />=
    <input type="text" name="product" value="${product}" size="2" readonly /><br />
    <input type="submit" value="Submit" />
</form>
</body>

</html>
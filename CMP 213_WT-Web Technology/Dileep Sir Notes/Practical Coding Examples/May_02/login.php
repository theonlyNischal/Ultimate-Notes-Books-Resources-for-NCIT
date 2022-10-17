<html>
    <head>
        <style>
            div{
                text-align:center;
                position:relative;
                top:30%;
            }
        </style>
    </head>
    <body>
        <div>
            <h4>Please provide your name and age to continue..</h4>
            <form method="POST" action="process.php">
                Name:<input type="text" name="username" required/>
                Age: <input type="text" name="userage" required/>
                <input type="submit" name="submit" value="Enter"/>
            </form>
        </div>
    </body>
</html>
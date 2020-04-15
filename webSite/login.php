<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form>
        <label for="fname">Username:</label><br>
        <input type="text" name="username"><br>
        <label for="lname">Password:</label><br>
        <input type="password" name="password">
        <input type="submit" value="submit">
    </form>
    <?php
        $db = new SQLite3('dayTriper.db');
        if (isset($_POST['username']) && isset($_POST['password'])) {
            $tripResults = $db->query('SELECT * FROM user WHERE username = '.$_POST['username'].' AND password = '.$_POST['password']);
            while ($row = $tripResults->fetchArray()) {
                echo $row['firstName'];
                echo $row['lastName'];
            }
        }
    ?>
</body>
</html>
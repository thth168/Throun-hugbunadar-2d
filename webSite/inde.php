<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        if ($db = @sqlite_open('DayTriper.db', 0666, $error))
            {
            echo 'Connected to the database.';
        } else {
            echo 'Connection failed: ' . htmlspecialchars
            ($error);
        }
        $results = $db->query('SELECT * FROM users');
        while ($row = $results->fetchArray()) {
            var_dump($row);
        }
    ?>
</body>
</html>
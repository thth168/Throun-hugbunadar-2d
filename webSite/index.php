<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Document</title>
</head>
<body>
    <?php
        $db = new SQLite3('dayTriper.db');
        $tripResults = $db->query('SELECT * FROM trips');
        echo "<div class='main__container'>";
        echo "<form>";
            echo "<label for='fname'>First name:</label><br>";
            echo "<input type='text' id='fname' name='fname'><br>";
            echo "<input type='submit' value='Submit'>";
        echo "</form>"; 
        while ($row = $tripResults->fetchArray()) {
            echo "<div class='main__trip'>";
                echo "<div class='main__trip_img'>";
                    echo "<img src='".$row['img']."' alt='image of the trip'>";
                echo "</div>";
                echo "<div class='main__trip_info'>";
                    echo "<h1>".$row['name']."</h1>";
                    $locResults = $db->query('SELECT name FROM location WHERE id = '.$row['location_id']);
                    $loc = $locResults->fetchArray();
                    echo "<p>Location: ".$loc[0]."</p>";
                    echo "<p>Date: ".$row['date']."<p>";
                    echo "<p>Tags: ".$row['tags']."</p>";
                    $userResults = $db->query('SELECT firstName FROM users WHERE id = '.$row['agency']);
                    $user = $userResults->fetchArray();
                    echo "<p>Agency: ".$user[0]."</p>";
                    echo "<p>Price: ".$row['price']."</p>";
                echo "</div>";
            echo "</div>";
        }
        echo "</div>";
    ?>
</body>
</html>
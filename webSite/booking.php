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
        $test = $_SERVER['REQUEST_URI'];
        $test = explode('?', $test)[1];
        $test = urldecode($test);
        echo $test;

        $db = new SQLite3('dayTriper.db');
        $tripResults = $db->query('SELECT * FROM trips');
        While ($revTrip = $tripResults->fetchArray()) {
            if ($test == $revTrip['name']) {
                $reviewId = $revTrip['id'];
            }
        }
        echo "<h1>Consumer View</h1>";
        echo "<div class='reviews__container'>";
            $revResults = $db->query('SELECT * FROM reviews WHERE trip_id = '.$reviewId);
            while ($revRun = $revResults->fetchArray()) {
                $writer = $revRun['writer_id'];
                $writerResults = $db->query('SELECT firstName, lastName FROM users WHERE id = '.$writer);
                echo "<div class'reviews'>";
                    while ($writerRun = $writerResults->fetchArray()) {
                        echo "<p>".$writerRun['firstName']." ".$writerRun['lastName']."</p>";
                    }
                    echo "<p>Review: ".$revRun['reviewText']."</p>";
                    echo "<p>Stars: ".$revRun['Stars']."</p>";
                echo "</div>";
            }
        echo "</div>";
        echo "<h1>Agency View</h1>";
    ?>
</body>
</html>
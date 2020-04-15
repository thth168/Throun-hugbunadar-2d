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
        echo "<div>";
            echo "<form action='' method='post'>";
                echo "<label for='fname'>Search:</label><br>";
                echo "<input type='text' name='search'><br>";
                $loc1Results = $db->query('SELECT * FROM location');
                echo "<br>";
                echo "<select name='locations'>";
                    echo "<option value='all'>Select all</option>";
                    while ($row1 = $loc1Results->fetchArray()) {
                        echo "<option value='".$row1['id']."'>".$row1['name']."</option>";
                    }
                echo "</select>";
                if (isset($_POST['locations'])) {
                    $selected_val = $_POST['locations'];  // Storing Selected Value In Variable
                }
                if (isset($_POST['search'])) {
                    $search = $_POST['search'];
                }
                echo "<input type='submit' value='Submit'>";
            echo "</form>";
        echo "</div>";
        echo "<div>";
            if (isset($_POST['locations'])) {
                if (!($selected_val = "all")) {
                    $loc1Results = $db->query('SELECT * FROM location WHERE id ='.$selected_val);
                    $loc1 = $loc1Results->fetchArray();
                    echo "<h1>".$loc1[1]."</h1>";
                }
            } else {
                echo "<h1>All Search</h1>";
            }
        echo "</div>";
        echo "<div class='trip__container'>";
            if (!(isset($_POST['locations']))) {
                while ($row = $tripResults->fetchArray()) {        
                    echo "<div class='main__trip'>";
                        echo "<div class='main__trip_img'>";
                            echo "<img src='".$row['img']."' alt='image of the trip'>";
                        echo "</div>";
                        echo "<div class='main__trip_info'>";
                            echo "<h1>".$row['name']."</h1>";
                            $seatResults = $db->query('SELECT count(id) FROM location WHERE id = '.$row['id']);
                            $takenSeats = $seatResults->fetchArray()[0];
                            if ($row['seats'] == $takenSeats) {
                                echo "<h2 >Seat Availible: FULL</h2>";
                            } else {
                                $aviSeats = $row['seats'] - $takenSeats;
                                echo "<h2>Seat Availible: ".$aviSeats."</h2>";
                            }
                            $loc2Results = $db->query('SELECT id, name FROM location WHERE id = '.$row['location_id']);
                            $loc = $loc2Results->fetchArray();
                            echo "<p>Location: ".$loc[1]."</p>";
                            echo "<p>Date: ".$row['date']."</p>";
                            echo "<p>Tags: ".$row['tags']."</p>";
                            $userResults = $db->query('SELECT firstName FROM users WHERE id = '.$row['agency']);
                            $user = $userResults->fetchArray();
                            echo "<p>Agency: ".$user[0]."</p>";
                            echo "<p>Price: ".$row['price']." kr</p>";
                            $revResults = $db->query('SELECT trip_id, Stars FROM reviews WHERE trip_id = '.$row['id']);
                            $amount = 0;
                            $sum = 0;
                            while ($revRun = $revResults->fetchArray()) {
                                $sum += $revRun['Stars'];
                                $amount += 1;
                            }
                            if ($amount != 0) {
                                echo "<p>Stars: ".$sum/$amount."</p>";
                            } else {
                                echo "<p>Not rated</p>";
                            }
                            echo "<a href='reviews.php?".$row['name']."'>Reviews</a>";
                            echo "<a href='booking.php?".$row['name']."'>Booking</a>";
                        echo "</div>";
                    echo "</div>";
                }
            }
        echo "</div>";
        echo "<div class='trip__container'>";
            if (isset($_POST['locations'])) {
                if (isset($_POST['search'])) {
                    if ($_POST['locations'] == "all") {
                        $tripResults = $db->query("SELECT * FROM trips WHERE name LIKE '%".$search."%'");
                        echo "</div>";
                        echo "<div class='trip__container'>";
                            while ($row = $tripResults->fetchArray()) {        
                                echo "<div class='main__trip'>";
                                    echo "<div class='main__trip_img'>";
                                        echo "<img src='".$row['img']."' alt='image of the trip'>";
                                    echo "</div>";
                                    echo "<div class='main__trip_info'>";
                                        echo "<h1>".$row['name']."</h1>";
                                        $seatResults = $db->query('SELECT count(id) FROM location WHERE id = '.$row['id']);
                                        $takenSeats = $seatResults->fetchArray()[0];
                                        if ($row['seats'] == $takenSeats) {
                                            echo "<h2 >Seat Availible: FULL</h2>";
                                        } else {
                                            $aviSeats = $row['seats'] - $takenSeats;
                                            echo "<h2>Seat Availible: ".$aviSeats."</h2>";
                                        }
                                        $loc2Results = $db->query('SELECT id, name FROM location WHERE id = '.$row['location_id']);
                                        $loc = $loc2Results->fetchArray();
                                        echo "<p>Location: ".$loc[1]."</p>";
                                        echo "<p>Date: ".$row['date']."</p>";
                                        $ttResults = $db->query('SELECT name FROM tripTypes WHERE id = '.$row['tripType_id']);
                                        echo "<p>Type: ".$ttResults->fetchArray()[0]."</p>";

                                        $userResults = $db->query('SELECT firstName FROM users WHERE id = '.$row['agency']);
                                        $user = $userResults->fetchArray();
                                        echo "<p>Agency: ".$user[0]."</p>";
                                        echo "<p>Price: ".$row['price']." kr</p>";
                                        $revResults = $db->query('SELECT trip_id, Stars FROM reviews WHERE trip_id = '.$row['id']);
                                        $amount = 0;
                                        $sum = 0;
                                        while ($revRun2 = $revResults->fetchArray()) {
                                            $sum += $revRun2['Stars'];
                                            $amount += 1;
                                        }
                                        if ($amount != 0) {
                                            echo "<p>Stars: ".$sum/$amount." | Reviews: ".$amount."</p>";
                                        } else {
                                            echo "<p>Not rated</p>";
                                        }
                                        echo "<a href='reviews.php?".$row['name']."'>Reviews</a>";
                                        echo "<a href='booking.php?".$row['name']."'>Booking</a>";
                                    echo "</div>";
                                echo "</div>";
                            }
                    } else {
                        $selected_val = $_POST['locations'];
                        $tripResults = $db->query("SELECT * FROM trips WHERE location_id = ".$selected_val." AND name LIKE '%".$search."%'");
                        while ($row = $tripResults->fetchArray()) {
                            echo "<div class='main__trip'>";
                                echo "<div class='main__trip_img'>";
                                    echo "<img src='".$row['img']."' alt='image of the trip'>";
                                echo "</div>";
                                echo "<div class='main__trip_info'>";
                                    echo "<h1>".$row['name']."</h1>";
                                    $seatResults = $db->query('SELECT count(id) FROM location WHERE id = '.$row['id']);
                                    $takenSeats = $seatResults->fetchArray()[0];
                                    if ($row['seats'] == $takenSeats) {
                                        echo "<h2 >Seat Availible: FULL</h2>";
                                    } else {
                                        $aviSeats = $row['seats'] - $takenSeats;
                                        echo "<h2>Seat Availible: ".$aviSeats."</h2>";
                                    }
                                    $loc2Results = $db->query('SELECT id, name FROM location WHERE id = '.$row['location_id']);
                                    $loc = $loc2Results->fetchArray();
                                    echo "<p>Location: ".$loc[1]."</p>";
                                    echo "<p>Date: ".$row['date']."</p>";
                                    if ($row['tags'] == null) {
                                        echo "<p>Tags: Add more tags</p>";
                                    } else {
                                        echo "<p>Tags: ".$row['tags']."</p>";
                                    }
                                    $userResults = $db->query('SELECT firstName FROM users WHERE id = '.$row['agency']);
                                    $user = $userResults->fetchArray();
                                    echo "<p>Agency: ".$user[0]."</p>";
                                    echo "<p>Price: ".$row['price']." kr</p>";
                                    $revResults = $db->query('SELECT trip_id, Stars FROM reviews WHERE trip_id = '.$row['id']);
                                    $amount = 0;
                                    $sum = 0;
                                    while ($revRun = $revResults->fetchArray()) {
                                        $sum += $revRun['Stars'];
                                        $amount += 1;
                                    }
                                    if ($amount != 0) {
                                        echo "<p>Stars: ".$sum/$amount."</p>";
                                    } else {
                                        echo "<p>Not rated</p>";
                                    }
                                    echo "<a href='reviews.php?".$row['name']."'>Reviews</a>";
                                    echo "<a href='booking.php?".$row['name']."'>Booking</a>";
                                echo "</div>";
                            echo "</div>";
                        }
                    }
                }
            }
            echo "</div>";
        echo "</div>";
    ?>
</body>
</html>
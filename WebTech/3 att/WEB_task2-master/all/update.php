<?php
require_once 'config/connect.php';

$id = $_GET['id'];
$concert = mysqli_query($connect, "SELECT * FROM `concerts` WHERE `id` = '$id'");
$concert = mysqli_fetch_assoc($concert);
?>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Изменить концерт</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
    <main>
        <div class="content">
            <div class="adder">
                <h3>Изменить концерт</h3>
                <form class="st" action="vendor/update.php" method="post">
                    <input type="hidden" name="id" value="<?= $concert['id'] ?>">
                    <p>Название концерта</p>
                    <input type="text" name="title" value="<?= $concert['title'] ?>">
                    <p>Место проведения</p>
                    <input type="text" name="place" value="<?= $concert['place'] ?>">
                    <p>Дата</p>
                    <input type="date" name="date" value="<?= $concert['date'] ?>">
                    <button class="push" type="submit">Изменить концерт</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>

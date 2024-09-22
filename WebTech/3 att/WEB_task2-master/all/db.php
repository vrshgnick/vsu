<?php

require_once 'config/connect.php';

?>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Концерты</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
    <main>
        <div>
            <h2>
                <a href="index.html" class="button">Главная</a>
            </h2>
        </div>
        <table class="table">
            <tr class="hat">
                <th>ID</th>
                <th>Название концерта</th>
                <th>Место проведения</th>
                <th>Дата</th>
                <th></th>
                <th></th>
            </tr>

            <?php
                $concerts = mysqli_query($connect, "SELECT * FROM `concerts`");
                $concerts = mysqli_fetch_all($concerts);
                foreach ($concerts as $concert){
                    ?>
                        <tr class="list">
                            <td><?= $concert[0] ?></td>
                            <td><?= $concert[1] ?></td>
                            <td><?= $concert[2] ?></td>
                            <td><?= $concert[3] ?></td>
                            <td><a class="edit-button" href="update.php?id=<?= $concert[0] ?>">Изменить</a></td>
                            <td><a class="delete-button" href="/WEB_task2-master/all/vendor/delete.php?id=<?= $concert[0] ?>">Удалить</a></td>
                        </tr>
                    <?php
                }
            ?>
        </table>

        <div class="adder">
            <h3>Добавьте концерт</h3>
            <form class="st" action="/WEB_task2-master/all/vendor/create.php" method="post">
                <p>Название концерта</p>
                <input type="text" name="title">
                <p>Место проведения</p>
                <input type="text" name="place">
                <p>Дата</p>
                <input type="date" name="date">
                <button class="push" type="submit">Добавить </button>
            </form>
        </div>
    </main>
</body>
</html>

<?php
require_once '../config/connect.php';

$id = $_POST['id'];
$title = $_POST['title'];
$place = $_POST['place'];
$date = $_POST['date'];

mysqli_query($connect, "UPDATE `concerts` SET `title` = '$title', `place` = '$place', `date` = '$date' WHERE `id` = '$id'");

header('Location: /WEB_task2-master/all/db.php');
exit();
?>

<?php
require_once '../config/connect.php';

$title = $_POST['title'];
$place = $_POST['place'];
$date = $_POST['date'];

mysqli_query($connect, "INSERT INTO `concerts` (`id`, `title`, `place`, `date`) VALUES (NULL, '$title', '$place', '$date')");

header('Location: /WEB_task2-master/all/db.php');
exit();
?>

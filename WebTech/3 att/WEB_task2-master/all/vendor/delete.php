<?php
require_once '../config/connect.php';

$id = $_GET['id'];

mysqli_query($connect, "DELETE FROM `concerts` WHERE `id` = '$id'");

header('Location: /WEB_task2-master/all/db.php');
exit();
?>

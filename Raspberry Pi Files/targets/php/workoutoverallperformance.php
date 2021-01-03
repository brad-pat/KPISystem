<?php
$dowhat = $_POST['dowhat'];
$kpiname = $_POST['kpiname'];
$timescale = $_POST['timescale'];
$user = $_POST['user'];

echo shell_exec("sudo python3 /var/www/html/targets/python/workoutoverallperformance.py $dowhat $kpiname $timescale $user");

?>

<?php
$kpiname = $_POST['kpiname'];
$timescale = $_POST['timescale'];
$user = $_POST['user'];

echo shell_exec("sudo python3 /var/www/html/targets/python/gettarget.py $kpiname $timescale $user");
?>

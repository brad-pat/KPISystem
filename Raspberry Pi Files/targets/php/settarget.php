<?php
$kpiname = $_POST['kpiname'];
$timescale = $_POST['timescale'];
$target = $_POST['target'];
$user = $_POST['user'];

echo shell_exec("sudo python3 /var/www/html/targets/python/settarget.py $kpiname $timescale $target $user");
?>

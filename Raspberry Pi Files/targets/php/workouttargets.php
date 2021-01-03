<?php
$kpiname = $_POST['kpiname'];
$target = $_POST['target'];
$timescale = $_POST['timescale'];

echo shell_exec("sudo python3 /var/www/html/targets/python/workouttargets.py $kpiname $target $timescale");
?>

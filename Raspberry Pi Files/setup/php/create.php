<?php
$general = $_POST['general'];
$users = $_POST['users'];
$kpis = $_POST['kpis'];
$other = $_POST['other'];

echo shell_exec("sudo python3 /var/www/html/setup/python/create.py $general $users $kpis $other");
?>

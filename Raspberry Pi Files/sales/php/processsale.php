<?php
$kpi = $_POST['kpi'];
$subkpi = $_POST['subkpi'];
$sale = $_POST['sale'];
$user = $_POST['user'];

echo shell_exec("sudo python3 /var/www/html/sales/python/processsale.py $kpi $subkpi $sale $user");
?>

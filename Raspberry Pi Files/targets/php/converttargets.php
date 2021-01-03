<?php
$from = $_POST['from'];
$to = $_POST['to'];
$target = $_POST['target'];

echo shell_exec("sudo python3 /var/www/html/targets/python/converttarget.py $from $to $target");
?>

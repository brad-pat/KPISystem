<?php
$userid = $_POST['userid'];
echo shell_exec("sudo python3 /var/www/html/users/python/deleteuser.py $userid");
?>


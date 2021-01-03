<?php
$user = $_POST['userdetails'];

echo shell_exec("sudo python3 /var/www/html/users/python/edituser.py $user");
?>

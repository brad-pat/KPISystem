<?php
$company_name = $_POST['company_name'];
$email = $_POST['email'];

echo shell_exec("sudo python3 /var/www/html/users/python/checkuser.py $email $company_name");
?>

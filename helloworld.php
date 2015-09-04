#!/usr/bin/php
<?php
$url = 'https://www.wosign.com/index.htm';
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, $url);
curl_setopt($curl, CURLOPT_HEADER, 1);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
$data = curl_exec($curl);
curl_close($curl);
var_dump($data);
var_dump(curl_error($curl));
?>
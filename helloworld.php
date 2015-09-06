#!/usr/bin/php
<?php
$url = 'https://www.wosign.com/index.htm';
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, $url);
curl_setopt($curl, CURLOPT_HEADER, 1);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, true);
$data = curl_exec($curl);
if($data == false)
{
  echo 'curl error: ' . curl_error($curl);
}
else
{
  var_dump($data);
}
curl_close($curl);
?>

import urllib
try:
  content = urllib.urlopen('https://blairstorage.blob.core.chinacloudapi.cn/transfer/azurelogo.png')
  print content.info()
  print content.read()
except Exception,ex:
  print Exception,":",ex
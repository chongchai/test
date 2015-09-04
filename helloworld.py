import urllib
try:
  content = urllib.urlopen('https://www.wosign.com/index.htm')
  print content.info()
  print content.read()
except Exception,ex:
  print Exception,":",ex
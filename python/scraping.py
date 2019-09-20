from bs4 import BeautifulSoup
from urllib.request import urlopen

path = 'C:/leetcode/python/LeetCode3.html'

htmlfile = open(path, 'r', encoding='utf-8').read()

# if has Chinese, apply decode()
#html = urlopen("C:/leetcode/python/LeetCode.html").read().decode('utf-8')
f = open("README.md", "a", encoding='utf-8')

soup = BeautifulSoup(htmlfile, features='lxml')
table = soup.find('table', {"class": "table table-striped"})
rows = table.find_all('tr')
for r in rows:
	data = r.find_all('td', {"label": "[object Object]"})
	for td in data:
		if td.get_text() == None or td.get_text() == "":
			continue
		a = td.find('a', href=True)
		if a != None:
			f.write('|[' + td.get_text() + ']')
			f.write('('+a['href']+')')
		else:
			f.write('|' + td.get_text())
	f.write('|\n')
f.close()
from bs4 import BeautifulSoup
from urllib.request import urlopen

path = 'C:/leetcode/python/LeetCode.html'

htmlfile = open(path, 'r', encoding='utf-8').read()

f = open("README.md", "w", encoding='utf-8')

soup = BeautifulSoup(htmlfile, features='lxml')
table = soup.find('table', {"class": "table table-striped"})
rows = table.find_all('tr')
for r in rows:
	data = r.find_all('td', {"label": "[object Object]"})
	name = ""
	for td in data:
		a = td.find('a', href=True)
		if td.get_text() == "" and a == None and name != "":
			f.write('||[Java]')
			f.write('(./Algorithms/' + name + '.java)')
			name = ""
			continue
		elif td.get_text() == "" and a == None and name == "":
			continue
		elif a != None and td.get_text() != "":
			f.write('|[' + td.get_text().strip() + ']')
			f.write('('+a['href']+')')
			name = td.get_text().replace(" ", "").strip()
		elif a != None and td.get_text() == "":
			f.write('|[Solution]')
			f.write('('+a['href']+')')
			f.write('|[Java]')
			f.write('(./Algorithms/' + name + '.java)')
		else:
			f.write('|' + td.get_text())
			if td.get_text() == "Easy" or td.get_text() == "Medium" or td.get_text() == "Hard": break
	f.write('|\n')
f.close()
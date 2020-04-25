from bs4 import BeautifulSoup
from urllib.request import urlopen

path = 'E:/leetcode/python/LeetCode2.html'

htmlfile = open(path, 'r', encoding='utf-8').read()

f = open("README.md", "w", encoding='utf-8')

easy = 0
medium = 0
hard = 0
soup = BeautifulSoup(htmlfile, features='lxml')
table = soup.find('table', {"class": "table table-striped"})
rows = table.find_all('tr')
for r in rows:
	data = r.find_all('td', {"label": "[object Object]"})
	name = ""
	number = ""
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
			name = number + '.%20' + td.get_text().replace(" ", "%20").strip()
		elif a != None and td.get_text() == "":
			f.write('|[Solution]')
			f.write('('+a['href']+')')
			f.write('|[Java]')
			f.write('(./Algorithms/' + name + '.java)')
		else:
			f.write('|' + td.get_text())
			if td.get_text().isdigit(): number = td.get_text()
			if td.get_text() == "Easy": easy += 1
			if td.get_text() == "Medium": medium += 1
			if td.get_text() == "Hard": hard += 1
			if td.get_text() == "Easy" or td.get_text() == "Medium" or td.get_text() == "Hard": break
	f.write('|\n')

f.write('Easy:' + str(easy) + ' Medium: ' + str(medium) + ' Hard: ' + str(hard))
f.close()
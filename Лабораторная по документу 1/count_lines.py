import sys, string
from sys import argv

if len(argv)>1:
	for i in range(1, len(argv)):
		countLines = 0
		f=open(argv[i],"r")

		line = f.readline()

		while line:
			countLines += 1
 	  		line = f.readline()
	
		f.close
		print("Lines count in file "+argv[i]+" --- "+str(countLines))
else:
	print("incorrect arguments")

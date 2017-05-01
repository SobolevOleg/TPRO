import sys, string
from sys import argv

if len(argv)==3:
	f=open(argv[1],"r")
	f1=open(argv[2],"w")

	line = f.readline()

	while line:
		line = line.upper()
   		f1.write(line)
   		line = f.readline()

	print("Done")
	f.close
	f1.close
else:
	print("incorrect arguments count")
import cmath,sys
from sys import argv

if len(argv)==4:#there is one more invisible arg - self
	try:
		a = float(argv[1])
		b = float(argv[2])
		c = float(argv[3])
 
		if (a and b and c) <> 0:
			discr = b**2 - 4 * a * c
			print("Quadratic equation: " + str(a) + "*x^2+" + str(b) + "*x+" + str(c))
			if discr > 0:
				x1 = (-b + cmath.sqrt(discr)) / (2 * a)
				x2 = (-b - cmath.sqrt(discr)) / (2 * a)
				print("Solution 1: %.2f+%.2fi" % (x1.real, x1.imag))
				print("Solution 2: %.2f+%.2fi" % (x2.real, x2.imag))
			elif discr == 0:
				x = -b / (2 * a)
				print("Solution: %.2f+%.2fi" % (x.real, x.imag))
			else:
				print("There is no solutions")
		elif ((a or c) and (b or c)) == 0:
			print("Solution: 0")
		elif (a or b) == 0:
			print("There is no solutions")
		elif a == 0:
			x = -c/b
			print("Solution: %.2f+%.2fi" % (x.real, x.imag))
		elif b == 0:
			x = cmath.sqrt(-c/a)
			print("Solution: %.2f+%.2fi" % (x.real, x.imag))
		elif c == 0:
			x = -b/a
			print("Solution: %.2f+%.2fi" % (x.real, x.imag))
	except ValueError:
		print("incorrect number is inputed")
elif len(argv)>4:
	print("too much arguments")
else:
	print("some arguments are messing")
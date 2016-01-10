"""
Supposeyou're managing a consulting team of expert computer hackers, and each week
you have to choose a job for them to undertake. Now, as you can well imagine,
the set of possible jobs is divided into those that are low-stress (e.g.,
setting up a Web site for a class at the local elementary school) and those that
are high-stress (eg: protecting the nation's most valuable secrets, or helping
a desperate group of Cornell students finish a project that has something to do
with compilers). 


Givensetsofvaluesl1,l2,...,ln andh1,h2,...,hn,find a plan of maximum
value. (Such a plan will be called optimal.)  

"""

__author__ = 'Rahul Ravindran'

def movingJobs(l,h):
	"""
	printint out the maximum value as of now. 
	To Do: print solution moves by backtracking
	"""

	matrixL = [0 for x in range(len(l))]
	matrixH = [0 for x in range(len(h))]

	matrixL[0] = l[0]
	matrixH[0] = h[0]

	for i in range(1,len(l)):
		matrixL[i] = max(matrixL[i-1]+l[i],l[i]+matrixH[i-1])
		matrixH[i] = max(h[i]+matrixL[i-2], h[i]+matrixH[i-2])

	print max(matrixH[-1],matrixL[-1])



if __name__ == '__main__':
	l = [10,1,10,10]
	h = [5,50,5,1]

	movingJobs(l,h)


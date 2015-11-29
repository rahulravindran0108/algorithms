"""

A clique in a graph is set of nodes such that there is an edge between any
two distinct nodes in the set. It is well known that finding the largest
clique in a graph is a computationally tough problem and no polynomial time
algorithm exists for it. However, you wonder what is the minimum size of the
largest clique in any graph with N nodes and M edges. Input Format The first
line contains T the number of test cases. Each of the next T lines contain 2
integers : N, M 

"""

__author__ = 'Rahul Ravindran'

def turan(n,r):
	"""
	Turan's theorem gives us an upper bound on the number of edges a graph can have if we wish that it should not have a clique of size x
	"""
	return 0.5 * (n ** 2 - (n % r) * (n / r + 1) ** 2 - (r - (n % r)) * (n / r) ** 2)

def solveClique(n,m):
	lowerLimit = 0
	higherLimit = n
	while lowerLimit + 1 < higherLimit:
		mid = (lowerLimit+higherLimit) / 2
		turanEdge = turan(n,mid)

		if turanEdge < m:
			lowerLimit = mid
		else:
			higherLimit = mid

	return higherLimit

if __name__ == '__main__':
	testcases = int(raw_input())
	for i in range(testcases):
		n,m = map(int,raw_input().strip().split(' '))
		print solveClique(n,m)

"""
Cutting Board Problem Hacker Rank
"""

__author__ = 'Rahul Ravindran'

modulus = 10 ** 9 + 7

class Cost(object):
    def __init__(self):
        self.cost = 0

    def __iadd__(self, other):
        self.cost = (self.cost + other % modulus) % modulus
        return self

def cuttingBoard(M,N,x,y):
	cost = Cost()
	x = sorted(x)
	y = sorted(y)

	while x and y:
		xMax = x[-1]
		yMax = y[-1]

		if xMax > yMax:
			cost+=x.pop() * (M-len(y))
		elif yMax > xMax:
			cost+=y.pop() * (N-len(x))
		else:
			if sum(x) > sum(y):
				cost+=x.pop()*(M-len(y))
			else:
				cost+=y.pop() * (N-len(x))

	while x:
		cost+=x.pop() * (M-len(y))
	while y:
		cost+=y.pop() * (N-len(x))

	return cost.cost
if __name__ == '__main__':
	testcases = int(raw_input())
	results = []

	for i in range(testcases):
		M,N = map(int,raw_input().strip().split(' '))
		y = map(int, raw_input().strip().split(' '))
		x = map(int, raw_input().strip().split(' '))
		results.append(cuttingBoard(M,N,x,y))

	for i in results:
		print i
""" 
given an array of positive integers, find indices such that i<j such that
A[j]/A[i] is maximised. 
"""

__author__ = 'Rahul Ravindran'

def maxInList(x):
	minElement = [0 for y in range(len(x))]
	minElement[0] = x[0]
	matrix = [1 for y in range(len(x))]
	
	for i in range(1,len(x)):
		minElement[i] = min(minElement[i-1],x[i-1])
		matrix[i] = max(matrix[i-1], x[i]/minElement[i])

	print matrix[-1]

if __name__ == '__main__':
	x = map(int, raw_input().strip().split(' '))
	
	maxInList(x)

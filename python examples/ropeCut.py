""" 
Rope Cutting Problem

Given a rod of length n inches and an array of prices that contains prices of
all pieces of size smaller than n. Determine the maximum value obtainable by
cutting up the rod and selling the pieces. For example, if length of the rod
is 8 and the values of different pieces are given as following, then the
maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
"""

__author__ = 'Rahul Ravindran'

def ropeCut(n):
	"""
	build the solution bottom up
	"""
	matrix = [0 for x in range(n+1)]
	matrix[1] = 1
	matrix[2] = 1
	#there are four possible cuts

	for i in range(2,len(matrix)):
		for j in range(1,i-1):
			matrix[i] = max(matrix[j]*matrix[i-j], j*matrix[i-j],
				matrix[j]*(i-j),j*(i-j)
				)
	print matrix[-1]


if __name__ == '__main__':
	lengthOfRope = int(raw_input())
	ropeCut(lengthOfRope)

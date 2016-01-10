""" 
Two Array Problem You are given two integer arrays, A and B, each containing
N integers. The size of the array is less than or equal to 1000. You are free to
permute the order of the elements in the arrays.

Now here's the real question: Is there an permutation A', B' possible of A and
B, such that, A'i+B'i >= K for all i, where A'i denotes the ith element in the
array A' and B'i denotes ith element in the array B'. 
"""


__author__ = 'Rahul Ravindran'

def twoArrays(A,B, k):
	A = sorted(A)
	B = sorted(B, reverse = True)

	for i in range(len(A)):
		if not A[i]+B[i] >= k:
			return "NO"
	return "YES"

if __name__ == '__main__':
	testcases = int(raw_input().strip())
	results = []
	for i in range(testcases):
		n, k = map(int, raw_input().strip().split(' '))
		A = map(int,raw_input().strip().split(' '))
		B = map(int,raw_input().strip().split(' '))
		results.append(twoArrays(A,B,k))

	for x in results:
		print x
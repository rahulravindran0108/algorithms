"""
Max Min Problem
"""

__author__ = 'Rahul Ravindran'

def maxMin(inputs, k):

	inputs = sorted(inputs)
	minUnfairness = max(inputs)
	for i in range(len(inputs)-k):
		minUnfairness = min(minUnfairness, inputs[i+k-1]-inputs[i])
	print minUnfairness
	

if __name__ == '__main__':
	n = int(raw_input())
	k = int(raw_input())
	input = []
	for i in range(n):
		input.append(int(raw_input()))
	maxMin(input,k)
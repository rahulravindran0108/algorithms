"""
continous subsequence problem such that sum of elements is maximised
"""

__author__ = 'Rahul Ravindran'


def continousSubsequence(inputs):
	"""
	technique is simple i.e either start the sequence at i or use opt(i-1)
	this method returns back the number to start the sequence from and the end index
	"""
	matrix = [0 for x in range(len(inputs))]

	matrix[0] = inputs[0]
	sums = 0

	for i in range(1,len(inputs)):
		matrix[i] = max(matrix[i-1],inputs[i])
		if matrix[i] == matrix[i-1]:
			sums = max(sums, sums+inputs[i])
			if sums +inputs[i] < sums:
				j = i
		else:
			sums = inputs[i]

	print matrix[-1], j



if __name__ == '__main__':
	inputs = [1,2,-9,9,2,100,-10,4]
	continousSubsequence(inputs)
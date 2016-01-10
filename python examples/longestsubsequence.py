def longestsubsequence(array):

	matrix = [1 for x in range(len(array))]
	maxValue = 1

	for i in range(len(array)):
		for j in range(i):
			if array[i] > array[j]:
				matrix[i] = max(matrix[i], matrix[j]+1)
		maxValue = max(maxValue, matrix[i])

	print maxValue

testcases = int(raw_input())
input = []
for i in range(testcases):
	input.append(int(raw_input()))

longestsubsequence(input)

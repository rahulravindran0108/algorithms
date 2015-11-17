def knapsack(w, sums):
	matrix = [[0 for x in range(sums+1)] for y in range(len(w)+1)]

	for i in range(len(w)+1):
		for j in range(sums+1):
			matrix[i][j] = matrix[i-1][j]
			temp = j - w[i-1]
			if temp >= 0:
				matrix[i][j] = max(matrix[i-1][j], matrix[i-1][j-w[i-1]]+w[i-1],matrix[i][j-w[i-1]]+w[i-1])

	print matrix[len(w)][sums]

if __name__ == '__main__':
	number_of_inputs = (int) raw_input()
	for i in range(number_of_inputs):
		n = (int) raw_input()
		sums = (int) raw_input()
		w = []
		for i in range(n):
			w.append((int) raw_input())
		knapsack(w,sums)
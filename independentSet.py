"""
Independent subset over a simple path
Input is a simple path thus for any vi,vj where j > i there exists an edge between vi and vj
"""

__author__ = 'Rahul Ravindran'

def independentSubset(inputs):
	matrix = [0 for i in range(len(inputs))]

	matrix[0] = inputs[0]
	matrix[1] = max(inputs[0],inputs[1])

	for i in range(2,len(inputs)):
		matrix[i] = max(inputs[i]+matrix[i-2],matrix[i-1])

	print matrix[-1]

if __name__ == '__main__':
	a = [1,8,6,3,6]
	independentSubset(a)
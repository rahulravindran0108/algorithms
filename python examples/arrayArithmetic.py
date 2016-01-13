def output(input):
	arra2 = [1 for i in range(len(input))]
	arra1 = [1 for i in range(len(input))]

	for i in range(1,len(input)):
	 	arra1[i] = input[i-1]*arra1[i-1]

	for i in range(len(input)-2,-1,-1):
		arra2[i] = input[i+1]*arra2[i+1]

	result = []
	for i in range(len(input)):
		result.append(arra1[i]*arra2[i])

	
if __name__ == '__main__':
	input = [1, 2, 3, 4, 5]
	output(input)
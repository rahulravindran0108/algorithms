#####
#    Rahul Ravindran - This is the problem to 
#####
def giveCandies(r):

	table = [1 for x in range(len(r))]

	

	for i in range(1,len(r)):
		if r[i] > r[i-1]:
			table[i] = table[i-1]+1 
	for i in range(len(r)-2,-1,-1):
		if(table[i] > table[i+1]):
			table[i] = max(table[i], table[i+1]+1)

	print sum(table)

if __name__ == '__main__':
	r = [1,2,2]
	giveCandies(r)

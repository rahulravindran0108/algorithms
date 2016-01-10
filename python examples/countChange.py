#####
#    Rahul Ravindran - Coin change Problem output the number of solutions
#####
def countChange(s,m,n):
	table = [[0 for i in range(m)] for j in range(n+1)]
	
	for i in range(m):
		table[0][i] = 1

	for i in range(1,n+1):
		for j in range(m):

			
			x = table[i-s[j]][j] if i-s[j] >= 0 else 0

			y = table[i][j-1] if j>= 1 else 0

			table[i][j] = x+y

	print table[n][m-1]

if __name__ == '__main__':
	s = [2,5,3,6]
	m = 4
	n = 10
	countChange(s,m,n)
	

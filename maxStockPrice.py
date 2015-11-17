def calc_max_list(prices):
    n = len(prices)
    maxl = [prices[n - 1]] * n
   
    for i in range(n - 2, -1, -1):
        maxl[i] = max(prices[i], maxl[i + 1])

    profit = 0
    stocks = 0
    for i,price in enumerate(prices):
    	if maxl[i] > price:
    		profit-=price
    		stocks+=1
    	elif maxl[i] == price:
    		profit+= price * stocks
    		stocks = 0
    return profit

if __name__ == '__main__':
	prices = [1, 2, 100]


	print calc_max_list(prices)
"""
Flowe problem hackerrank

You and your K-1 friends want to buy N flowers. Flower number i has cost ci.
Unfortunately the seller does not want just one customer to buy a lot of
flowers, so he tries to change the price of flowers for customers who have
already bought some flowers. More precisely, if a customer has already bought x
flowers, he should pay (x+1)*ci dollars to buy flower number i. 

You and your K-1 friends want to buy all N flowers in such a way that you spend
the least amount of money. You can buy the flowers in any order.  
"""

__author__ = 'Rahul Ravindran'

def flower(cost,k):
	cost = sorted(cost,reverse = True)
	unitCost = 0
	totalCost = 0
	groupCount = len(cost)/k+1

	for i in range(groupCount):
		unitCost = i+1
		totalCost += unitCost * sum(cost[i*k:(i+1)*k])
	print totalCost

if __name__ == '__main__':
	n,k = map(int, raw_input().strip().split(' '))
	c = map(int,raw_input().strip().split(' '))
	flower(c,k)
"""
Burger problem Hacker Rank

Problem Statement:
In Jim's Burger, n hungry burger fans are ordering burgers. The ith order is placed by the ith fan at ti time and it takes di time to procees. What is the order in which the fans will get their burgers?

Input Format 
On the first line you will get n, the number of orders. Then n lines will follow. On the (i+1)th line, you will get ti and di separated by a single space.

Output Format 
Print the order ( as single space separated integers ) in which the burger fans get their burgers. If two fans get the burger at the same time, then print the smallest numbered order first.(remember, the fans are numbered 1 to n).
"""


__author__ = 'Rahul Ravindran'

def burgerOptimization(events):
	n = len(events)
	idx = sorted(range(n),key = lambda k: events[k][0]+events[k][1])
	print " ".join(map(lambda x: str(x+1),idx))

if __name__ == '__main__':
	n = int(raw_input())
	input = []
	for i in range(n):
		t = map(int,raw_input().strip().split(' '))
		input.append(tuple(t))

	burgerOptimization(input)
	
""" 
Mark and Toys problem Hackerrank

Mark and Jane are very happy after having their first kid.  Their son is
very fond of toys, so Mark wants to buy some. There are N different toys lying
in front of him,  tagged with their prices, but he has only $K. He wants to
maximize the number of toys he buys with this money.

Now, you are Mark's best friend and have to help him buy as many toys as possible.
"""

__author__ = 'Rahul Ravindran'


def toyProblem(toysList, k):
	count = 0
	sums = 0
	sortedList = sorted(toysList)
	for i in range(len(sortedList)):
		if sums+sortedList[i]  > k:
			break
		else:
			sums+=sortedList[i]
			count+=1
	print count


if __name__ == '__main__':
	n, k = map(int,raw_input().strip().split(' '))
	input = map(int, raw_input().strip().split(' '))
	toyProblem(input, k)


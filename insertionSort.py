""" 
One common task for computers is to sort data. For example, people might
want to see all their files on a computer sorted by size. Since sorting is a
simple problem with many different possible solutions, it is often used to
introduce the study of algorithms.
"""

__author__ = 'Rahul Ravindran'

def insertionSort(ar):
	element = ar[-1]

	for i in range(len(ar)-2,-1,-1):
		if ar[i] > element:
			ar[i+1] = ar[i]
			print ' '.join(str(p) for p in ar) 
			if i ==0:
				ar[i] = element
				print ' '.join(str(p) for p in ar) 
		else:
			ar[i+1] = element
			print ' '.join(str(p) for p in ar) 
			break
	

if __name__ == '__main__':
	m = input()
	ar = [int(i) for i in raw_input().strip().split()]
	insertionSort(ar)



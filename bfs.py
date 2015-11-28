""" 
Given an undirected graph consisting of N nodes (labelled 1 to N) where a
specific given node S represents the start position and an edge between any
two nodes is of length 6 units in the graph.

It is required to calculate the shortest distance from start position (Node S)
to all of the other nodes in the graph.

"""
__author__ = 'Rahul Ravindran'

def breadthFirstSearch(graph, start):
	"""
	perform breadth first search to output the list
	"""


	visited, queue = set(), [start]


	results = {}
	result = {}
	result[start] = 0
	counter = 0
	while queue:
		vertex = queue.pop(0)
		if vertex not in visited:
			visited.add(vertex)

			for newNodes in graph[vertex] - visited:
				if newNodes not in queue:
					queue.append(newNodes)
					if newNodes not in result.keys():
						result[newNodes] = result[vertex]+6
			
	return result


if __name__ == '__main__':

	numberOfTestcases = int(raw_input())

	for testCases in range(numberOfTestcases):
		numberOfNodes, numberOfEdges = map(int,raw_input().strip().split(' '))

		graph = {}

		for x in range(1,numberOfNodes+1):
			graph[x] = set()

		
		for i in range(numberOfEdges):
			x,y = map(int,raw_input().strip().split(' '))
			graph[x].add(y)
			graph[y].add(x)
		
		start = int(raw_input())
		result = breadthFirstSearch(graph, start)
		#print result
		
		
		for i in range(1,numberOfNodes+1):
			if i == start:
				continue
			if i not in result.keys():
				print -1,
			else:
				print result[i],

		print ""

		



	


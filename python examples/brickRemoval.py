def brickRemovalGame(bricks):

	sums = [0 for _ in range(len(bricks))]
	matrix = [0 for _ in range(len(bricks))]

	for i in range(len(bricks)):
		sums[i] = sum(bricks[0:i+1])

	matrix[0] = bricks[0]
	matrix[1] = bricks[0]+bricks[1]
	matrix[2] = bricks[0]+bricks[1]+bricks[2]

	for i in range(3,len(bricks)):
		matrix[i] = max(bricks[i]+sums[i-1]-matrix[i-1],
						bricks[i]+bricks[i-1]+sums[i-2]-matrix[i-2],
						bricks[i]+bricks[i-1]+bricks[i-2]+sums[i-3]-matrix[i-3])

	print matrix
	
	

	

if __name__ == '__main__':
	bricks = [999, 1, 1, 1, 0]
	brickRemovalGame(bricks)

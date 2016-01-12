class MinCoinChangeProblem {


	static int getMinCoin(int [] values, int sum) {
		int min = 0;
		int [] minCoins = new int[sum+1];
		minCoins[0] = 0;

		for(int i=1;i<=sum;i++) {
			min = Integer.MAX_VALUE;

			for(int j=0;j<values.length;j++) {
				if(i >= values[j])
					min = Math.min(min, minCoins[i - values[j]]);
			}

			if(min!=Integer.MAX_VALUE)
				minCoins[i] = min+1;
			else
				minCoins[i] = Integer.MAX_VALUE;
		}

		return minCoins[sum];

	}

	public static void main(String[] args) {
		int [] values = {2,3,5};
		int sum = 7;

		System.out.println(getMinCoin(values, sum));
	}
}
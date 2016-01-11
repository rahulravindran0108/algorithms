// this is to find the longest increasing subsequence

class LongestSubsequence {

	public static void main(String[] args) {
		int [] input = {7, 2, 3, 1, 5, 8, 9, 6};

		int [] output = new int[input.length];

		for(int i=0;i<output.length;i++)
			output[i] = 1;

		int maxValue = 1;
		//iterative approach
		for(int i=1;i<input.length;i++) {
			for(int j=0;j<i;j++) {
				if(input[i] > input[j])
					output[i] = Math.max(output[i],output[j]+1);
			}
			maxValue = Math.max(maxValue, output[i]);
		}

		System.out.println(maxValue);

	}
}
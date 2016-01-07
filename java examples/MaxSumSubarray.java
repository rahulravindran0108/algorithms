//{1, -2, 3, 10, -4, 7, 2, -5}
class MaxSumSubarray {


	public static void main(String[] args) {
		int [] input = {1, -2, 3, 10, -4, 7, 2, -5};

		int [] mapper = new int[input.length];

		//initialize the first variable
		mapper[0] = input[0];

		for(int i=1;i<input.length;i++)
			mapper[i] = Math.max(mapper[i-1], mapper[i-1]+input[i]);
		System.out.println(mapper[input.length-1]);
	}
}
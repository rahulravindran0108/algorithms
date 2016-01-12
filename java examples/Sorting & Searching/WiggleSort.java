/*

Given an unsorted array nums, reorder it in-place such that
nums[0] <= nums[1] >= nums[2] <= nums[3]....

Input: 3, 5, 1, 6, 2, 4


Output: 3 5 1 6 2 4 

*/

class WiggleSort{

	static void wiggleSort(int [] nums) {
		if(nums == null || nums.length < 1)
			return;
		for(int i=0;i<nums.length-1;i++) {
			if(i%2==0) {
				if(nums[i] > nums[i+1]) {
					nums = swap(nums,i,i+1);
				}
			} else {
				if(nums[i] < nums[i+1])
					nums = swap(nums,i,i+1);
			}
		}

		display(nums);
	}

	static void display(int [] nums) {
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
		System.out.println();
	}

	static int [] swap(int [] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

		return nums;
	}

	public static void main(String[] args) {
		int [] input = {3, 5, 2, 1, 6, 4};
		wiggleSort(input);
	}
}
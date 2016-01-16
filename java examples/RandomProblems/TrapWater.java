/*
Given n non-negative integers representing an elevation map 
where the width of each bar is 1, compute how much water it
 is able to trap after raining.
*/
import java.util.*;

class TrapWater {

	static void computeTrapWater(int [] input, int n) {
		int [] left = new int[n];
		int [] right = new int[n];

		left[0] = input[0];
		for(int i=1;i<left.length;i++)
			left[i] = Math.max(left[i-1],input[i]);

		right[n-1] = input[n-1];
		for (int i = n-2; i >= 0; i--)
       		right[i] = Math.max(right[i+1], input[i]);

       	int water = 0;

       	for(int i=0;i<n;i++) 
       		water+= Math.min(left[i],right[i]) - input[i];

       	System.out.println(water);
       	
	}

	public static void main(String[] args) {
		int [] input = {3, 0, 0, 2, 0, 4};
		computeTrapWater(input, input.length);
	}
}
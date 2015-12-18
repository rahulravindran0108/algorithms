/*
A child is running up a staircase with n steps,
 and can hop either 1step, 2 steps, or 3 steps at a time. 
 Implement a method to count how many possible ways the child can run up the stairs.
*/

 class CountSteps {

 	public static int countWays(int n) {
 		if(n < 0)
 			return 0;
 		else if(n == 0)
 			return 1;
 		else
 			return countWays(n-1) + countWays(n-2) +countWays(n-3);
 	}

 	public static void main(String [] args) {
 		System.out.println(countWays(5));
 	}
 }